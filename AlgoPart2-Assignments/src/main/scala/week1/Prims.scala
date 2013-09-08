package week1

import scala.collection.mutable.Map
import scala.io.Source
import scala.collection.mutable.PriorityQueue

object Prims {

  type Graph = Map[Int, List[(Int, Int)]]
  
  def createGraph(path: String) : Graph = {
    var graph = Map[Int, List[(Int, Int)]]()
    Source.fromFile(path).getLines.toList.tail.foreach(
      {
        x =>
          val s = x.split(" ").map(_.toInt);
          graph(s(0)) = graph.getOrElse(s(0), List()) :+ (s(1), s(2));
          graph(s(1)) = graph.getOrElse(s(1), List()) :+ (s(0), s(2));
      })
    graph
  }
  
  def findSpanningTree(graph : Graph) : Int = {
    val heap = new PriorityQueue[(Int, Int)]()(Ordering.by(-1 * _._2))
    val weights = Map[Int, Int]()
    
    weights += graph.head._1 -> 0
    graph.head._2.foreach(heap.enqueue(_))
    
    while( !heap.isEmpty || weights.size != graph.size)
    {
      val edge = heap.dequeue
      if( !weights.contains(edge._1))
      {
        weights += edge._1 -> edge._2
        graph(edge._1).foreach(heap.enqueue(_))
      }
    }
    
    weights.map(_._2).sum
  }
  
  def question3(path : String) : Int = findSpanningTree(createGraph(path))
}