package week1

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import scala.collection.mutable.Map

@RunWith(classOf[JUnitRunner])
class PrimsSuite extends FunSuite {
  
  test("createGraph"){
    val expected = Map(1 -> List((2, 1), (3, 3), (4, 4)), 2 -> List((1, 1), (3, 2)), 3 -> List((1, 3), (2, 2), (4, 5)), 4 -> List((1, 4), (3, 5)))
    val actual = Prims.createGraph(getClass().getResource("/Week1/graphLectureTest.txt").getPath())
    assert(actual.size === expected.size)
    expected.foreach({x =>
      assert(actual(x._1).size == x._2.size)
      actual(x._1).foreach( y => assert(x._2.contains(y)))
    })
  }
  
  test("findSpanningTree"){
    val graph = Map(1 -> List((2, 1), (3, 3), (4, 4)), 2 -> List((1, 1), (3, 2)), 3 -> List((1, 3), (2, 2), (4, 5)), 4 -> List((1, 4), (3, 5)))
    val actual = Prims.findSpanningTree(graph)
    assert(actual == 7)
  }
  
  test("question3 testcase1"){
    val actual = Prims.question3(getClass().getResource("/Week1/graphTestCase1.txt").getPath())
    assert(actual == -10)
  }
  
  test("question3"){
    val actual = Prims.question3(getClass().getResource("/Week1/edges.txt").getPath())
    assert(actual == -3612829)
  }
}