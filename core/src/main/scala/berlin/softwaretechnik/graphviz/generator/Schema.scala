package berlin.softwaretechnik.graphviz.generator


trait Attribute {
  def name: String

  def typ: String

  def doc: String
}

trait ComplexType {
  def name: String
  def attributes: Seq[Attribute]
}


class Schema(path: String) {

  implicit class RichNode(val node: scala.xml.Node) {
    def attr(key: String) = node.attribute(key).get(0).text
  }

  import scala.xml.XML

  val xml = XML.loadFile(path)
  lazy val complexTypes: Seq[ComplexType] = (xml \ "complexType").map(new ComplexTypeImpl(_))
  private lazy val complexTypesByName: Map[String, ComplexType] = complexTypes.map(cT => cT.name -> cT).toMap

  def apply(complexTypeName: String): ComplexType =  complexTypesByName(complexTypeName)

  lazy val enums: Seq[EnumTyp] = (xml \ "simpleType")
    .filter(st => ((st \ "restriction").headOption.map(_.attr("base")).contains("xsd:string")))
    .filter(st => ((st \ "restriction" \ "enumeration").size) > 0)
    .map(new EnumTyp(_))


  class EnumTyp(node: scala.xml.Node) {
    def name: String = node.attr("name")

    def values: Seq[String] = node \\ "enumeration" map (_.attr("value"))

    def doc: String = (node \\ "documentation" \\ "p").map(_.toString().linesIterator.toList.drop(1).dropRight(1).mkString("\n"))
      .mkString("\n\n")
      .replaceAll("html:", "")
      .replaceAll("\t", "    ")
  }

  class AttributeImpl(node: scala.xml.Node) extends Attribute {
    def name: String = node.attr("name")

    def typ: String = node.attr("type")

    def doc: String = (node \\ "documentation" \\ "p").map(_.toString().linesIterator.toList.drop(1).dropRight(1).mkString("\n"))
      .mkString("\n\n")
      .replaceAll("html:", "")
      .replaceAll("\t", "    ")
  }

  class ComplexTypeImpl(node: scala.xml.Node) extends ComplexType {
    def name: String = node.attr("name")

    //<xsd:attribute ref="URL" />
    def attributes: Seq[AttributeImpl] = (node \ "attribute")
      .map(a => a.attr("ref"))
      .map(ref => new AttributeImpl((xml \ "attribute").find(attribute => attribute.attr("name") == ref).get));
  }

}
