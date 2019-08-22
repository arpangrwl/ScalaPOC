package com.test.arpan.Traits

trait firstTrain{
  def function1: Unit = {
    println("trait firstTrain")
  }
}

class TraitPOC extends firstTrain{

  override def function1: Unit = {
    println("class TraitPOC extends firstTrain")
  }


}


object TraitPOC{

  def main(args: Array[String]): Unit = {

    val traitObj = new TraitPOC
    traitObj.function1


    
  }
}