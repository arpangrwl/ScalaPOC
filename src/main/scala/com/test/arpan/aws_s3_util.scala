package com.test.arpan

import java.util.{Date, UUID}

import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.model._
import com.amazonaws.services.s3.{AmazonS3, AmazonS3Client, AmazonS3ClientBuilder}

import scala.collection.JavaConverters._
import scala.util.{Failure, Success, Try}

class aws_s3_util {

  def main(args: Array[String]): Unit = {


    def listObjects(bucket: String, prefix: String): Seq[String] = {
      val s3: AmazonS3 = new AmazonS3Client()
      val request = new ListObjectsV2Request().withBucketName(bucket).withPrefix(prefix).withMaxKeys(1000)
      var objectListResponse = s3.listObjectsV2(request)
      var keys: List[String] = objectListResponse.getObjectSummaries.asScala.map(_.getKey).toList
      while (objectListResponse.isTruncated) {
        objectListResponse = s3.listObjectsV2(
          request.withContinuationToken(objectListResponse.getNextContinuationToken)
        )
        val newKeys = objectListResponse.getObjectSummaries.asScala.map(_.getKey)
        keys = keys ++ newKeys
      }

      keys
    }


    val a = listObjects("pr-ip-events-4978-us-east-1",  "unmatched/dl/location/movement/")
    if (a.filter(_.endsWith(".csv.gz")).size == 0 || a.filter(_.endsWith(".csv")).size == 0)
      println("worked")






    a.foreach(println)



    val vv = Seq("1.val","2.ca","3.val","4.val","5.1")
    vv.filter(_.endsWith(".val")).size


    def f1(s: String) = s.endsWith(".val")

    def f2(s: String) = s.endsWith(".ca")

    val cond1 = true
    val cond2 = true

    val result = vv filter (x => cond1 || f1(x)) filter (x => cond2 || f2(x))

  }
}