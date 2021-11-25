ThisBuild / scalaVersion := "2.12.12"
ThisBuild / version := "0.1.0"
ThisBuild / organization := "io.opentargets"

lazy val sparkVersion = "3.1.1"
idePackagePrefix := Some("io.opentargets.conversionformat")

val buildResolvers = Seq(
  "Typesafe Repo" at "https://repo.typesafe.com/typesafe/releases/",
  "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases",
  "Bintray Repo" at "https://dl.bintray.com/spark-packages/maven/"
)

lazy val root = (project in file("."))
  .settings(
    name := "ot-converter-format",
    resolvers ++= buildResolvers,
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.7" % Test,
    libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3",
    libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.3",
    libraryDependencies += "com.google.cloud" % "google-cloud-storage" % "2.1.9",
    libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion,
    libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion,
    libraryDependencies += "org.apache.spark" %% "spark-graphx" % sparkVersion,
    libraryDependencies += "org.apache.spark" %% "spark-mllib" % sparkVersion,
    mainClass in (Compile, run) := Some("io.opentargets.conversionformat.Main"),
    // Jar assembly: run `sbt assembly` to create fat jar
    mainClass in assembly := Some("io.opentargets.conversionformat.Main"),
    assemblyJarName in assembly := "ot-conversion-format.jar",
    assemblyMergeStrategy in assembly := {
      case PathList("META-INF", xs @ _*) => MergeStrategy.discard
      case _                             => MergeStrategy.first
    }
  )
