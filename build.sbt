


ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / scalaVersion := "2.13.7"
ThisBuild / name := "myzio"

//libraryDependencies += "dev.zio" %% "zio" % "2.0.0-M4"

libraryDependencies += "dev.zio" %% "zio" % "1.0.12"

libraryDependencies += "io.d11" %% "zhttp"      % "1.0.0.0-RC17"
//libraryDependencies += "io.d11" %% "zhttp-test" % "1.0.0.0-RC17" % Test

// The quill-jdbc module provides a simple blocking JDBC context for standard use-cases.
libraryDependencies ++= Seq(
  "org.postgresql" % "postgresql" % "42.3.1",
  "io.getquill" %% "quill-jdbc" % "3.10.0",
  "dev.zio" %% "zio-json" % "0.2.0-M2"
)

val AkkaVersion = "2.6.8"
val AkkaHttpVersion = "10.2.7"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion
)

val circeVersion = "0.14.1"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

assembly / mainClass := Some("myakka.akkahttp.AkkaHttpMain")

//lazy val app = (project in file("."))
//  .settings(
//    assembly / mainClass := Some("myakka.akkahttp.AkkaHttpMain")
//    // more settings here ...
//  )
