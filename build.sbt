name := "shapeless-study"

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "com.chuusai" %% "shapeless" % "2.3.3"
  ,"org.scalactic" %% "scalactic" % "3.0.5"
  ,"org.scalatest" %% "scalatest" % "3.0.5" % Test
)
