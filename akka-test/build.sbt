
name := "akka-test"

version := "0.1"

scalaVersion := "2.12.11"

lazy val root = (project in file("."))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.0" % "test",
      "com.typesafe.akka" %% "akka-actor" % "2.5.12",
      "com.typesafe.akka" %% "akka-testkit" % "2.5.12" % Test
    )
  )
