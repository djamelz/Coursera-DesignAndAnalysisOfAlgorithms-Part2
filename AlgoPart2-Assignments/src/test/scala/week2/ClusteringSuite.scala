package week2

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class ClusteringSuite extends FunSuite {
  
  test("clustering1test"){
    val actual = Clustering.process(getClass().getResource("clustering1test.txt").getPath(), 4)
    assert(7 == actual)
  }
  
  test("clustering1test2"){
    val actual = Clustering.process(getClass().getResource("clustering1test2.txt").getPath(), 4)
    assert(8 == actual)
  }
  
  test("clustering1"){
    val actual = Clustering.process(getClass().getResource("clustering1.txt").getPath(), 4)
    assert(106 == actual)
  }

}