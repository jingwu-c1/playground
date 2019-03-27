name := "playground"

version := "0.1"

scalaVersion := "2.12.8"

lazy val part0Project = Project(id = "part0", base = file("part0"))
  .settings(
    libraryDependencies ++= Seq("org.mockito" % "mockito-core" % "1.9.5" % Test)
  )

lazy val part1Project = Project(id = "part1", base = file("part1"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.5" % "test",
      "com.amazonaws" % "aws-java-sdk-s3" % "1.11.267",
      "org.mockito" % "mockito-core" % "1.9.5" % Test)
  )

lazy val part2Project = Project(id = "part2", base = file("part2"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.5" % "test",
      "com.amazonaws" % "aws-java-sdk-s3" % "1.11.267",
      "org.mockito" % "mockito-core" % "1.9.5" % Test)
  )

lazy val part3Project = Project(id = "part3", base = file("part3"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.5" % "test",
      "com.amazonaws" % "aws-java-sdk-s3" % "1.11.267",
      "com.typesafe.akka" %% "akka-actor" % "2.5.21"
    )
  )
