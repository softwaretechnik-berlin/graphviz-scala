package berlin.softwaretechnik.graphviz.attributes;
case class SubgraphAttributes (
  /**
    * Spring constant used in virtual physical model. It roughly corresponds
    * to an ideal edge length (in inches), in that increasing K tends to 
    * increase the distance between nodes.
    * Note that the edge attribute <a rel="attr">len</a> can be used to
    * override this value for adjacent nodes.
    */
  K: java.lang.Double = null,
  
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
    * When attached to the root graph, this color is used as the background for 
    * entire canvas. When a cluster attribute, it is used as the initial
    * background for the cluster. If a cluster has a filled 
    * <a rel="attr">style</a>, the
    * cluster's <a rel="attr">fillcolor</a> will overlay the 
    * background color.
    * If no background color is specified for the root graph, no graphics
    * operation are performed on the background. This works fine for
    * PostScript but for bitmap output, all bits are initialized to something.
    * This means that when the bitmap output is included in some other
    * document, all of the bits within the bitmap's bounding box will be
    * set, overwriting whatever color or graphics where already on the page.
    * If this effect is not desired, and you only want to set bits explicitly
    * assigned in drawing the graph, set <a rel="attr">bgcolor</a>=&quot;transparent&quot;.
    */
  bgcolor: Color = null,
  
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
    * Color used to fill the background of a node or cluster 
    * assuming <a rel="attr">style</a>=filled.
    * If <a rel="attr">fillcolor</a> is not defined, <a rel="attr">color</a> is 
    * used. (For clusters, if <a rel="attr">color</a> is not defined, 
    * <a rel="attr">bgcolor</a> is used.) If this is not defined,
    * the default is used, except for 
    * <a rel="attr">shape</a>=point or when the output
    * format is MIF,
    * which use black by default.
    * Note that a cluster inherits the root graph's attributes if defined.
    * Thus, if the root graph has defined a <a rel="attr">fillcolor</a>, this will override a
    * <a rel="attr">color</a> or <a rel="attr">bgcolor</a> attribute set for the cluster.
    */
  fillcolor: Color = null,
  
  /**
    * If true, the node size is specified by the values of the
    * <a rel="attr">width</a>  
    * and <a rel="attr">height</a> attributes only 
    * and is not expanded to contain the text label.
    */
  fixedsize: java.lang.Boolean = null,
  
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
    * Text label attached to objects.
    * If a node's <a rel="attr">shape</a> is record, then the label can
    * have a <a href="http://www.graphviz.org/doc/info/shapes.html#record">special format</a> 
    * which describes the record layout.
    */
  label: LabelString = null,
  
  /**
    * Justification for cluster labels. If <span class="val">r</span>, the label
    * is right-justified within bounding rectangle; if <span class="val">l</span>, left-justified;
    * else the label is centered.
    * Note that a subgraph inherits attributes from its parent. Thus, if
    * the root graph sets <a rel="attr">labeljust</a> to <span class="val">l</span>, the subgraph inherits
    * this value.
    */
  labeljust: String = null,
  
  /**
    * Top/bottom placement of graph and cluster labels. 
    * If the attribute is <span class="val">t</span>, place label at the top;
    * if the attribute is <span class="val">b</span>, place label at the bottom.
    * By default, root
    * graph labels go on the bottom and cluster labels go on the top.
    * Note that a subgraph inherits attributes from its parent. Thus, if
    * the root graph sets <a rel="attr">labelloc</a> to <span class="val">b</span>, the subgraph inherits
    * this value.
    */
  labelloc: String = null,
  
  /**
    * Label position, in <a rel="note">points</a>.
    * The position indicates the center of the label.
    */
  lp: Point = null,
  
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
    * Color used to draw the bounding box around a cluster.
    * If <a rel="attr">pencolor</a> is not defined, <a rel="attr">color</a> is 
    * used. If this is not defined, <a rel="attr">bgcolor</a> is used.
    * If this is not defined, the default is used.
    * Note that a cluster inherits the root graph's attributes if defined.
    * Thus, if the root graph has defined a <a rel="attr">pencolor</a>, this will override a
    * <a rel="attr">color</a> or <a rel="attr">bgcolor</a> attribute set for the cluster.
    */
  pencolor: Color = null,
  
  /**
    * Set style for node or edge. For cluster subgraph, if &quot;filled&quot;, the
    * cluster box's background is filled.
    */
  style: Style = null,
  
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
    * Rank constraints on the nodes in a subgraph.
    * If <span class="val">same</span>, all nodes are placed on the same rank. 
    * If <span class="val">min</span>, all nodes are placed on the minimum rank. 
    * If <span class="val">source</span>, all nodes are placed on the minimum rank, and
    * the only nodes on the minimum rank belong to some subgraph whose
    * rank attribute is &quot;source&quot; or &quot;min&quot;. 
    * Analogous criteria hold for <a rel="attr">rank</a>=<span class="val">max</span> and <a rel="attr">rank</a>=<span class="val">sink</span>.
    * (Note: the
    * minimum rank is topmost or leftmost, and the maximum rank is bottommost
    * or rightmost.)
    */
  rank: RankType = null
) {
  def toAttributeMap(): Seq[(String, Any)] = Seq(
  "K" -> K,
  "URL" -> URL,
  "bgcolor" -> bgcolor,
  "color" -> color,
  "colorscheme" -> colorscheme,
  "fillcolor" -> fillcolor,
  "fixedsize" -> fixedsize,
  "fontcolor" -> fontcolor,
  "fontname" -> fontname,
  "fontsize" -> fontsize,
  "label" -> label,
  "labeljust" -> labeljust,
  "labelloc" -> labelloc,
  "lp" -> lp,
  "nojustify" -> nojustify,
  "pencolor" -> pencolor,
  "style" -> style,
  "target" -> target,
  "tooltip" -> tooltip,
  "rank" -> rank).filter{case(k, v) => v != null}
}