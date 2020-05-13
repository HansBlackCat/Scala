ThisBuild / scalaVersion := "2.12.11"
ThisBuild / organization := "dev.circuitDSL"

lazy val hello = (project in file("."))
  .settings(
    name := "Hello",
    //libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.1" % Test,
  )