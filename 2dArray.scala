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

  // Complete the hourglassSum function below.


  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val arr = Array.ofDim[Int](6, 6)

    for (i <- 0 until 6) {
      arr(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result = hourglassSum(arr)

    printWriter.println(result)

    printWriter.close()
  }

  def  hourglassSum(arr:Array[Array[Int]]): Int =  {
    var result: Int = -10000
    val dx: Array[Int] = Array(0,1,-1,0,0,1,-1)
    val dy: Array[Int] = Array(0,0,0,1,2,2,2)
    for( i <- 0 until  arr.length;
         j <- 0 until  arr(0).length) {
      if(checkvalidity(arr.length-1,arr(0).length-1,j,i) == true) {
        var ky = 0
        var sum = 0
        for (kx <- dx) {
          sum = sum + arr(i+dy(ky))(j+kx)
          ky =1 +ky
        }
        if(sum > result) {
          result = sum
        }

      }
    }
    return result
  }
  def checkvalidity(row: Int,clm:Int,x:Int,y:Int) : Boolean = {
    if (x == 0 || x == clm) return false
    if( y >= row-1) return false
    return true

  }
}
