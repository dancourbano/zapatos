import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "sqlPlay"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "mysql" % "mysql-connector-java" % "5.1.34"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here      
    )

}
