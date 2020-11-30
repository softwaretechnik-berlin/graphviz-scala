package berlin.softwaretechnik.graphviz

import java.nio.file.attribute.PosixFilePermission
import java.nio.file.attribute.PosixFilePermission.{GROUP_READ, OTHERS_READ, OWNER_READ, OWNER_WRITE}
import java.util

import berlin.softwaretechnik.graphviz.generator.Strings
import os.PermSet

import scala.jdk.CollectionConverters.SetHasAsJava

object Readme {

  def main(args: Array[String]): Unit = {
    val example = Strings.unindent(os.read(os.pwd /  "core" / "src" / "test" / "scala" / "berlin" / "softwaretechnik" / "graphviz" / "GraphExample.scala")
      .linesIterator.dropWhile(! _.contains("//snip")).drop(1).takeWhile(!_.contains("//snap"))
      .mkString("\n"))

    val readmePath = os.pwd / "README.md"
    os.perms.set(readmePath, PermSet.fromSet(Set(OWNER_WRITE, OWNER_READ).asJava))

    os.write.over(readmePath,
    s"""# Scala Library to Produce Graphviz dot-Files
      |[![Maven Central](https://maven-badges.herokuapp.com/maven-central/berlin.softwaretechnik/graphviz-scala_2.13/badge.svg)](https://maven-badges.herokuapp.com/maven-central/berlin.softwaretechnik/graphviz-scala_2.13)
      |
      |This library provides a (somewhat) type safe interface into the
      |[Graphviz DOT language](https://graphviz.org/doc/info/lang.html). It provides a case class representation
      |of the core elements and their attribute.
      |
      |It isn't a full representation of all legal graphviz
      |files. It doesn't support the assignment of
      |attribute values at arbitrary positions in the code.
      |
      |Here is an example ([full source](core/src/test/scala/berlin/softwaretechnik/graphviz/GraphExample.scala)):
      |
      |~~~ .scala
      |${example}
      |~~~
      |
      |This will yield the following output:
      |
      |[![](doc/test.svg)](doc/test.dot)
      |
      |# TODO
      |
      |* [ ] Deploy to maven central.
      |* [X] Support for HTML like labels
      |    * [ ] Support font attributes
      |    * [ ] Come up with a nicer model for formatted
      |          text.
      |* [X] Fix various attribute types e.g. ArrowHead
      |* [ ] Proper String escaping
      |* [ ] Add support for node port short cut syntax
      |* [ ] Separate code that is used to generate code
      |      from the graphviz schema from the actual
      |      library.
      |* [X] Convert example into an actual test case.
      |* [ ] Some attribute grouping mechanism that
      |      works across different kinds of attributes.
      |      |""".stripMargin,
      )
    os.perms.set(readmePath, PermSet.fromSet(Set(GROUP_READ, OWNER_READ, OTHERS_READ ).asJava))
  }
}

