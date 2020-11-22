package berlin.softwaretechnik.graphviz.attributes

sealed trait ArrowType {}
object ArrowType  {
  case object normal extends ArrowType {}
}

sealed trait ColorOrList {}

case class Color(rep: String) extends ColorOrList {
  override def toString: String = s""""$rep""""
}
case class ColorList(Seq: Color) extends ColorOrList


sealed trait Rect {}

sealed trait Point {}

sealed trait LayerRange {}

sealed trait PortPosition {}

sealed trait LabelString {}

class Plain(value: String) extends LabelString {
  override def toString: String = value
}

sealed trait SplineType {}

sealed trait Style {}

sealed trait PointF {}
sealed trait PointFList {}

sealed trait LayerList {}

sealed trait ViewPort {}
sealed trait StartType {}
