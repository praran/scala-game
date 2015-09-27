
// Basic settings
val baseSettings = Seq (
  name := "Game",
  version := "1.0.0",
  scalaVersion :=  "2.11.6" ,
  scalacOptions in Compile ++= Seq("-encoding", "UTF-8", "-target:jvm-1.8", "-deprecation", "-unchecked", "-Ywarn-dead-code", "-Xfatal-warnings", "-feature", "-language:postfixOps"),
  scalacOptions in Test ++= Seq("-Yrangepos")
)

// Project settings
lazy val root = project.in(file("."))
                 .settings(baseSettings:_*)
                 .settings(
                    crossPaths := false,
                    libraryDependencies ++={Seq(
                                        "org.specs2" %% "specs2-core" % "3.6.4" % "test",
                                        "org.specs2" %% "specs2-mock" % "3.6.4" % "test"
      )
    }
  )