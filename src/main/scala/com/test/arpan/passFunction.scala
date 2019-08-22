package com.test.arpan

object passFunction {

  def main(args: Array[String]): Unit = {


    val result = function(fake)

    val results = operations(addition, 2, 1)
    println(results)
  }

  def function(fn :() => String): Unit ={
    println(fn())
  }

  def fake(): String ={
    "sdojnpdka"
  }

  def operations(ftn:(Int, Int) => Int, a: Int , b: Int):Int={
    return ftn(a, b)
  }

  def addition(a: Int, b : Int): Int = {
    return a + b
  }

  def substract(a: Int, b : Int): Int = {
    return a - b
  }

  def divide(a: Int, b : Int): Int = {
    if(b != 0)
      a / b
    else
      0
  }

  def multiplication(a: Int, b : Int): Int = {
    return a * b
  }


}
