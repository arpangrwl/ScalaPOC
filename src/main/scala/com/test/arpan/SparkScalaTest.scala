package com.test.arpan

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.apache.spark.sql.functions._


object SparkScalaTest {

  def main(args: Array[String]): Unit = {

    @transient lazy val sparkSession = SparkSession.builder().appName("AdobeIdXrefTest").config("spark.worker.cleanup.enabled", "true").config("spark.master", "local").config("spark.sql.shuffle.partitions", "1").getOrCreate()

    def getStr0(): StructType = {
      (new StructType)
        .add(StructField("col_1", StringType, true))
        .add(StructField("col_2", StringType, true))
    }

    val data0 = Seq(
      Row("value1_a", "value2_a"),
      Row("value1_b", "value2_b"),
      Row("value1_c", "value2_c"),
      Row("value1_c", "value2_c"),
      Row("value1_d", "value2_d"),
      Row("value1_e", "value2_e")
    )

    val df0 = sparkSession.createDataFrame(sparkSession.sparkContext.parallelize(data0), getStr0())

    //--------

    def getStr2(): StructType = {
      (new StructType)
        .add(StructField("col_3", StringType, true))
        .add(StructField("col_4", StringType, true))
    }

    val data2 = Seq(
      Row("colval3_a", "colval4_a"),
      Row("colval3_b", "colval4_b"),
      Row("colval3_c", "colval4_c"),
      Row("colval3_d", "colval4_d"),
      Row("colval3_d", "colval4_d"),
      Row("colval3_e", "colval4_e")
    )

    val df2 = sparkSession.createDataFrame(sparkSession.sparkContext.parallelize(data2), getStr2())

    //--------

    def getStr1(): StructType = {
      (new StructType)
        .add(StructField("col_1", StringType, true))
        .add(StructField("col_2", StringType, true))
        .add(StructField("col_3", StringType, true))
        .add(StructField("col_4", StringType, true))
        .add(StructField("col_5", StringType, true))
        .add(StructField("col_6", StringType, true))
    }

    val data1 = Seq(
      Row("col1_a", "col2_a","col3_a", "col4_a","col5_a", "col6_a"),
      Row("col1_b", "col2_b","col3_b", "col4_b","col5_b", "col6_b"),
      Row("col1_c", "col2_c","col3_c", "col4_c","col5_c", "col6_c"),
      Row("col1_d", "col2_d","col3_d", "col4_d","col5_d", "col6_d"),
      Row("col1_e", "col2_e","col3_e", "col4_e","col5_e", "col6_e"),
      Row("col1_f", "col2_f","col3_f", "col4_f","col5_f", "col6_f"),
      Row("col1_f", "col2_f","col3_f", "col4_f","col5_f", "col6_f"),
      Row("col1_g", "col2_g","col3_g", "col4_g","col5_g", "col6_g")
    )

    val df1 = sparkSession.createDataFrame(sparkSession.sparkContext.parallelize(data1), getStr1())


    val totalCol = df1.columns.toSet

    def expr(myCols: Set[String], allCols: Set[String]) = {
      allCols.toList.map(x => x match {
        case x if myCols.contains(x) => col(x)
        case _ => lit(null).as(x)
      })
    }

//    val df2 = df1.select(expr(col1, totalCol):_*)
//    df2.show(false)

    val resultDf = df0.select(expr(df0.columns.toSet, totalCol):_*).union(df1).union(df2.select(expr(df2.columns.toSet, totalCol):_*))
    resultDf.show(100,false)

  }
}
