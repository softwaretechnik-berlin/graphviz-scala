package berlin.softwaretechnik.graphviz.generator

object Strings {
  def capitalize(s: String): String = s(0).toUpper.toString + s.tail

  def minIndent(block: String): Int = {
    if (block.isEmpty) {
      return 0
    }
    val ret = block.linesIterator.filter(_.length > 0).map(s => s.takeWhile(_ == ' ').length).min

    ret
  }

  def unindent(block: String): String = {
    val indentation = minIndent(block)
    block.linesIterator.filter(_.nonEmpty).map(s => s.substring(indentation)).mkString("\n")
  }

  def indent(block: String, indent: String = "  "): String = block.linesIterator.map(indent + _).mkString("\n")


  def quote(s: String): String = "\"" + s + "\""

}
