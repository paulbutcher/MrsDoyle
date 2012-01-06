import sbt._
import sbt.Keys._
import sbt.Defaults._
import sbtappengine.Plugin._
import AppengineKeys._
import ScalaMockPlugin._

object MrsDoyle extends Build {

  lazy val buildSettings = Seq(
      libraryDependencies ++= Seq(
        "javax.servlet" % "servlet-api" % "2.3",
        "org.mortbay.jetty" % "jetty" % "6.1.22" % "container",
        "org.scalamock" %% "scalamock-scalatest-support" % "2.2-SNAPSHOT"
      ),
      autoCompilerPlugins := true,
      addCompilerPlugin("org.scalamock" %% "scalamock-compiler-plugin" % "2.2-SNAPSHOT"),

      unmanagedJars in Compile <++= AppengineKeys.libUserPath in Compile map { libUserPath =>
      	val baseDirectories = libUserPath +++ (libUserPath / "orm")
      	  (baseDirectories * "*.jar").classpath
      	},
      unmanagedJars in Compile <++= AppengineKeys.libPath in Compile map { libPath =>
      	  ((libPath / "shared") ** "*.jar").classpath
      	}
    )

  lazy val project = Project("mrsdoyle", file("."),
    settings = defaultSettings ++ buildSettings ++ appengineSettings ++ generateMocksSettings ++ inConfig(Mock)(baseAppengineSettings)) configs(Mock)
}
