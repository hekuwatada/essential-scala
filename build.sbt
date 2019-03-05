name := "essential-scala"

version := "0.1"

scalaVersion := "2.12.8"

val prodLibs = Seq()

val testLibs = Seq(
  "org.scalactic" %% "scalactic" % "3.0.5" % Test,
  "org.scalatest" %% "scalatest" % "3.0.5" % Test
)

//@see https://www.scala-sbt.org/1.x/docs/Testing.html
lazy val root = (project in file("."))
  .configs(IntegrationTest)
  .settings(
    Defaults.itSettings,
    libraryDependencies ++= prodLibs ++ testLibs
  )