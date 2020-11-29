package berlin.softwaretechnik.graphviz.attributes.html

import berlin.softwaretechnik.graphviz.attributes.{LabelString, html}
import berlin.softwaretechnik.graphviz.generator.Strings.indent

trait HtmlLikeLabel extends LabelString

trait Text extends HtmlLikeLabel

case class TextList(items: Seq[TextItem]) extends Text {
  override def toString: String = items.map(_.toString).mkString("")
}

trait TextItem extends HtmlLikeLabel with Text

case class PlainString(s: String) extends TextItem {
  override def toString: String = s
}
case object BR extends TextItem {
  override def toString: String = "<BR/>"
}
case class StyleTag(tag: String, text: Text) extends TextItem {
  override def toString: String = s"<$tag>${text}</$tag>"
}

case class FontTag(text: Text, attributes: FontTagAttributes) extends TextItem {
  override def toString: String = s"<FONT>${text}</FONT>"
}

case class FontTagAttributes()

object TableHelpers {
  def renderAttributes(attributes: Seq[(String, Any)]): String =
    attributes.map{case (k, v) => s"""${k}="${v}""""}.mkString(" ")
}

case class Table(attributes: TableAttributes = html.TableAttributes(), rows: Seq[Seq[Cell]]) extends HtmlLikeLabel {
  override def toString: String = s"""<TABLE ${TableHelpers.renderAttributes(attributes.toAttributeMap())}>\n${
    indent(rows
      .map(row => s"""<TR>${row.map(cell =>
        cell.toString
      )}</TR>""").mkString("\n")
    )
  }\n</TABLE>"""
}


object Cell {
  def apply(content: HtmlLikeLabel): Cell = Cell(TableCellAttributes(), content)
}
case class Cell(tableCellAttributes: TableCellAttributes, content: HtmlLikeLabel) {
  override def toString: String = s"<TD ${TableHelpers.renderAttributes(tableCellAttributes.toAttributeMap())}>${content}</TD>"
}

/**
 *
 * SCALE
 * specifies how an image will use any extra space available in its cell. Allowed values are
 *
 * `FALSE` : keep image its natural size. (Default)
 * `TRUE` : scale image uniformly to fit.
 * `WIDTH` : expand image width to fill
 * `HEIGHT` : expand image height to fill
 * `BOTH` : expand both image width height to fill
 *
 * If this attribute is undefined, the image inherits the imagescale attribute
 * of the graph object being drawn. As with the imagescale attribute, if the
 * cell has a fixed size and the image is too large, any offending dimension
 * will be shrunk to fit the space, the scaling being uniform in width and
 * height if SCALE="true". Note that the containing cell's ALIGN and VALIGN
 * attributes override an image's SCALE attribute.
 *
 **/
case class Image(src: String, scale: ImageScale)
trait ImageScale
object ImageScale {
  case object FALSE;
  case object TRUE;
  case object WIDTH;
  case object HEIGHT;
  case object BOTH;
}

trait FontTable
