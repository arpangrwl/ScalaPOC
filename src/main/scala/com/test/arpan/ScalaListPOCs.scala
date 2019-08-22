package com.test.arpan

import scala.collection.mutable.ListBuffer
import scala.util.Random

object ScalaListPOCs {

  def main(args: Array[String]): Unit = {

//    val totalEmp = List(emp("Arpan", 31, 12000), emp("Nipun", 25, 2000),emp("Nishtha", 30, 4000),emp("Rohit", 35, 12000),emp("Rohan", 31, 14000),emp("Sohan", 32, 14000))
//
//    totalEmp.sortBy(x => x.name.charAt(x.name.length -1 )).foreach(x => if(filterName(x.name.charAt(0)))println(x.name))
//
//    val c = "hello"


    val aa = List(12, 123 , 43 , 15, 87, 34, 97, 112)

    aa.map(x => println(x))


  }

  def filterName(startWith : Char) : Boolean = {
    if(startWith == 'N') false else true
  }


  def printlst( lst : List[String]) {
    lst.foreach( x => println(x))

    println("---------------")
  }


  def aRandomList():ListBuffer[Int] ={

    var a =  new ListBuffer[Int]()

    for(i <- 0 to 9){
      a+= Random.nextInt(1000)
    }

    a
  }






}




case class emp(name : String , age : Int , salary : Long) {}