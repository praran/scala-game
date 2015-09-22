/*name := "Game"

version := "1.0"

scalaVersion := "2.11.7"*/

val baseSettings = Seq (
  name := "Game",
  version := "1.0.0",
  scalaVersion := "2.11.7",
  scalacOptions in Compile ++= Seq("-encoding", "UTF-8", "-target:jvm-1.8", "-deprecation", "-unchecked", "-Ywarn-dead-code", "-Xfatal-warnings", "-feature", "-language:postfixOps")
)

lazy val root = project.in(file("."))
                 .settings(baseSettings:_*)
                 .settings(
                    crossPaths := false,
                    libraryDependencies ++={
                         Seq(
                           "org.specs2"          %%  "specs2-core"   % "2.3.11" % "test"
                         )
                    }
                  )