package com.test.arpan.ExceptionHandling

import java.io.File

import scala.util.Try
import scala.util.control.NonFatal

class CapitalTryScala {

  def FindThePath(path: String): Try[File] = Try(new File(path))

}

object CapitalTryScala {

  def main(args: Array[String]): Unit = {

    val cts = new CapitalTryScala

    val listOfPath = List("/", null, "/users/Arpan", "/something", "/else", "letsSee")

    val fileObjs = listOfPath.map(a => cts.FindThePath(a)).map(b => b.recover({
      case NonFatal(x) => cts.FindThePath("/").get
    }))

    println(fileObjs)

    fileObjs foreach {
      x => println(x.get)
    }


    println(listOfPath)

    println("---------")

    val cc = Try(null)
    println(cc.recover({
      case NonFatal(x) => "lets see"
    }))
  }
}