package berlin.softwaretechnik.graphviz.attributes;

/**

  */
trait ClusterMode {}

object ClusterMode {
  case object local extends ClusterMode {}
  case object global extends ClusterMode {}
  case object none extends ClusterMode {}
}


/**
  * For undirected edges <code>T -- H;</code>, one of the nodes, usually
  * the righthand one, is treated as the head for the purpose of 
  * interpreting <span class="val">forward</span> and <span class="val">back</span>.
  */
trait DirType {}

object DirType {
  case object forward extends DirType {}
  case object back extends DirType {}
  case object both extends DirType {}
  case object none extends DirType {}
}


/**
  * These specify the order in which nodes and edges are drawn in concrete
  * output. The default <span class="val">breadthfirst</span> is the simplest, but when the graph
  * layout does not avoid edge-node overlap, this mode will sometimes have
  * edges drawn over nodes and sometimes on top of nodes. If the mode
  * <span class="val">nodesfirst</span> is chosen, all nodes are drawn first, followed by the
  * edges. This guarantees an edge-node overlap will not be mistaken for
  * an edge ending at a node. On the other hand, usually for aesthetic
  * reasons, it may be desirable that all edges appear beneath nodes, even
  * if the resulting drawing is ambiguous. This can be achieved by choosing
  * <span class="val">edgesfirst</span>.
  */
trait OutputMode {}

object OutputMode {
  case object breadthfirst extends OutputMode {}
  case object nodesfirst extends OutputMode {}
  case object edgesfirst extends OutputMode {}
}


/**
  * These specify the granularity of packing connected components when
  * the <a rel="attr">pack</a> attribute is true. A value of <span class="val">node</span> causes
  * packing at the node and edge label, with no overlapping of these objects.
  * This produces a layout with the least area, but it also allows interleaving,
  * where a node of one component may lie between two nodes in another
  * component. A value of <span class="val">graph</span> does a packing using the bounding box of the
  * component. Thus, there will be a rectangular region around a component
  * free of elements of any other component.
  * A value of <span class="val">clust</span> guarantees that top-level clusters are kept intact.
  * What effect a value has also depends on the layout algorithm. For
  * example, neato does not support clusters, so a value of <span class="val">clust</span> will
  * have the same effect as the default <span class="val">node</span> value.
  */
trait PackMode {}

object PackMode {
  case object node extends PackMode {}
  case object clust extends PackMode {}
  case object graph extends PackMode {}
}


/**
  * These specify the 8 row or column major orders for traversing a 
  * rectangular array, the first character corresponding to the major
  * order and the second to the minor order. Thus, for &quot;BL&quot;, the
  * major order is from bottom to top, and the minor order is from left
  * to right. This means the bottom row is traversed first, from left
  * to right, then the next row up, from left to right, and so on,
  * until the topmost row is traversed.
  */
trait PageDir {}

object PageDir {
  case object BL extends PageDir {}
  case object BR extends PageDir {}
  case object TL extends PageDir {}
  case object TR extends PageDir {}
  case object RB extends PageDir {}
  case object RT extends PageDir {}
  case object LB extends PageDir {}
  case object LT extends PageDir {}
}


/**

  */
trait RankType {}

object RankType {
  case object same extends RankType {}
  case object min extends RankType {}
  case object source extends RankType {}
  case object max extends RankType {}
  case object sink extends RankType {}
}


/**
  * Corresponding to directed graphs drawn
  * from top to bottom, from left to right, from bottom to top, and from
  * right to left, respectively.
  */
trait RankDir {}

object RankDir {
  case object TB extends RankDir {}
  case object LR extends RankDir {}
  case object BT extends RankDir {}
  case object RL extends RankDir {}
}


/**

  */
trait Shape {}

object Shape {
  case object box extends Shape {}
  case object polygon extends Shape {}
  case object ellipse extends Shape {}
  case object circle extends Shape {}
  case object point extends Shape {}
  case object egg extends Shape {}
  case object triangle extends Shape {}
  case object plaintext extends Shape {}
  case object diamond extends Shape {}
  case object trapezium extends Shape {}
  case object parallelogram extends Shape {}
  case object house extends Shape {}
  case object pentagon extends Shape {}
  case object hexagon extends Shape {}
  case object septagon extends Shape {}
  case object octagon extends Shape {}
  case object doublecircle extends Shape {}
  case object doubleoctagon extends Shape {}
  case object tripleoctagon extends Shape {}
  case object invtriangle extends Shape {}
  case object invtrapezium extends Shape {}
  case object invhouse extends Shape {}
  case object Mdiamond extends Shape {}
  case object Msquare extends Shape {}
  case object Mcircle extends Shape {}
  case object rect extends Shape {}
  case object rectangle extends Shape {}
  case object none extends Shape {}
  case object note extends Shape {}
  case object tab extends Shape {}
  case object box3d extends Shape {}
  case object component extends Shape {}
}