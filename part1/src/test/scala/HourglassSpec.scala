import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FlatSpec, Matchers}

class HourglassSpec extends FlatSpec  with MockitoSugar  with Matchers {

  it should "calculate hourglass 1" in {

    // Arrange
    val arr = new Array[Array[Int]](6)
    arr(0) = Array(1, 1, 1, 0, 0, 0)
    arr(1) = Array(0, 1, 0, 0, 0, 0)
    arr(2) = Array(1, 1, 1, 0, 0, 0)
    arr(3) = Array(0, 0, 2, 4, 4, 0)
    arr(4) = Array(0, 0, 0, 2, 0, 0)
    arr(5) = Array(0, 0, 1, 2, 4, 0)

    // Act
    val hourglass = new Hourglass()

    // Assert
    assert(hourglass.hourglassSum(arr) === 19)
  }

  it should "calculate hourglass 2" in {

    // Arrange
    val arr = new Array[Array[Int]](6)
    arr(0) = Array(-9, -9, -9, 1, 1, 1)
    arr(1) = Array(0, -9, 0, 4, 3, 2)
    arr(2) = Array(-9, -9, -9, 1, 2, 3)
    arr(3) = Array(0, 0, 8, 6, 6, 0)
    arr(4) = Array(0, 0, 0, -2, 0, 0)
    arr(5) = Array(0, 0, 1, 2, 4, 0)

    // Act
    val hourglass = new Hourglass()

    // Assert
    assert(hourglass.hourglassSum(arr) === 28)
  }

  it should "calculate hourglass 3" in {

    // Arrange
    val arr = new Array[Array[Int]](6)
    arr(0) = Array(1, 1, 1, 0, 0, 0)
    arr(1) = Array(0, 1, 0, 0, 0, 0)
    arr(2) = Array(1, 1, 1, 0, 0, 0)
    arr(3) = Array(0, 9, 2, -4, -4, 0)
    arr(4) = Array(0, 0, 0, -2, 0, 0)
    arr(5) = Array(0, 0, -1, -2, -4, 0)

    // Act
    val hourglass = new Hourglass()

    // Assert
    assert(hourglass.hourglassSum(arr) === 13)
  }

  it should "calculate hourglass 4" in {

    // Arrange
    val arr = new Array[Array[Int]](6)
    arr(0) = Array(-1, 1, -1, 0, 0, 0)
    arr(1) = Array(0, -1, 0, 0, 0, 0)
    arr(2) = Array(-1, -1, -1, 0, 0, 0)
    arr(3) = Array(0, -9, 2, -4, -4, 0)
    arr(4) = Array(-7, 0, 0, -2, 0, 0)
    arr(5) = Array(0, 0, -1, -2, -4, 0)

    // Act
    val hourglass = new Hourglass()

    // Assert
    assert(hourglass.hourglassSum(arr) === 0)
  }

  it should "calculate hourglass 5" in {

    // Arrange
    val arr = new Array[Array[Int]](6)
    arr(0) = Array(-1, -1, 0, -9, -2, -2)
    arr(1) = Array(-2, -1, -6, -8, -2, -5)
    arr(2) = Array(-1, -1, -1, -2, -3, -4)
    arr(3) = Array(-1, -9, -2, -4, -4, -5)
    arr(4) = Array(-7, -3, -3, -2, -9, -9)
    arr(5) = Array(-1, -3, -1, -2, -4, -5)

    // Act
    val hourglass = new Hourglass()

    // Assert
    assert(hourglass.hourglassSum(arr) === -6)
  }

  it should "calculate hourglass 6" in {

    // Arrange
    val arr = new Array[Array[Int]](6)
    arr(0) = Array(0, -4, -6, 0, -7, -6)
    arr(1) = Array(-1, -2, -6, -8, -3, -1)
    arr(2) = Array(-8, -4, -2, -8, -8, -6)
    arr(3) = Array(-3, -1, -2, -5, -7, -4)
    arr(4) = Array(-3, -5, -3, -6, -6, -6)
    arr(5) = Array(-3, -6, 0, -8, -6, -7)

    // Act
    val hourglass = new Hourglass()

    // Assert
    assert(hourglass.hourglassSum(arr) === -19)
  }
}
