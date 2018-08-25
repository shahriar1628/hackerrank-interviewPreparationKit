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

  // Complete the minimumBribes function below.
  def minimumBribes(q: Array[Int]) : Int =  {
    var maxSwap = 0
    var totalBribe = 0
    var sorted = false
    for( i <- 0 until q.length-1) {
      for ( j <- 0 until q.length -1 -i) {
        if(j ==0) maxSwap = 0
        if(q(j) > q(j+1)) {
          //println(j)
          if(maxSwap==2) return -1
          maxSwap = maxSwap + 1
          totalBribe = totalBribe + 1
          var temp = q(j)
          q(j) = q(j+1)
          q(j+1) = temp
          sorted = true
        } else {
          maxSwap = 0
        }

      }
      maxSwap = 0;
      if(sorted == false)
        return totalBribe
      else
        sorted = false
    }
    return totalBribe
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val t = stdin.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val n = stdin.readLine.trim.toInt

      val q = stdin.readLine.split(" ").map(_.trim.toInt)
      var result = minimumBribes(q)
      //   println("llll")
      if(result <0)
        println("Too chaotic")
      else
        println(result)
    }
  }
}
