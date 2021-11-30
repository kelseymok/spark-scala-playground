name := "scala-spark-playground"

version := "0.1"

idePackagePrefix := Some("playground")

scalaVersion := "2.12.8"
val sparkVersion = "3.1.0"

libraryDependencies ++= Seq(
  "io.delta" %% "delta-core" % "1.0.0",
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.mockito" % "mockito-core" % "4.0.0" % "test",
  "org.scalactic" %% "scalactic" % "3.2.10" % "test",
  "org.scalatest" %% "scalatest" % "3.2.10" % "test",
  "org.scalatest" %% "scalatest-matchers-core" % "3.2.10" % "test",
  "org.apache.hadoop" % "hadoop-aws" % "3.1.1"
)

