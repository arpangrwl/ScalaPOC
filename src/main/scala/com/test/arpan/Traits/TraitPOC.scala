package com.test.arpan.Traits

trait firstTrain{
  def function1: Unit = {
    println("trait firstTrain")
  }

  def asd :Unit = ???
}

trait firstTrain_1{
  def function1: Unit = {
    println("trait firstTrain_1")
  }

  def asd_1 :Unit = ???

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


case class extendsFirstTrait(name : String ) extends firstTrain(name) { // with firstTrain_1{

  def main(args: Array[String]): Unit = {

    val obj = extendsFirstTrait("Arpan")

    obj.function1

  }
}