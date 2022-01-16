name := "myzio"

version := "0.1"

scalaVersion := "2.13.6"

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