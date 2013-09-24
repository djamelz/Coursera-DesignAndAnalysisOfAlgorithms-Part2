package week3

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class KnapsackDPSuite extends FunSuite {
  
  test("artefactor") {
    val lines = List ("8 4", "10 5", "15 8", "4 3")
    val expected = List(KnapsackBB.Artefact(10, 5, 1), KnapsackBB.Artefact(8, 4, 0), KnapsackBB.Artefact(15, 8, 2), KnapsackBB.Artefact(4, 3, 3))
    val actual = KnapsackBB.artefactor(lines)
    assert(expected == actual)
  }
  
  test("knapsack") {
    val lines = List(KnapsackBB.Artefact(15, 8, 2),  KnapsackBB.Artefact(10, 5, 1), KnapsackBB.Artefact(8, 4, 0), KnapsackBB.Artefact(4, 3, 3))
    val actual = KnapsackBB.branchAndBound(lines, 11)
    assert(actual == KnapsackBB.BBItem(19,19f,List(3, 2)))
  }
  
  test("Solve test"){
    val actual = KnapsackBB.solve(getClass().getResource("KnapsackTest.txt").getPath())
    assert(actual == 29)
  }
  
  test("Solve Q1"){
    val actual = KnapsackBB.solve(getClass().getResource("knapsack1.txt").getPath())
    //println(actual)
    assert(actual == 2493893)
  }
  
  test("Solve Q2"){
    val actual = KnapsackBB.solve(getClass().getResource("knapsack_big.txt").getPath())
    //println(actual)
    assert(actual == 4243395)
  }

}