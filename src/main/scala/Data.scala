package playground

import sys.process._
import java.net.URL
import java.io.File

object Data extends App with SparkEnvironment {

  val bucketName = "llamas-are-awesome" // HINT: Change this to a bucket that exists!

  if (!(scala.reflect.io.File("./src/main/resources/owid-covid-data.json").exists)) {
    new URL("https://covid.ourworldindata.org/data/owid-covid-data.json") #> new File("./src/main/resources/owid-covid-data.json") !!
  }

  val df = spark.read
    .option("header", "true")
    .option("quote","")
    .option("inferSchema", "true")
    .json("./src/main/resources/owid-covid-data.json")

  df.write
    .format("delta")
    .option("header", "true")
    .mode("Overwrite")
    .save("s3a://llamas-are-awesome/")
}
