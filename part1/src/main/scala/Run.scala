object Run {
  def main(args: Array[String]): Unit = {
    val arr = new Array[Array[Int]](6)
    arr(0) = Array(1, 1, 1, 0, 0, 0)
    arr(1) = Array(0, 1, 0, 0, 0, 0)
    arr(2) = Array(1, 1, 1, 0, 0, 0)
    arr(3) = Array(0, 0, 2, 4, 4, 0)
    arr(4) = Array(0, 0, 0, 2, 0, 0)
    arr(5) = Array(0, 0, 1, 2, 4, 0)

    val hourglass = new Hourglass()

    println(s"Result is ${hourglass.hourglassSum(arr)}")
  }
}
