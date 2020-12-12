# Scala Library to Produce Graphviz dot-Files
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/berlin.softwaretechnik/graphviz-scala_2.13/badge.svg)](https://maven-badges.herokuapp.com/maven-central/berlin.softwaretechnik/graphviz-scala_2.13)

This library provides a (somewhat) type safe interface into the
[Graphviz DOT language](https://graphviz.org/doc/info/lang.html). It provides a case class representation
of the core elements and their attribute.

It isn't a full representation of all legal graphviz
files. It doesn't support the assignment of
attribute values at arbitrary positions in the code.

Here is an example ([full source](core/src/test/scala/berlin/softwaretechnik/graphviz/GraphExample.scala)):

~~~ .scala
val dotString = Graph(
  attributes = GraphAttributes(fontname = "Helvetica", fontsize = 16),
  nodeDefaults = NodeAttributes(fontname = "Helvetica", fontsize = 16),
  edgeDefaults = EdgeAttributes(fontname = "Helvetica", fontsize = 16),
  elements = Seq(
    Node("A", NodeAttributes(
      shape = none,
      label = Table(
        TableAttributes(border = 0, cellSpacing = 0, cellBorder = 1, cellPadding = 3),
        Seq(
          Seq(Cell(TextList(Seq(PlainString("Good "), StyleTag("I", PlainString("bye!")))))),
          Seq(Cell(TableCellAttributes(align = Align.Left), StyleTag("B", StyleTag("U", PlainString("Hello!"))))),
          Seq(Cell(TableCellAttributes(align = Align.Left), b(u("Hello!"),"No underline."))),
          Seq(Cell(TableCellAttributes(align = Align.Left), textAttr(bold = true, color = Color("#00D000"))("Does this work?"))),
        )))),
    Node("C"),
    SubGraph(attributes = SubgraphAttributes(rank = same), elements = Seq(
      Node("B", NodeAttributes(shape = box)),
      Node("D", NodeAttributes(color = Color("#FF0000"))),
    )),
    Edge("A", "B", EdgeAttributes(label = new Plain("This is a label"))),
    Edge("A", "C"),
    Edge("B", "C"),
    Edge("B", "D"),
  )
).render
~~~

This will yield the following output:

[![](doc/test.svg)](doc/test.dot)

# TODO

* [ ] Deploy to maven central.
* [X] Support for HTML like labels
    * [ ] Support font attributes
    * [ ] Come up with a nicer model for formatted
          text.
* [X] Fix various attribute types e.g. ArrowHead
* [ ] Proper String escaping
* [ ] Add support for node port short cut syntax
* [ ] Separate code that is used to generate code
      from the graphviz schema from the actual
      library.
* [X] Convert example into an actual test case.
* [ ] Some attribute grouping mechanism that
      works across different kinds of attributes.
      |