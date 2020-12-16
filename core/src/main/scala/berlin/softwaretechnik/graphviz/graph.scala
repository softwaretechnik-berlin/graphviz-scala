package berlin.softwaretechnik.graphviz

import berlin.softwaretechnik.graphviz.attributes.html.HtmlLikeLabel
import berlin.softwaretechnik.graphviz.attributes._
import berlin.softwaretechnik.graphviz.generator.Strings.indent
import org.apache.commons.text.StringEscapeUtils

trait Renderable {
  def render: String

  def render(attributeMap: Seq[(String, Any)]): Seq[String] = {
    attributeMap.map { case (k, v) => s"""${k} = ${renderValue(v)};""" }
  }

  def renderWithBrackets(attributeMap: Seq[(String, Any)]): String = {
    if (attributeMap.isEmpty) {
      return ""
    }
    val preRendered = render(attributeMap)
    if (preRendered.mkString("").length < 60)
      " [" + preRendered.mkString(" ") + "]"
    else
      " [\n" + indent(preRendered.mkString("\n") + "\n") + "\n]"
  }

  private def escape(s: String): String = StringEscapeUtils.escapeJava(s)

  private def renderValue(v: Any) = {
    v match {
      // Todo: We want to do proper string escaping:
      case s: String => "\"" + escape(s) + "\""
      case p: Plain => "\"" + escape(p.toString) + "\""
      case h: HtmlLikeLabel => "<" + h.toString + ">"
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
          "node" + renderWithBrackets(nodeDefaults.toAttributeMap()) + ";\n"
        else
          "") +
          (if(edgeDefaults.toAttributeMap().nonEmpty)
            "edge" + renderWithBrackets(edgeDefaults.toAttributeMap()) + ";\n"
          else
            "") +
        render(attributeMap).mkString("\n") + "\n" +
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
        render(attributes.toAttributeMap()).mkString("\n") + "\n" +
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
