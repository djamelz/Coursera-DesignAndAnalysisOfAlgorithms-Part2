package week1

import scala.annotation.tailrec
import scala.io.Source
import scala.math.BigInt.int2bigInt

object SchedulingApplication {

  def algo1(x: (Int, Int), y: (Int, Int)) = {
    val Cx = x._1 - x._2
    val Cy = y._1 - y._2
    if (Cx == Cy)
      x._1 > y._1
    else
      Cx > Cy
  }
  def algo2(x: (Int, Int), y: (Int, Int)) = x._1 / x._2.toFloat > y._1 / y._2.toFloat

  def fileToList(path: String) = Source.fromFile(path).getLines().toList.tail.map({ x => val t = x.split(" "); (t(0).toInt, t(1).toInt) })

  def question1(path: String): BigInt = weightedSumOfCompletionTimes(fileToList(path))(algo1)
  def question2(path: String): BigInt = weightedSumOfCompletionTimes(fileToList(path))(algo2)

  def weightedSumOfCompletionTimes(path: List[(Int, Int)])(algo: ((Int, Int), (Int, Int)) => Boolean): BigInt = {
    @tailrec
    def weightedSumOfCompletionTimesIt(lines: List[(Int, Int)], currentCompletionTimes: Int, sum: BigInt): BigInt = lines match {
      case Nil => sum
      case head :: tail => weightedSumOfCompletionTimesIt(tail, currentCompletionTimes + head._2, sum + (head._1 * (currentCompletionTimes + head._2)))
    }
    weightedSumOfCompletionTimesIt(path.sortWith((x, y) => algo(x, y)), 0, 0)
  }

}