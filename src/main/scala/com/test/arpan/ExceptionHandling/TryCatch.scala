package com.test.arpan.ExceptionHandling

import scala.collection.mutable.ListBuffer
import scala.util.Random
import scala.util.control.NonFatal

object TryCatch {

  def main(args: Array[String]): Unit = {

    val lst = new ListBuffer[Int]
    for(i <- 0 to 9)
      lst+=Random.nextInt(10)

    lst.foreach(println(_))

    println("\n\n\n-----\n\n\n")

    lst.foreach(x => divideByZero(x))
  }

  def divideByZero(a: Int): Unit ={
    val number = 45
    try {
      println(number/a)
    }catch {
      case e : ArithmeticException => println("Arithmatic exception" + e)
      case NonFatal(x) => println("Inside nonFatal case statement" + x)
      case _ => println("Dont know why happened")
    }
  }


}
