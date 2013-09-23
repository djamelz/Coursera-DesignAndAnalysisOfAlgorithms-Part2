package week2

import scala.annotation.tailrec

class UnionFind(private val tree : Array[(Int, Int)], nodeNumber : Int) {
  
  def this(nodeNumber : Int){
    this((1 to nodeNumber).map(x => (x, 0)).toArray, nodeNumber)
  }
  
  @tailrec
  private def findTuple(node : Int): (Int, Int) = tree(node - 1) match{
    case x if(x._1 == node) => x
    case x => findTuple(x._1)
  }
  
  def find(node: Int) = findTuple(node)._1
  
  
  def find(node1 : Int, node2 : Int) : Boolean = find(node1) == find(node2)
  
  def union(node1 : Int, node2 : Int) {
    val x =findTuple(node1)
    val y =findTuple(node2)
    if (x._2 > y._2)
      assign(x, y)
    else
      assign(y, x)
  }
  
  private def assign(node1 : (Int, Int), node2 : (Int, Int))
  {
    tree(node1._1 - 1) = (node1._1, node1._2 + node2._2 + 1)
    tree(node2._1 - 1) = (node1._1, 0)
  }

}