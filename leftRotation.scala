import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object Solution {

  // Complete the rotLeft function below.
  def rotLeft(a: Array[Int], d: Int): Array[Int] = {
    var result: Array[Int] = new Array[Int](a.length)
    var k:Int = 0
    for( x <- a) {
      var newPosition = (k-d) % a.length
      if(newPosition <0) newPosition = a.length + newPosition
      result(newPosition) = x
      k = k+1
    }
    return result

  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nd = stdin.readLine.split(" ")

    val n = nd(0).trim.toInt

    val d = nd(1).trim.toInt

    val a = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = rotLeft(a, d)

    printWriter.println(result.mkString(" "))

    printWriter.close()
  }
}
