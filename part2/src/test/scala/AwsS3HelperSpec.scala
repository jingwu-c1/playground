import java.util.UUID

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.{
  ListObjectsRequest,
  ObjectListing,
  S3ObjectSummary
}
import org.mockito.Mockito.{times, verify, when}
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FlatSpec, Matchers}

import scala.collection.JavaConverters._

class AwsS3HelperSpec extends FlatSpec with MockitoSugar with Matchers {

  it should "get all s3 items not truncated " in {

    // Arrange
    val s3Client = mock[AmazonS3]
    val request = mock[ListObjectsRequest]
    val objectListing1 = mock[ObjectListing]
    val s3ObjectSummaries1 = (0 to 10).map { _ =>
      val summary = new S3ObjectSummary()
      summary.setKey(UUID.randomUUID().toString.replace("-", ""))
      summary
    }

    when(objectListing1.isTruncated).thenReturn(false)
    when(objectListing1.getObjectSummaries)
      .thenReturn(s3ObjectSummaries1.asJava)

    val objectListing2 = mock[ObjectListing]
    when(objectListing2.isTruncated).thenReturn(false)
    val s3ObjectSummaries2 = Seq.empty[S3ObjectSummary]
    when(objectListing2.getObjectSummaries)
      .thenReturn(s3ObjectSummaries2.asJava)

    when(s3Client.listObjects(request)).thenReturn(objectListing1)
    when(s3Client.listNextBatchOfObjects(objectListing1))
      .thenReturn(objectListing2)

    // Act
    val fileNames = AwsS3Helper.listAllObjects(request, s3Client)

    // Assert
    verify(s3Client, times(1)).listObjects(request)

    fileNames.toSet shouldEqual s3ObjectSummaries1.map(_.getKey).toSet
  }

  it should "get all s3 items truncated " in {

    // Arrange
    val s3Client = mock[AmazonS3]
    val request = mock[ListObjectsRequest]
    val objectListing1 = mock[ObjectListing]
    val s3ObjectSummaries1 = (0 to 10).map { _ =>
      val summary = new S3ObjectSummary()
      summary.setKey(UUID.randomUUID().toString.replace("-", ""))
      summary
    }

    when(objectListing1.isTruncated).thenReturn(true)
    when(objectListing1.getObjectSummaries)
      .thenReturn(s3ObjectSummaries1.asJava)

    val objectListing2 = mock[ObjectListing]
    when(objectListing2.isTruncated).thenReturn(false)
    val s3ObjectSummaries2 = (0 to 15).map { _ =>
      val summary = new S3ObjectSummary()
      summary.setKey(UUID.randomUUID().toString.replace("-", ""))
      summary
    }
    when(objectListing2.getObjectSummaries)
      .thenReturn(s3ObjectSummaries2.asJava)

    val objectListing3 = mock[ObjectListing]
    when(objectListing3.isTruncated).thenReturn(false)
    val s3ObjectSummaries3 = Seq.empty[S3ObjectSummary]
    when(objectListing3.getObjectSummaries)
      .thenReturn(s3ObjectSummaries3.asJava)

    when(s3Client.listObjects(request)).thenReturn(objectListing1)
    when(s3Client.listNextBatchOfObjects(objectListing1))
      .thenReturn(objectListing2)
    when(s3Client.listNextBatchOfObjects(objectListing2))
      .thenReturn(objectListing3)

    // Act
    val fileNames = AwsS3Helper.listAllObjects(request, s3Client)

    // Assert
    verify(s3Client, times(1)).listObjects(request)

    fileNames.toSet shouldEqual (s3ObjectSummaries1 ++ s3ObjectSummaries2)
      .map(_.getKey)
      .toSet
  }
}
