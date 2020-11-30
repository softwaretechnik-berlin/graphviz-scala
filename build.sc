import mill._
import mill.api.Loose
import mill.define.{Sources, Target}
import mill.scalalib._
import mill.scalalib.publish._
import mill.scalalib.scalafmt.ScalafmtModule

object core extends SbtModule with PublishModule with ScalafmtModule {
  def scalaVersion = "2.13.1"

  def publishVersion = "0.0.0"

  def pomSettings = PomSettings(
    description = "A Scala Representation for Graphviz files",
    organization = "berlin.softwaretechnik",
    url = "https://github.com/softwaretechnik-berlin/graphviz-scala",
    licenses = Seq(License.MIT),
    versionControl = VersionControl.github("softwaretechnik-berlin", "graphviz-scala"),
    developers = Seq(
      Developer("softwaretechnik-berlin", "Softwaretechnik", "https://github.com/softwaretechnik-berlin")
    )
  )


  override def artifactName = "graphviz-scala"

  override def ivyDeps: Target[Loose.Agg[Dep]] =
    Agg(
      ivy"org.scala-lang.modules::scala-xml:1.3.0",
      ivy"com.lihaoyi::os-lib:0.7.1",
    )

  override def scalacOptions: Target[Seq[String]] =
    Seq(
      "-deprecation",
      "-feature",
      "-Xfatal-warnings",
    )

  object test extends Tests {
    def ivyDeps = Agg(
      ivy"org.eclipse.jgit:org.eclipse.jgit:5.7.0.202003110725-r",
      ivy"com.github.chocpanda::scalacheck-magnolia::0.3.1",
      ivy"org.scalatest::scalatest::3.1.1",
      ivy"org.scalatestplus::scalacheck-1-14::3.1.1.1"
    )

    def testFrameworks = Seq("org.scalatest.tools.Framework")
  }

}
