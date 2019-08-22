package com.test.arpan

class ScalaOptions {

}

object ScalaOptions{

  def main(args: Array[String]): Unit = {

    val capital = Map("India" -> "Delhi", "USA" -> "Washington DC", "France" -> "Paris")

    println(capital.get("India").getOrElse(""))
    println(capital.get("Pakistan").getOrElse(""))


    println(divideByZero(12,3).getOrElse(0))

  }


  def divideByZero(a: Int , b : Int) : Option[Int] ={
    if (b == 0) None
    else
      Some(a/b)
  }



}