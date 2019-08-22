package com.test.arpan.Recursion

class ExampleOne {

  def regularFactorial(n: Int): Long = {
    var retVal: Long = 1
    for (i <- n to 1 by -1) {
      retVal = retVal * i
    }
    retVal
  }

  def recursiveFactorial(n: Int): Long = {
    if(n > 1)
      n * recursiveFactorial(n-1)
    else
      1
  }

}

object ExampleOne {

  def main(args: Array[String]): Unit = {

    val obj = new ExampleOne
    println(obj.regularFactorial(6))


  }
}
