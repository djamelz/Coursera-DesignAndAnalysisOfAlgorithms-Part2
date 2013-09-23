package week2

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class BigClusteringSuite extends FunSuite {

  test("clustering_bigtest") {
    val actual = BigClustering.process(getClass().getResource("clustering_bigtest.txt").getPath())
    println(actual)

    assert(6 == actual)
  }

  test("clustering_bigtest2") {
    val actual = BigClustering.process(getClass().getResource("clustering_bigtest2.txt").getPath())
    println(actual)

    assert(4 == actual)
  }

  test("clustering_big") {
    val actual = BigClustering.process(getClass().getResource("clustering_big.txt").getPath())
    println(actual)

    assert(6118 == actual)
  }

}