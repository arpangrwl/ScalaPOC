package com.test.arpan.collections

object CompressList {

  def last(ints: List[Int]): Unit = {

    println(ints(ints.size - 1))

  }

  def main(args: Array[String]): Unit = {


    val aa = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')

    //aa.foreach(println(_))

    last(List(1, 1, 2, 3, 5, 8))


    println(P01.lastBuiltin(List(1, 1, 2, 3, 5, 8)))

  }


}


object P01 {
  // There are several ways to solve this problem.  If we use builtins, it's very
  // easy.
  def lastBuiltin[A](ls: List[A]): A = ls.last

  // The standard functional approach is to recurse down the list until we hit
  // the end.  Scala's pattern matching makes this easy.
  def lastRecursive[A](ls: List[A]): A = ls match {
    case h :: Nil => h
    case _ :: tail => lastRecursive(tail)
    case _ => throw new NoSuchElementException
  }
}