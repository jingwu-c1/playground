import com.amazonaws.auth.{
  AWSStaticCredentialsProvider,
  AnonymousAWSCredentials
}
import com.amazonaws.services.s3.model.ListObjectsRequest
import com.amazonaws.services.s3.{AmazonS3, AmazonS3ClientBuilder, AmazonS3URI}

import scala.collection.JavaConverters._

object AwsS3Helper {
  def main(args: Array[String]): Unit = {
    val awsS3Client = AmazonS3ClientBuilder
      .standard()
      .withCredentials(
        new AWSStaticCredentialsProvider(new AnonymousAWSCredentials()))
      .build()
    val s3Url = new AmazonS3URI("s3://c1-npsl/")
    val listObjectsRequest = new ListObjectsRequest()
      .withBucketName(s3Url.getBucket)
      .withPrefix(s3Url.getKey)
    listAllObjects(listObjectsRequest, awsS3Client).foreach(println(_))
  }

  /**
    * Requirement:
    * Return all file keys. Be aware, when there are too many objects, check isTruncated field on ObjectListing
    * Run this module and check output result; pass all unit tests.
    * Avoid local variable, use val instead if needed.
    *
    * @param request
    * @param awsS3Client
    * @return
    */
  def listAllObjects(request: ListObjectsRequest,
                     awsS3Client: AmazonS3): Seq[String] = {
    throw new NotImplementedError()
  }
}
