package week1

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner



@RunWith(classOf[JUnitRunner])
class SchedulingApplicationSuite extends FunSuite {
  
  test("weightedSumOfCompletionTimes with algo1"){
    val actual = SchedulingApplication.weightedSumOfCompletionTimes(List((3, 5), (1, 2)))(SchedulingApplication.algo1)
    assert(actual == 23)
  }
  
  test("weightedSumOfCompletionTimes with algo1 equal difference 1"){
    val actual = SchedulingApplication.weightedSumOfCompletionTimes(List((3, 5), (1, 2), (99, 100)))(SchedulingApplication.algo1)
    assert(actual == 10323)
  }
  
  test("weightedSumOfCompletionTimes with algo1 equal difference 2"){
    val actual = SchedulingApplication.weightedSumOfCompletionTimes(List((3, 5), (99, 100), (1, 2)))(SchedulingApplication.algo1)
    assert(actual == 10323)
  }
  
  test("weightedSumOfCompletionTimes with algo2"){
    val actual = SchedulingApplication.weightedSumOfCompletionTimes(List((3, 5), (1, 2)))(SchedulingApplication.algo2)
    assert(actual == 22)
  }
  
  test("question 1"){
    val actual = SchedulingApplication.question1(getClass().getResource("/Week1/jobs.txt").getPath())
    
    assert(actual == BigInt("69119377652"))
  }
  
  test("question 2"){
    val actual = SchedulingApplication.question2(getClass().getResource("/Week1/jobs.txt").getPath())
    assert(actual == BigInt("67311454237"))
  }

}