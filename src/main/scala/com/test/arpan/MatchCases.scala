package com.test.arpan

import scala.collection.mutable.ListBuffer
import scala.util.Random

object MatchCases {

  def main(args: Array[String]): Unit = {


    val aa = new ListBuffer[Int]

    for(i <- 0 to 10){
      aa += Random.nextInt(1000)
    }

    aa.foreach(println(_))

    aa.foreach( x => {
      x/100 match {
        case 3 => println("Print the value of 3 :-  " + x)
        case 4 => println("Print the value of 4 :-  " + x)
        case 5 => println("Print the value of 5 :-  " + x)
        case 6 => println("Print the value of 6 :-  " + x)
        case 7 => println("Print the value of 7 :-  " + x)
        case _ => println("Print the value of rest of it :-  " + x)
      }
    })



  }

}
