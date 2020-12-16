package berlin.softwaretechnik.graphviz.attributes

package object html {

  import scala.language.implicitConversions

  def b(textItems: TextItem*): TextItem = StyleTag("B", TextList(textItems))

  def u(textItems: TextItem*): TextItem = StyleTag("U", TextList(textItems))

  def s(textItems: TextItem*): TextItem = StyleTag("S", TextList(textItems))

  def i(textItems: TextItem*): TextItem = StyleTag("I", TextList(textItems))

  def sub(textItems: TextItem*): TextItem = StyleTag("SUB", TextList(textItems))

  def sup(textItems: TextItem*): TextItem = StyleTag("SUP", TextList(textItems))

  def textAttr(
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
  )(textItem: TextItem*): TextItem = RichString(
    new TextAttributes(
      font,
      color,
      pointSize,
      bold,
      underline,
      italic,
      strikethrough,
      overline,
      superscript,
      subscript
    ),
    TextList(textItem)
  )

  implicit def plain(text: String): Plain = new Plain(text)
}
