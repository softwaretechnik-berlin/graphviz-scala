package berlin.softwaretechnik.graphviz

import berlin.softwaretechnik.graphviz.attributes.RankType.same
import berlin.softwaretechnik.graphviz.attributes.Shape.{box, none}
import berlin.softwaretechnik.graphviz.attributes._
import berlin.softwaretechnik.graphviz.attributes.html._

object  GraphExample {
  def main(args: Array[String]): Unit = {
    //snip
    val dotString = Graph(
      attributes = GraphAttributes(fontname = "Helvetica", fontsize = 16),
      nodeDefaults = NodeAttributes(fontname = "Helvetica", fontsize = 16),
      edgeDefaults = EdgeAttributes(fontname = "Helvetica", fontsize = 16),
      elements = Seq(
        Node("A", NodeAttributes(
          shape = none,
          label = Table(
            TableAttributes(color = Color("gray"), border = 0, cellSpacing = 0, cellBorder = 1, cellPadding = 3),
            Seq(
              Seq(Cell(TextList(Seq(Plain("Good "), StyleTag("I", Plain("bye!")))))),
              Seq(Cell(TableCellAttributes(align = Align.Left), StyleTag("B", StyleTag("U", Plain("Hello!"))))),
              Seq(Cell(TableCellAttributes(align = Align.Left), b(u("Hello!"),"No underline."))),
              Seq(Cell(TableCellAttributes(align = Align.Left), textAttr(bold = true, color = Color("#00D000"))("Does this work?"))),
            )))),
        Node("C"),
        SubGraph(attributes = SubgraphAttributes(rank = same), elements = Seq(
          Node("B", NodeAttributes(shape = box, label = new Plain("Two\nLines"))),
          Node("D", NodeAttributes(color = Color("#FF0000"))),
        )),
        Edge("A", "B", EdgeAttributes(label = new Plain("This is a label"))),
        Edge("A", "C"),
        Edge("B", "C"),
        Edge("B", "D"),
      )
    ).render
    //snap

    println(dotString)

    os.write.over(os.pwd / "doc" / "test.dot", dotString)
    os.proc("dot", "-Tsvg", "-o", "doc/test.svg", "doc/test.dot").call()
  }

}
