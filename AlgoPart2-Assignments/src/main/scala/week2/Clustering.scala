package week2

import scala.collection.mutable.PriorityQueue
import scala.io.Source
import breeze.linalg.DenseMatrix
//import breeze.io.CSVReader
import breeze.linalg
import java.io.File

object Clustering {

  def process(filePath: String, k: Int): Int = {
    val info = processFile(filePath)
    val unionFind = new UnionFind(info._1)

    val heap = new PriorityQueue[(Int, (Int, Int))]()(Ordering.by(x => -1 * x._1)) ++ info._2

    var currentK = info._1

    while (heap.size > 0) {
      heap.dequeue match {
        case (weight, (node1, node2)) if (!unionFind.find(node1, node2)) =>
          if (currentK == k) {
            return weight
          } else {
            unionFind.union(node1, node2)
            currentK -= 1
          }

        case _ =>
      }
    }
    0
  }

  def processFile(filePath: String): (Int, List[(Int, (Int, Int))]) = {
    val lines = Source.fromFile(filePath).getLines.toList
    (lines.head.toInt, lines.tail.view.map(x => (x.split(" ")).map(_.toInt)).map(y => (y(2).toInt, (y(0).toInt, y(1).toInt))).toList)
  }
}