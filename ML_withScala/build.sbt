ThisBuild / scalaVersion := "2.12.11"
ThisBuild / organization := "com.example"

run / javaOptions += "-Xmx2G" 
run / javaOptions += "-Xms512m"
run / javaOptions += "-XX:MaxPermSize512m"

lazy val hello = (project in file("."))
  .settings(
    name := "Hello",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.1" % Test,
    libraryDependencies += "org.apache.commons" % "commons-math3" % "3.6.1",
    libraryDependencies += "jfree" % "jfreechart" % "1.0.13",
  )
