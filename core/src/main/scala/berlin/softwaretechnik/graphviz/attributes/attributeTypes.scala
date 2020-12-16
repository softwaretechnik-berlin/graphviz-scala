package berlin.softwaretechnik.graphviz.attributes

import berlin.softwaretechnik.graphviz.attributes.html.TextItem

/** <a href="https://graphviz.org/doc/info/attrs.html#k:arrowType">ArrowType</a> */
sealed trait ArrowType {}

object ArrowType {

  case object normal extends ArrowType

  case object inv extends ArrowType

  case object dot extends ArrowType

  case object invdot extends ArrowType

  case object odot extends ArrowType

  case object invodot extends ArrowType

  case object none extends ArrowType

  case object tee extends ArrowType

  case object empty extends ArrowType

  case object invempty extends ArrowType

  case object diamond extends ArrowType

  case object odiamond extends ArrowType

  case object ediamond extends ArrowType

  case object crow extends ArrowType

  case object box extends ArrowType

  case object obox extends ArrowType

  case object open extends ArrowType

  case object halfopen extends ArrowType

  case object vee extends ArrowType

}

sealed trait ColorOrList {}

case class Color(rep: String) extends ColorOrList {
  override def toString: String = s""""$rep""""
}

case class ColorList(Seq: Color) extends ColorOrList

/**
 * The rectangle llx,lly,urx,ury gives the coordinates, in
 * points, of the lower-left corner (llx,lly) and the
 * upper-right corner (urx,ury).
 */
case class Rect(llx: Double, lly: Double, urx: Double, ury: Double) {
  override def toString: String = s"$llx,$lly,$urx,$ury"
}

sealed trait Point {}

sealed trait LayerRange {}

sealed trait PortPosition {}

trait LabelString {}

case class Plain(value: String) extends LabelString with TextItem {
  override def toString: String = value
}

sealed trait SplineType {}

sealed trait Style {}

sealed trait PointF {}

sealed trait PointFList {}

sealed trait LayerList {}

sealed trait ViewPort {}

sealed trait StartType {}
