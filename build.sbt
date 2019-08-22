import sbt.Resolver

name := "testProject"
val date = new java.text.SimpleDateFormat("yyyyMMdd-HHmmss").format(new java.util.Date())
val buildNumber = sys.env.get("BUILD_NUMBER").getOrElse("0")
version := "1.0." + buildNumber + "-" + date
scalaVersion := "2.11.8"
ivyScala := ivyScala.value map {
  _.copy(overrideScalaVersion = true)
}
val sparkVersion = "2.2.1"


resolvers ++= Seq(
  "apache-snapshots" at "http://repository.apache.org/snapshots/"
)

unmanagedJars in Compile += file("lib/*.jar")

resolvers += Classpaths.typesafeResolver
libraryDependencies ++= Seq(
"org.apache.spark" %% "spark-core" % sparkVersion,
"org.apache.spark" %% "spark-sql" % sparkVersion,
"com.typesafe" % "config" % "1.3.0",
"com.eaio.uuid" % "uuid" % "3.2",
"commons-codec" % "commons-codec" % "1.11",
"io.nats" % "jnats" % "1.0",
"com.amazonaws" % "aws-java-sdk-s3" % "1.11.349",
"com.amazonaws" % "aws-java-sdk-sns" % "1.11.349",

"com.google.guava" % "guava" % "18.0",

"org.json4s" %% "json4s-jackson" % "3.2.11",
"org.json4s" %% "json4s-ext" % "3.2.11",
"com.github.scopt" %% "scopt" % "3.5.0",

"org.scalactic" %% "scalactic" % "3.0.0",
"com.amazonaws" % "aws-java-sdk-ses" % "1.11.375",
"com.gu" %% "scanamo" % "1.0.0-M6",
"com.amazonaws" % "aws-java-sdk-dynamodb" % "1.11.358"

)

// Test libraries
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.0" % "test"
)
lazy val commonSettings = Seq(
  version := "0.1-SNAPSHOT",
  organization := "com.att.mac",
  scalaVersion := "2.11.8",
  test in assembly := {}
)

test in assembly := {}

fork in Test := true
javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:MaxPermSize=2048M", "-XX:+CMSClassUnloadingEnabled")
parallelExecution in Test := false

lazy val root = (project in file(".")).
  settings(
    name := "social_intellegence_spark",
    version := "1.0",
    scalaVersion := "2.11.8",
    mainClass in Compile := Some("com.att.mac.idmatch.FileProcessor")
  )

assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false, includeDependency = false)
