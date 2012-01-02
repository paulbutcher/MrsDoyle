import sbt._
import sbt.Keys._
import sbtappengine.Plugin._
import AppengineKeys._

object MrsDoyle extends Build {

  lazy val buildSettings = Seq(
      libraryDependencies ++= Seq(
        "javax.servlet" % "servlet-api" % "2.3" % "provided",
        "org.mortbay.jetty" % "jetty" % "6.1.22" % "container"
      )
    )

  lazy val project = Project("mrsdoyle", file("."),
    settings = buildSettings ++ webSettings)
}
