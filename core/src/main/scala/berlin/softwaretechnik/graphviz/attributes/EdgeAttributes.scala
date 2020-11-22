package berlin.softwaretechnik.graphviz.attributes;
case class EdgeAttributes (
  /**
    * Hyperlinks incorporated into device-dependent output. 
    * At present, used in ps2, cmap, i*map and svg formats. 
    * For all these formats, URLs can be attached to nodes, edges and
    * clusters. URL attributes can also be attached to the root graph in ps2,
    * cmap and i*map formats. This serves as the base URL for relative URLs in the 
    * former, and as the default image map file in the latter.
    * For svg, cmapx and imap output, the active area for a node is its 
    * visible image. 
    * For example, an unfilled node with no drawn boundary will only be active on its label. 
    * For other output, the active area is its bounding box.
    * The active area for a cluster is its bounding box. 
    * For edges, the active areas are small circles where the edge contacts its head
    * and tail nodes. In addition, for svg, cmapx and imap, the active area 
    * includes a thin polygon approximating the edge. The circles may 
    * overlap the related node, and the edge URL dominates.
    * If the edge has a label, this will also be active. 
    * Finally, if the edge has a head or tail label, this will also be active.
    * Note that, for edges, the attributes <a rel="attr">headURL</a>,
    * <a rel="attr">tailURL</a>, <a rel="attr">labelURL</a> and
    * <a rel="attr">edgeURL</a> allow control of various parts of an
    * edge. Also note that, if active areas of two edges overlap, it is unspecified 
    * which area dominates.
    */
  URL: String = null,
  
  /**
    * Style of arrowhead on the head node of an edge. 
    * See also the <a rel="attr">dir</a> attribute, 
    * and the <a rel="note">undirected</a> note.            
    */
  arrowhead: ArrowType = null,
  
  /**
    * Multiplicative scale factor for arrowheads.            
    */
  arrowsize: java.lang.Double = null,
  
  /**
    * Style of arrowhead on the tail node of an edge. 
    * See also the <a rel="attr">dir</a> attribute, 
    * and the <a rel="note">undirected</a> note.            
    */
  arrowtail: ArrowType = null,
  
  /**
    * Basic drawing color for graphics, not text. For the latter, use the
    * <a rel="attr">fontcolor</a> attribute.
    * For edges, the value
    * can either be a single <a rel="type">color</a> or a <a rel="type">colorList</a>.
    * In the latter case, the edge is drawn using parallel splines or lines,
    * one for each color in the list, in the order given.
    * The head arrow, if any, is drawn using the first color in the list, 
    * and the tail arrow, if any, the second color. This supports the common 
    * case of drawing opposing edges, but using parallel splines instead of 
    * separately routed multiedges.
    */
  color: ColorOrList = null,
  
  /**
    * This attribute specifies a color scheme namespace. If defined, it specifies
    * the context for interpreting color names. In particular, if a 
    * <a rel="type">color</a> value has form <code>xxx</code> or <code>//xxx</code>, 
    * then the color <code>xxx</code> will be evaluated according to the current color scheme.
    * If no color scheme is set, the standard X11 naming is used.
    * For example, if <code>colorscheme=bugn9</code>, then <code>color=7</code>
    * is interpreted as <code>/bugn9/7</code>.
    */
  colorscheme: String = null,
  
  /**
    * Comments are inserted into output. Device-dependent.
    */
  comment: String = null,
  
  /**
    * If <span class="val">false</span>, the edge is not used in ranking the nodes.
    */
  constraint: java.lang.Boolean = null,
  
  /**
    * If <span class="val">true</span>, attach edge label to edge by a 2-segment
    * polyline, underlining the label, then going to the closest point of spline.
    */
  decorate: java.lang.Boolean = null,
  
  /**
    * Set edge type for drawing arrowheads. This indicates which ends of the
    * edge should be decorated with an arrowhead. The actual style of the
    * arrowhead can be specified using the <a rel="attr">arrowhead</a>
    * and <a rel="attr">arrowtail</a> attributes.
    * See <a rel="note">undirected</a>.
    */
  dir: DirType = null,
  
  /**
    * If <a rel="attr">edgeURL</a> is defined, this is the link used for the non-label
    * parts of an edge. This value overrides any <a rel="attr">URL</a>
    * defined for the edge.
    * Also, this value is used near the head or tail node unless overridden
    * by a <a rel="attr">headURL</a> or <a rel="attr">tailURL</a> value,
    * respectively.
    * See <a rel="note">undirected</a>.
    */
  edgeURL: String = null,
  
  /**
    * Synonym for <a rel="attr">edgeURL</a>.
    */
  edgehref: String = null,
  
  /**
    * If the edge has a <a rel="attr">URL</a> or <a rel="attr">edgeURL</a>
    * attribute, this attribute determines which window of the 
    * browser is used
    * for the URL attached to the non-label part of the edge. 
    * Setting it to &quot;_graphviz&quot; will open a new window if it 
    * doesn't already exist, or reuse it if it does.
    * If undefined, the value of the <a rel="attr">target</a> is used.
    */
  edgetarget: String = null,
  
  /**
    * Tooltip annotation attached to the non-label part of an edge. 
    * This is used only if the edge has a <a rel="attr">URL</a> 
    * or <a rel="attr">edgeURL</a> attribute.
    */
  edgetooltip: String = null,
  
  /**
    * Color used for text.
    */
  fontcolor: Color = null,
  
  /**
    * Font used for text. This very much depends on the output format and, for 
    * non-bitmap output such as PostScript or SVG, the availability of the font
    * when the graph is displayed or printed. As such, it is best to rely on
    * font faces that are generally available, such as Times-Roman, Helvetica or
    * Courier.
    * If Graphviz was built using the 
    * <a href="http://pdx.freedesktop.org/~fontconfig/fontconfig-user.html">fontconfig library</a>, the latter library
    * will be used to search for the font. However, if the <a rel="attr">fontname</a> string
    * contains a slash character &quot;/&quot;, it is treated as a pathname for the font
    * file, though font lookup will append the usual font suffixes.
    * If Graphviz does not use fontconfig, <a rel="attr">fontname</a> will be
    * considered the name of a Type 1 or True Type font file. 
    * If you specify <code>fontname=schlbk</code>, the tool will look for a 
    * file named  <code>schlbk.ttf</code> or <code>schlbk.pfa</code> or <code>schlbk.pfb</code>
    * in one of the directories specified by 
    * the <a rel="attr">fontpath</a> attribute.
    * The lookup does support various aliases for the common fonts.
    */
  fontname: String = null,
  
  /**
    * Font size, in <a rel="note">points</a>, used for text.
    */
  fontsize: java.lang.Double = null,
  
  /**
    * If <a rel="attr">headURL</a> is defined, it is
    * output as part of the head label of the edge. 
    * Also, this value is used near the head node, overriding any
    * <a rel="attr">URL</a> value.
    * See <a rel="note">undirected</a>.
    */
  headURL: String = null,
  
  /**
    * If <span class="val">true</span>, the head of an edge is clipped to the boundary of the head node;
    * otherwise, the end of the edge goes to the center of the node, or the
    * center of a port, if applicable.
    */
  headclip: java.lang.Boolean = null,
  
  /**
    * Synonym for <a rel="attr">headURL</a>.
    */
  headhref: String = null,
  
  /**
    * Text label to be placed near head of edge.
    * See <a rel="note">undirected</a>.
    */
  headlabel: LabelString = null,
  
  /**
    * Indicates where on the head node to attach the head of the edge.
    * In the default case, the edge is aimed towards the center of the node,
    * and then clipped at the node boundary.
    * See <a rel="note">undirected</a>.
    */
  headport: PortPosition = null,
  
  /**
    * If the edge has a <a rel="attr">headURL</a>, 
    * this attribute determines which window of the 
    * browser is used
    * for the URL. Setting it to &quot;_graphviz&quot; will open a new window if it 
    * doesn't already exist, or reuse it if it does.
    * If undefined, the value of the <a rel="attr">target</a> is used.
    */
  headtarget: String = null,
  
  /**
    * Tooltip annotation attached to the head of an edge. This is used only
    * if the edge has a <a rel="attr">headURL</a> attribute.
    */
  headtooltip: String = null,
  
  /**
    * Synonym for <a rel="attr">URL</a>.
    */
  href: String = null,
  
  /**
    * Text label attached to objects.
    * If a node's <a rel="attr">shape</a> is record, then the label can
    * have a <a href="http://www.graphviz.org/doc/info/shapes.html#record">special format</a> 
    * which describes the record layout.
    */
  label: LabelString = null,
  
  /**
    * If <a rel="attr">labelURL</a> is defined, this is the link used for the label
    * of an edge. This value overrides any <a rel="attr">URL</a>
    * defined for the edge.
    */
  labelURL: String = null,
  
  /**
    * This, along with <a rel="attr">labeldistance</a>, determine 
    * where the
    * headlabel (taillabel) are placed with respect to the head (tail)
    * in polar coordinates. The origin in the coordinate system is
    * the point where the edge touches the node. The ray of 0 degrees
    * goes from the origin back along the edge, parallel to the edge
    * at the origin. 
    * The angle, in degrees, specifies the rotation from the 0 degree ray,
    * with positive angles moving counterclockwise and negative angles
    * moving clockwise.
    */
  labelangle: java.lang.Double = null,
  
  /**
    * Multiplicative scaling factor adjusting the distance that 
    * the headlabel (taillabel) is from the head (tail) node.
    * The default distance is 10 points. See <a rel="attr">labelangle</a>
    * for more details.
    */
  labeldistance: java.lang.Double = null,
  
  /**
    * If true, allows edge labels to be less constrained in position.
    * In particular, it may appear on top of other edges.
    */
  labelfloat: java.lang.Boolean = null,
  
  /**
    * Color used for headlabel and taillabel.
    * If not set, defaults to edge's fontcolor.
    */
  labelfontcolor: Color = null,
  
  /**
    * Font used for headlabel and taillabel. 
    * If not set, defaults to edge's fontname.
    */
  labelfontname: String = null,
  
  /**
    * Font size, in <a rel="note">points</a>, used for headlabel and taillabel.
    * If not set, defaults to edge's fontsize.
    */
  labelfontsize: java.lang.Double = null,
  
  /**
    * Synonym for <a rel="attr">labelURL</a>.
    */
  labelhref: String = null,
  
  /**
    * If the edge has a <a rel="attr">URL</a> or <a rel="attr">labelURL</a>
    * attribute, this attribute determines which window of the 
    * browser is used
    * for the URL attached to the label.
    * Setting it to &quot;_graphviz&quot; will open a new window if it 
    * doesn't already exist, or reuse it if it does.
    * If undefined, the value of the <a rel="attr">target</a> is used.
    */
  labeltarget: String = null,
  
  /**
    * Tooltip annotation attached to label of an edge. 
    * This is used only if the edge has a <a rel="attr">URL</a> 
    * or <a rel="attr">labelURL</a> attribute.
    */
  labeltooltip: String = null,
  
  /**
    * Specifies layers in which the node or edge is present.
    */
  layer: LayerRange = null,
  
  /**
    * Preferred edge length, in inches.
    */
  len: java.lang.Double = null,
  
  /**
    * Logical head of an edge. When <a rel="attr">compound</a> is true,
    * if <a rel="attr">lhead</a> is defined and is the name of a cluster containing 
    * the real head,
    * the edge is clipped to the boundary of the cluster.
    * See <a rel="note">undirected</a>.
    */
  lhead: String = null,
  
  /**
    * Label position, in <a rel="note">points</a>.
    * The position indicates the center of the label.
    */
  lp: Point = null,
  
  /**
    * Logical tail of an edge. When <a rel="attr">compound</a> is true,
    * if <a rel="attr">ltail</a> is defined and is the name of a cluster 
    * containing the real tail,
    * the edge is clipped to the boundary of the cluster.
    * See <a rel="note">undirected</a>.
    */
  ltail: String = null,
  
  /**
    * Minimum edge length (rank difference between head and tail).
    */
  minlen: java.lang.Integer = null,
  
  /**
    * By default, the justification of multi-line labels is done within the
    * largest context that makes sense. Thus, in the label of a polygonal
    * node, a left-justified line will align with the left side of the node
    * (shifted by the prescribed <a rel="attr">margin</a>).
    * In record nodes, left-justified
    * line will line up with the left side of the enclosing column of fields.
    * If <a rel="attr">nojustify</a> is <span class="val">true</span>, multi-line labels will be justified 
    * in the context of itself. For example, if the attribute is set, 
    * the first label line is long, and the second is shorter and left-justified,
    * the second will align with the left-most character in the first line,
    * regardless of  how large the node might be.
    */
  nojustify: java.lang.Boolean = null,
  
  /**
    * Position of node, or spline control points.
    * For nodes, the position indicates the center of the node.
    * On output, the coordinates are in <a href="#points">points</a>.
    * In neato and fdp, pos can be used to set the initial position of a node.
    * By default, the coordinates are assumed to be in inches. However, the
    * <a href="http://www.graphviz.org/doc/info/command.html#d:s">-s</a> command line flag can be used to specify
    * different units.
    * When the <a href="http://www.graphviz.org/doc/info/command.html#d:n">-n</a> command line flag is used with
    * neato, it is assumed the positions have been set by one of the layout
    * programs, and are therefore in points. Thus, <code>neato -n</code> can accept
    * input correctly without requiring a <code>-s</code> flag and, in fact, 
    * ignores any such flag.
    */
  pos: SplineType = null,
  
  /**
    * Edges with the same head and the same <a rel="attr">samehead</a> value are aimed
    * at the same point on the head.
    * See <a rel="note">undirected</a>.
    */
  samehead: String = null,
  
  /**
    * Edges with the same tail and the same <a rel="attr">sametail</a> value are aimed
    * at the same point on the tail.
    * See <a rel="note">undirected</a>.
    */
  sametail: String = null,
  
  /**
    * Print guide boxes in PostScript at the beginning of
    * routesplines if 1, or at the end if 2. (Debugging)
    */
  showboxes: java.lang.Integer = null,
  
  /**
    * Set style for node or edge. For cluster subgraph, if &quot;filled&quot;, the
    * cluster box's background is filled.
    */
  style: Style = null,
  
  /**
    * If <a rel="attr">tailURL</a> is defined, it is
    * output as part of the tail label of the edge.
    * Also, this value is used near the tail node, overriding any
    * <a rel="attr">URL</a> value.
    * See <a rel="note">undirected</a>.
    */
  tailURL: String = null,
  
  /**
    * If <span class="val">true</span>, the tail of an edge is clipped to the boundary of the tail node;
    * otherwise, the end of the edge goes to the center of the node, or the
    * center of a port, if applicable.
    */
  tailclip: java.lang.Boolean = null,
  
  /**
    * Synonym for <a rel="attr">tailURL</a>.
    */
  tailhref: String = null,
  
  /**
    * Text label to be placed near tail of edge.
    * See <a rel="note">undirected</a>.
    */
  taillabel: LabelString = null,
  
  /**
    * Indicates where on the tail node to attach the tail of the edge.
    * See <a rel="note">undirected</a>.
    */
  tailport: PortPosition = null,
  
  /**
    * If the edge has a <a rel="attr">tailURL</a>, 
    * this attribute determines which window of the 
    * browser is used
    * for the URL. Setting it to &quot;_graphviz&quot; will open a new window if it 
    * doesn't already exist, or reuse it if it does.
    * If undefined, the value of the <a rel="attr">target</a> is used.
    */
  tailtarget: String = null,
  
  /**
    * Tooltip annotation attached to the tail of an edge. This is used only
    * if the edge has a <a rel="attr">tailURL</a> attribute.
    */
  tailtooltip: String = null,
  
  /**
    * If the object has a URL, this attribute determines which window 
    * of the browser is used for the URL.
    * See <a href="http://www.w3.org/TR/html401/present/frames.html#adef-target">W3C documentation</a>.
    */
  target: String = null,
  
  /**
    * Tooltip annotation attached to the node or edge. If unset, Graphviz
    * will use the object's <a rel="attr">label</a> if defined.
    * Note that if the label is a record specification or an HTML-like
    * label, the resulting tooltip may be unhelpful. In this case, if
    * tooltips will be generated, the user should set a <tt>tooltip</tt>
    * attribute explicitly.
    */
  tooltip: String = null,
  
  /**
    * Weight of edge. In dot, the heavier the weight, the shorter,
    * straighter and more vertical the edge is. In neato, the heavier the
    * weight, the more neato will try to place the end points so that the
    * length of the edge is <a rel="attr">len</a>.
    */
  weight: java.lang.Double = null
) {
  def toAttributeMap(): Seq[(String, Any)] = Seq(
  "URL" -> URL,
  "arrowhead" -> arrowhead,
  "arrowsize" -> arrowsize,
  "arrowtail" -> arrowtail,
  "color" -> color,
  "colorscheme" -> colorscheme,
  "comment" -> comment,
  "constraint" -> constraint,
  "decorate" -> decorate,
  "dir" -> dir,
  "edgeURL" -> edgeURL,
  "edgehref" -> edgehref,
  "edgetarget" -> edgetarget,
  "edgetooltip" -> edgetooltip,
  "fontcolor" -> fontcolor,
  "fontname" -> fontname,
  "fontsize" -> fontsize,
  "headURL" -> headURL,
  "headclip" -> headclip,
  "headhref" -> headhref,
  "headlabel" -> headlabel,
  "headport" -> headport,
  "headtarget" -> headtarget,
  "headtooltip" -> headtooltip,
  "href" -> href,
  "label" -> label,
  "labelURL" -> labelURL,
  "labelangle" -> labelangle,
  "labeldistance" -> labeldistance,
  "labelfloat" -> labelfloat,
  "labelfontcolor" -> labelfontcolor,
  "labelfontname" -> labelfontname,
  "labelfontsize" -> labelfontsize,
  "labelhref" -> labelhref,
  "labeltarget" -> labeltarget,
  "labeltooltip" -> labeltooltip,
  "layer" -> layer,
  "len" -> len,
  "lhead" -> lhead,
  "lp" -> lp,
  "ltail" -> ltail,
  "minlen" -> minlen,
  "nojustify" -> nojustify,
  "pos" -> pos,
  "samehead" -> samehead,
  "sametail" -> sametail,
  "showboxes" -> showboxes,
  "style" -> style,
  "tailURL" -> tailURL,
  "tailclip" -> tailclip,
  "tailhref" -> tailhref,
  "taillabel" -> taillabel,
  "tailport" -> tailport,
  "tailtarget" -> tailtarget,
  "tailtooltip" -> tailtooltip,
  "target" -> target,
  "tooltip" -> tooltip,
  "weight" -> weight).filter{case(k, v) => v != null}
}