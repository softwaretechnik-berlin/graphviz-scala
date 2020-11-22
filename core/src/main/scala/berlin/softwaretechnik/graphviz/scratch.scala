package berlin.softwaretechnik.graphviz

import berlin.softwaretechnik.graphviz.attributes.RankType.same
import berlin.softwaretechnik.graphviz.attributes.Shape.box
import berlin.softwaretechnik.graphviz.attributes.{Color, EdgeAttributes, GraphAttributes, LabelString, NodeAttributes, Plain, SubgraphAttributes}
import berlin.softwaretechnik.graphviz.generator.Strings.indent

trait Renderable {
  def render: String

  def render(attributeMap: Seq[(String, Any)]): String = {
    attributeMap.map { case (k, v) => s"""${k} = ${renderValue(v)};""" }.mkString("\n") + "\n"
  }

  def renderWithBrackets(attributeMap: Seq[(String, Any)]): String = {
    if (attributeMap.isEmpty) {
      return ""
    }

    " [\n" + indent(render(attributeMap)) + "\n]"
  }

  private def renderValue(v: Any) = {
    v match {
      // Todo: We want to do proper string escaping:
      case s: String => "\"" + s + "\""
      case p: Plain => "\"" + p.toString + "\""
      // Todo We need support for HTML like labels
      case a: Any => a.toString
    }
  }
}

case class Graph(
  id: Option[String] = None,
  attributes: GraphAttributes = GraphAttributes(),
  nodeDefaults: NodeAttributes = NodeAttributes(),
  edgeDefaults: EdgeAttributes = EdgeAttributes(),
  elements: Seq[GraphElement],
) extends Renderable {

  override def render: String = {
    val attributeMap = attributes.toAttributeMap()
    s"""digraph ${id.getOrElse("")} {\n""" +
      indent(
        (if(nodeDefaults.toAttributeMap().nonEmpty)
          "node " + renderWithBrackets(nodeDefaults.toAttributeMap()) + ";\n"
        else
          "") +
          (if(edgeDefaults.toAttributeMap().nonEmpty)
            "edge " + renderWithBrackets(edgeDefaults.toAttributeMap()) + ";\n"
          else
            "") +
        render(attributeMap) +
          elements.map(_.render).mkString("\n")
      ) +
      "\n}\n"
  }

}

case class SubGraph(
  id: Option[String] = None,
  attributes: SubgraphAttributes = SubgraphAttributes(),
  nodeDefaults: NodeAttributes = NodeAttributes(),
  edgeDefaults: EdgeAttributes = EdgeAttributes(),
  elements: Seq[GraphElement],
) extends GraphElement {
  override def render: String = {
    s"""subgraph ${
      id.getOrElse("")
    } {\n""" +
      indent(
        (if(nodeDefaults.toAttributeMap().nonEmpty)
          "node " + renderWithBrackets(nodeDefaults.toAttributeMap()) + ";\n"
        else
          "") +
          (if(edgeDefaults.toAttributeMap().nonEmpty)
            "edge " + renderWithBrackets(edgeDefaults.toAttributeMap()) + ";\n"
          else
            "") +
        render(attributes.toAttributeMap()) +
          elements.map(_.render).mkString("\n")
      ) +
      "\n}\n"
  }
}

trait GraphElement extends Renderable

case class Node(
  id: String,
  attributes: NodeAttributes = NodeAttributes()
) extends GraphElement {
  override def render: String =
    id + renderWithBrackets(attributes.toAttributeMap()) + ";"
}

case class Edge(
  from: String,
  to: String,
  attributes: EdgeAttributes = EdgeAttributes()
) extends GraphElement {
  override def render: String =
    from + " -> " + to + renderWithBrackets(attributes.toAttributeMap()) + ";"
}

object GraphTest {
  def main(args: Array[String]): Unit = {
    val dotString = Graph(
      attributes = GraphAttributes(fontname = "Helvetica", fontsize = 16),
      nodeDefaults = NodeAttributes(fontname = "Helvetica", fontsize = 16),
      edgeDefaults = EdgeAttributes(fontname = "Helvetica", fontsize = 16),
      elements = Seq(
        Node("A"),
        Node("C"),
        SubGraph(attributes = SubgraphAttributes(rank = same), elements = Seq(
          Node("B",  NodeAttributes(shape = box)),
          Node("D", NodeAttributes(color = Color("#FF0000"))),
        )),
        Edge("A", "B", EdgeAttributes(label = new Plain("This is a label"))),
        Edge("A", "C"),
        Edge("B", "C"),
        Edge("B", "D"),
      )
    )
      .render

    println(dotString)

    os.write.over(os.pwd / "doc" / "test.dot", dotString)
    os.proc("dot", "-Tsvg", "-o", "doc/test.svg", "doc/test.dot").call()
  }

}
