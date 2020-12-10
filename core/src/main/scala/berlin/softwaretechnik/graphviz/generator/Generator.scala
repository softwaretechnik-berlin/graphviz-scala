package berlin.softwaretechnik.graphviz.generator

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Path, Paths}

import berlin.softwaretechnik.graphviz.generator.Strings._
import berlin.softwaretechnik.graphviz.generator.TypeMapping.{lookupType, typeMapping}
import os.pwd


object TypeMapping {
  val typeMapping: Map[String, String] = Map(
    "xsd:integer" -> "java.lang.Integer",
    "xsd:decimal" -> "java.lang.Double",
    "xsd:boolean" -> "java.lang.Boolean",
    "xsd:anyURI" -> "String",
    "arrowType" -> "ArrowType",
    "xsd:string" -> "String",
    "colorList" -> "ColorOrList",
    "dirType" -> "DirType",
    "escString" -> "String",
    "color" -> "Color",
    "point" -> "Point",
    "layerRange" -> "LayerRange",
    "portPos" -> "PortPosition",
    "lblString" -> "LabelString",
    "splineType" -> "SplineType",
    "style" -> "Style",
    "pointf" -> "PointF",
    "rect" -> "Rect",
    "shape" -> "Shape",
    "pointfList" -> "PointFList",
    "clusterMode" -> "ClusterMode",
    "layerList" -> "LayerList",
    "rankdir" -> "RankDir",
    "pagedir" -> "PageDir",
    "packMode" -> "PackMode",
    "outputMode" -> "OutputMode",
    "viewPort" -> "ViewPort",
    "rankType" -> "RankType",
    "startType" -> "StartType"
  )

  def lookupType(ref: String): String = typeMapping.getOrElse(ref, ref)

}

case class AttributesCaseClass(
  name: String,

  packageName: String,
  attributes: Seq[Attribute]
) {

  def className: String = Strings.capitalize(name) + "Attributes"

  def packagePath: Path = Paths.get(packageName.replaceAll("\\.", "/"))
  def javaPackageName = packageName
  def javaPackagePath = Paths.get(javaPackageName.replaceAll("\\.", "/"))

  def writeScala(srcDir: Path): AttributesCaseClass = {
    Files.write(
      srcDir.resolve(packagePath).resolve(s"${className}.scala"),
      renderAttributesType.getBytes(StandardCharsets.UTF_8)
    )
    this
  }

  def writeJava(srcDir: Path): AttributesCaseClass = {
    Files.createDirectories(srcDir.resolve(javaPackagePath))
    Files.write(
      srcDir.resolve(javaPackagePath).resolve(s"${className}.java"),
      renderAttributesTypeJava.getBytes(StandardCharsets.UTF_8)
    )
    this
  }

  def renderAttributesTypeJava = {
    s"package ${javaPackageName};\n" +
      s"""import java.util.Map;
         |import java.util.stream.Collectors;
         |public class ${className} {\n""".stripMargin +
      indent(attributes.map(a =>
        s"""/**
           |${indent(unindent(a.doc), "  * ")}
           |  */
           |${lookupType(a.typ)} ${a.name};""".stripMargin).mkString(
        "\n\n")
      ) + "\n\n" +
      indent("public Map<String, Object> toAttributeMap() { \n" +
        indent("return Map.ofEntries(\n" +
    indent(attributes.map(a =>
          s"""Map.entry("${a.name}", ${
            a.name
          })""").mkString(",\n")
      ) + ").entrySet().stream()\n" +
          "    .filter(entry -> entry.getValue() != null)\n" +
          "    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));\n") + "\n}\n") +
      "}\n"
  }


  def renderAttributesType = {
    s"package ${packageName};\n" +
      s"""case class ${className} (\n""" +
      indent(attributes.map(a =>
        s"""/**
           |${indent(unindent(a.doc), "  * ")}
           |  */
           |${a.name}: ${lookupType(a.typ)} = null""".stripMargin).mkString(
        ",\n\n")
      ) + "\n) {\n" +
      indent("def toAttributeMap(): Seq[(String, Any)] = Seq(\n" +
        attributes.map(a =>
          s""""${a.name}" -> ${
            a.name
          }""").mkString(",\n")
      ) + ").filter{case(k, v) => v != null}\n" +
      "}"
  }
}


object Generator {

  def main(args: Array[String]): Unit = {
    val schema = new Schema("doc_schema_attributes.xml")

    val srcDir = Paths.get("./core/src/main/scala")
    val javaSrcDir = Paths.get("./java/src/main/java")

    AttributesCaseClass(
      "node", "berlin.softwaretechnik.graphviz.attributes",
      schema("node").attributes
    ).writeScala(srcDir)
      .writeJava(javaSrcDir)

    AttributesCaseClass(
      "edge", "berlin.softwaretechnik.graphviz.attributes",
      schema("edge").attributes
    ).writeScala(srcDir)
      .writeJava(javaSrcDir)

    AttributesCaseClass(
      "graph", "berlin.softwaretechnik.graphviz.attributes",
      schema("graph").attributes
    ).writeScala(srcDir)
      .writeJava(javaSrcDir)

    AttributesCaseClass(
      "subgraph", "berlin.softwaretechnik.graphviz.attributes",
      schema("cluster").attributes ++ schema("subgraph").attributes
    ).writeScala(srcDir)
      .writeJava(javaSrcDir)

    // <xsd:complexType name="edge">
    val packageDir = Paths.get("./core/src/main/scala/berlin/softwaretechnik/graphviz/attributes")

    Files.write(packageDir.resolve("enums.scala"), (
      "package berlin.softwaretechnik.graphviz.attributes;\n" +
        schema.enums.map(enum => {
          val typeName = typeMapping.getOrElse(enum.name, Strings.capitalize(enum.name))
          s"""
             |/**
             |${indent(unindent(`enum`.doc), "  * ")}
             |  */
             |trait $typeName {}
             |
             |object $typeName {
             |${
            indent(enum.values.map(v => s"case object ${v} extends $typeName {}").mkString("\n"))
          }
             |}""".stripMargin
        }).mkString("\n\n")
      ).getBytes(StandardCharsets.UTF_8)
    )
  }
}
