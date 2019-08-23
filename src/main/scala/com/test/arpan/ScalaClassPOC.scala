package com.test.arpan

object ScalaClassPOC extends App{

  class amount(var value : Double ,  Curr: String){
    override def toString():String = {
      s"value is : ${value} and Currency is : ${Curr}"
    }

  }


  val twoDollar = new amount(2.0, "usd")
  println(twoDollar)

  twoDollar.value = 30

  println(twoDollar)


}

