package com.test.arpan.collections

object ListPOC {

  def main(args: Array[String]): Unit = {

    val a = List(List("a1","l1","as1","sdqwe1"),
      List("a2","l2","as2","sdqwe2"),
      List("a3","l3","as3","sdqwe3"),
      List("a4","l4","as4","sdqwe4"))

//    a.flatten.foreach(x => print(_))



    val b = List("a","b","c","c")

    val c = b.foldLeft(""){ (m: String , n : String) => (m+n)}


    println(c)


  }

}
