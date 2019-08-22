package com.test.arpan
import org.apache.spark.sql._
import org.apache.spark.sql.functions.{col, udf}
import org.apache.spark.sql.types._

object  TestClass{

  def main(args: Array[String]): Unit = {

    function

  }











  def function(): Unit = {
    @transient lazy val sparkSession = SparkSession.builder().appName("AdobeIdXrefTest").config("spark.worker.cleanup.enabled", "true").config("spark.master", "local").config("spark.sql.shuffle.partitions", "1").getOrCreate()

    def getStr(): StructType = {
      (new StructType)
        .add(StructField("partner_id", StringType, true))
        .add(StructField("partner_type", StringType, true))
    }

    val data = Seq(
      //      Row("00000000-5519-099a-0000-00005519099a", ""),
      //      Row("00000000-0b22-506a-0000-00000b22506a", "KRUX"),
      //      Row("00000000-5223-ee1c-0000-00005223ee1c", "ROKU"),
      //      Row("00000000-252b-7207-0000-0000252b7207", "AAID"),
      Row("00000000-fa26-ffff-ffff890a4374", "AAID"),
      Row("00000000-4052-18b3-0000-0000405218b3fds", "AAID"),
      Row("00000000-4052-18b3-0000-0000405218b3", "AAID"),
      Row(null, "AAID"),
      Row("00003432-4052-18b3-0000-0000404328b3", "AAID"),
      Row("00000000-0000-0000-0000-000000000000", "AAID"),
      Row("00000000-0000-0000-0000-000000000000", "IDFA")
    )

    val checkPartnerId = udf((partnerId: String) => {

      if(partnerId.size == 36)
        if(partnerId == "00000000-0000-0000-0000-000000000000") false else true
      //          if(partnerId.replaceAll("-","" ).replaceAll("0","" ) == "") false else true
      else
        false
    })

    val resultDF = sparkSession.createDataFrame(sparkSession.sparkContext.parallelize(data), getStr())

    resultDF.show(false)
    val maid = resultDF.filter(resultDF("partner_type").isin("AAID","IDFA")).filter(resultDF("partner_id").isNotNull).filter(checkPartnerId(col("partner_id")) === true )
    val otherDev = resultDF.filter(!resultDF("partner_type").isin("AAID","IDFA"))

    val OutputDF = maid.union(otherDev)


    OutputDF.show(false)

    val filterdeMaidCount = resultDF.filter(resultDF("partner_type").isin("AAID","IDFA")).filter(resultDF("partner_id").isNull or checkPartnerId(resultDF("partner_id")) === false).count()

    println(" filterdeMaidCount value is :- " + filterdeMaidCount)
  }
}