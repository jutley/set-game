name := "SetGame"

version := "1.0"

scalaVersion := "2.11.8"

enablePlugins(ScalaJSPlugin)

skip in packageJSDependencies := false
jsDependencies += "org.webjars" % "jquery" % "2.1.4" / "2.1.4/jquery.js"
jsDependencies += RuntimeDOM

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0"
libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "0.9.1"