package berlin.softwaretechnik.graphviz.attributes.html

import berlin.softwaretechnik.graphviz.attributes.{Color, LabelString, html}
import berlin.softwaretechnik.graphviz.generator.Strings.{indent, quote}

trait HtmlLikeLabel extends LabelString

trait Text extends HtmlLikeLabel

case class TextList(items: Seq[TextItem]) extends TextItem {
  override def toString: String = items.map(_.toString).mkString("")
}

trait TextItem extends HtmlLikeLabel with Text

case class PlainString(s: String) extends TextItem {
  override def toString: String = s
}

case class RichString(textAttributes: TextAttributes, textItem: TextItem) extends TextItem {
  override def toString: String = textAttributes.wrap(textItem).toString
}

case object BR extends TextItem {
  override def toString: String = "<BR/>"
}
case class StyleTag(tag: String, text: Text) extends TextItem {
  override def toString: String = s"<$tag>${text}</$tag>"
}

case class FontTag(text: Text, attributes: FontTagAttributes) extends TextItem {
  override def toString: String = s"<FONT ${attributes.attribs}>${text}</FONT>"
}

case class TextAttributes(
  font: String = null,
  color: Color = null,
  pointSize: java.lang.Double = null,
  bold: java.lang.Boolean = null,
  underline: java.lang.Boolean = null,
  italic: java.lang.Boolean = null,
  strikethrough: java.lang.Boolean = null,
  overline: java.lang.Boolean = null,
  superscript: java.lang.Boolean = null,
  subscript: java.lang.Boolean = null,
) {
  def wrap(textItem: TextItem): TextItem = {
    var wrapped = textItem;
    if (font != null || color != null ||pointSize != null) {
      wrapped = FontTag(textItem, FontTagAttributes(color = color, face = font, pointSize = pointSize))
    }
    if (italic != null && italic) {
      wrapped = StyleTag("I", wrapped);
    }
    if (underline != null && underline) {
      wrapped = StyleTag("U", wrapped);
    }
    if (bold != null && bold) {
      wrapped = StyleTag("B", wrapped);
    }
    if (strikethrough != null && strikethrough) {
      wrapped = StyleTag("S", wrapped);
    }
    if (superscript != null && superscript) {
      wrapped = StyleTag("SUP", wrapped);
    }
    if (subscript != null && subscript) {
      wrapped = StyleTag("SUB", wrapped);
    }
    wrapped
  }

}

/**
 * @param color     sets the color of the font within the scope of <FONT>...</FONT>.
 *
 *                  This color can be overridden by a COLOR attribute in descendents.
 *                  By default, the font color is determined by the fontcolor attribute
 *                  of the corresponding node, edge or graph, and the border color is
 *                  determined by the color attribute of the corresponding node,
 *                  edge or graph.
 *
 * @param face      FACE="fontname" specifies the font to use within the scope of <FONT>...</FONT>.
 *
 *                  This can be overridden by a FACE attribute in descendents.
 *                  By default, the font name is determined by the fontname attribute
 *                  of the corresponding node, edge or graph.
 *
 * @param pointSize sets the size of the font, in points, used within the scope
 *                  of <FONT>...</FONT>.
 *
 *                  This can be overridden by a POINT-SIZE
 *                  attribute in descendents. By default, the font size
 *                  is determined by the fontsize attribute of the corresponding
 *                  node, edge or graph.
 */
case class FontTagAttributes(color: Color = null, face: String = null, pointSize: java.lang.Double = null) {
  def attribs: String = Seq(
    "color" -> Option(color).map(_.rep).orNull,
    "face" -> face,
    "point-size" -> pointSize
  )
    .filter{case (k,v) => v != null}
    .map{case (k,v) => k + "=" + quote(v.toString)}.mkString(" ")
}

object TableHelpers {
  def renderAttributes(attributes: Seq[(String, Any)]): String =
    attributes.map{case (k, v) => s"""${k}="${v}""""}.mkString(" ")
}

case class Table(attributes: TableAttributes = html.TableAttributes(), rows: Seq[Seq[Cell]]) extends HtmlLikeLabel {
  override def toString: String = s"""<TABLE ${TableHelpers.renderAttributes(attributes.toAttributeMap())}>\n${
    indent(rows
      .map(row => s"""<TR>${row.map(cell =>
        cell.toString
      ).mkString("")}</TR>""").mkString("\n")
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
