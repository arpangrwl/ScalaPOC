package com.test.arpan.ExceptionHandling

import scala.collection.mutable.ListBuffer
import scala.util.Random
import scala.util.control.NonFatal

class EitherClass {
  def divideByZero(a: Int) : Either[String, Int] ={
    val num : Int = 46
    try{
      Right(46/a)
    }catch {
      case e:ArithmeticException => Left("Divide by Zero Exception")
      case NonFatal(z) => Left("Some NonFatal exception" +z)
      case _ => Left("Unknown exception")
    }
  }
}

object EitherClass{

  def main(args: Array[String]): Unit = {

    val eithr = new EitherClass

    val lst = new ListBuffer[Int]
    for(i <- 0 to 9)
      lst+=Random.nextInt(10)

    lst foreach println

    println("\n\n\n-----\n\n\n")

    lst.foreach(x => {
      eithr.divideByZero(x) match{
        case Left(a) => println("Answer is left of this: " + a)
        case Right(b) => println("Answer is Right of that: " + b)
      }
    })
  }

}
