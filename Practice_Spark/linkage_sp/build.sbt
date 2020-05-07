ThisBuild / scalaVersion := "2.12.11"
ThisBuild / organization := "com.example"

lazy val hello = (project in file("."))
  .settings(
    name := "Hello",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.1" % Test,
    libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.5",
  )
