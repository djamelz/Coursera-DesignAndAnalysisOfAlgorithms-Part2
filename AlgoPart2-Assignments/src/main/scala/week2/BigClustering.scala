package week2

import scala.collection.mutable.PriorityQueue
import scala.io.Source



object BigClustering {
  
  
  def process(filePath : String) : Int = {

    val heap = new PriorityQueue[(Int, (Int, Int))]()(Ordering.by(x => -1 * x._1))
    
    val content = Source.fromFile(filePath).getLines.toList.map(_.trim())
    
    val infos = content.head.split(" ").map(_.toInt)
                                                  
	val lines = content.zipWithIndex.tail.toMap
	
	val unionFind = new UnionFind(infos(0))
	var currentK = lines.size
                                                  
	
	lines.foreach({
		x =>
		generateDistance(x._1.split(" ").map(xx => xx.toInt)).foreach{ y =>
			lines.get(y._1) match{
				case Some(z) if (x._2 != z) => 
				  heap.enqueue((y._2, (x._2, z)))
				case _ =>
	}}})
	
	val t = heap.size
	
	while (heap.size > 0) {
      heap.dequeue match {
        case (weight, (node1, node2)) if (!unionFind.find(node1, node2)) =>
            unionFind.union(node1, node2)
            currentK -= 1

        case _ =>
      }
    }
    
    return currentK
    
  }
  
  //TODO: refactor this crapy method with more advanced algo
  def generateDistance(x : Array[Int]) : List[(String, Int)] = {
		var ret = List((x.mkString(" "), 0))
		for(i <- 0 until x.size)
		{
			val b = x.clone
			b.update(i, x(i)^1)
			ret = (b.mkString(" "), 1) :: ret
			for(j <- i+1 until x.size)
			{
				val c = b.clone
				c.update(j, x(j) ^1)
				ret = (c.mkString(" "), 2) :: ret
			}
		}
		ret
	}

}