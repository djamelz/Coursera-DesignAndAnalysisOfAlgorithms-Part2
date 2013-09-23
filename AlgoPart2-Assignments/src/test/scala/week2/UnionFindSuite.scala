package week2

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class UnionFindSuite extends FunSuite {
  
  test("find"){
    val unionFind = new UnionFind(10)
    
    (1 to 10).foreach(x => assert(x == unionFind.find(x)))
  }
  
  test("simple union"){
    val unionFind = new UnionFind(10)
    unionFind.union(1, 2)
    
    assert(unionFind.find(1, 2))
  }
  
  test("complex union"){
    val unionFind = new UnionFind(10)
    unionFind.union(1, 2)
    unionFind.union(9, 10)
    unionFind.union(9, 8)
    unionFind.union(2, 8)
    
    assert(unionFind.find(1, 2))
    assert(unionFind.find(1, 8))
    assert(unionFind.find(1, 9))
    assert(unionFind.find(1, 10))
    assert(!unionFind.find(1, 7))
  }

}