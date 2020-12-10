package berlin.softwaretechnik.graphviz.attributes;
import java.util.Map;
import java.util.stream.Collectors;
public class NodeAttributes {
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
  String URL;
  
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
  ColorOrList color;
  
  /**
    * This attribute specifies a color scheme namespace. If defined, it specifies
    * the context for interpreting color names. In particular, if a 
    * <a rel="type">color</a> value has form <code>xxx</code> or <code>//xxx</code>, 
    * then the color <code>xxx</code> will be evaluated according to the current color scheme.
    * If no color scheme is set, the standard X11 naming is used.
    * For example, if <code>colorscheme=bugn9</code>, then <code>color=7</code>
    * is interpreted as <code>/bugn9/7</code>.
    */
  String colorscheme;
  
  /**
    * Comments are inserted into output. Device-dependent.
    */
  String comment;
  
  /**
    * Distortion factor for <a rel="attr">shape</a>=polygon. 
    * Positive values cause top part to
    * be larger than bottom; negative values do the opposite.
    */
  java.lang.Double distortion;
  
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
  Color fillcolor;
  
  /**
    * If true, the node size is specified by the values of the
    * <a rel="attr">width</a>  
    * and <a rel="attr">height</a> attributes only 
    * and is not expanded to contain the text label.
    */
  java.lang.Boolean fixedsize;
  
  /**
    * Color used for text.
    */
  Color fontcolor;
  
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
  String fontname;
  
  /**
    * Font size, in <a rel="note">points</a>, used for text.
    */
  java.lang.Double fontsize;
  
  /**
    * If the end points of an edge belong to the same group, i.e., have the
    * same group attribute, parameters are set to avoid crossings and keep
    * the edges straight.
    */
  String group;
  
  /**
    * Height of node, in inches. This is taken as the initial, minimum height
    * of the node. If <a rel="attr">fixedsize</a> is true, this
    * will be the final height of the node. Otherwise, if the node label
    * requires more height to fit, the node's height will be increased to
    * contain the label. Note also that, if the output format is dot, the
    * value given to <a rel="attr">height</a> will be the final value.
    */
  java.lang.Double height;
  
  /**
    * Gives the name of a file containing an image to be displayed inside
    * a node. The image file must be in one of the recognized formats, 
    * typically JPEG, PNG, GIF or Postscript, and be able to be converted
    * into the desired output format.  
    * Unlike with the <a rel="attr">shapefile</a> attribute, 
    * the image is treated as node
    * content rather than the entire node. In particular, an image can
    * be contained in a node of any shape, not just a rectangle.
    */
  String image;
  
  /**
    * Attribute controlling how an image fills its
    * containing node. In general, the image is given its natural size,
    * (cf. <a rel="attr">dpi</a>),
    * and the node size is made large enough to contain its image, its
    * label, its margin, and its peripheries. 
    * Its width and height will also be at least as large as its
    * minimum <a rel="attr">width</a> and <a rel="attr">height</a>. 
    * If, however, <code>fixedsize=true</code>,
    * the width and height attributes specify the exact size of the node. 
    * During rendering, in the default case (<code>imagescale=false</code>),
    * the image retains its natural size.
    * If <span class="val">true</span>,
    * the image is uniformly scaled (i.e., its aspect ratio is
    * preserved) to fit inside the node. 
    * At least one dimension of the image will be as large as possible
    * given the size of the node.
    * When <span class="val">width</span>,
    * the width of the image is scaled to fill the node width.
    * The corresponding property holds when <tt>imagescale=height</tt>.
    * When <span class="val">both</span>,
    * both the height and the width are scaled separately to fill the node.
    * In all cases, if a dimension of the image is larger than the
    * corresponding dimension of the node, that dimension of the
    * image is scaled down to fit the node. As with the case of
    * expansion, if <code>imagescale=true</code>, width and height are
    * scaled uniformly.
    */
  String imagescale;
  
  /**
    * Text label attached to objects.
    * If a node's <a rel="attr">shape</a> is record, then the label can
    * have a <a href="http://www.graphviz.org/doc/info/shapes.html#record">special format</a> 
    * which describes the record layout.
    */
  LabelString label;
  
  /**
    * Specifies layers in which the node or edge is present.
    */
  LayerRange layer;
  
  /**
    * For graphs, this sets x and y margins of canvas, in inches. If the margin
    * is a single double, both margins are set equal to the given value.
    * Note that the margin is not part of the drawing but just empty space 
    * left around the drawing. It basically corresponds to a translation of 
    * drawing, as would be necessary to center a drawing on a page. Nothing
    * is actually drawn in the margin. To actually extend the background of
    * a drawing, see the <a rel="attr">pad</a> attribute.
    * For nodes, this attribute specifies space left around the node's label.
    * By default, the value is <code>0.11,0.055</code>.
    */
  PointF margin;
  
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
  java.lang.Boolean nojustify;
  
  /**
    * Set number of peripheries used in polygonal shapes and cluster
    * boundaries. Note that
    * <a href="http://www.graphviz.org/doc/info/shapes.html#epsf">user-defined shapes</a> are treated as a 
    * form of box shape, so the default
    * peripheries value is 1 and the user-defined shape will be drawn in
    * a bounding rectangle. Setting <code>peripheries=0</code> will turn this off.
    * Also, 1 is the maximum peripheries value for clusters.
    */
  java.lang.Integer peripheries;
  
  /**
    * If true and the node has a pos attribute on input, neato prevents the
    * node from moving from the input position. This property can also be specified
    * in the pos attribute itself (cf. the <a rel="attr">point</a> type).
    */
  java.lang.Boolean pin;
  
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
  SplineType pos;
  
  /**
    * Rectangles for fields of records, in <a rel="note">points</a>.
    */
  Rect rects;
  
  /**
    * If true, force polygon to be regular.
    */
  java.lang.Boolean regular;
  
  /**
    * This specifies nodes to be used as the center of the 
    * layout and the root of the generated spanning tree. As a graph attribute,
    * this gives the name of the node. As a node attribute (circo only), it
    * specifies that the node should be used as a central node. In twopi,
    * this will actually be the central node. In circo, the block containing
    * the node will be central in the drawing of its connected component.
    * If not defined,
    * twopi will pick a most central node, and circo will pick a random node.
    */
  String root;
  
  /**
    * If the input graph defines the <a rel="attr"><a rel="attr">vertices</a></a> 
    * attribute, and output is dot or xdot, this gives
    * the number of points used for a node whose shape is a circle or ellipse.
    * It plays the same role in neato, when adjusting the layout to avoid
    * overlapping nodes, and in image maps.
    */
  java.lang.Integer samplepoints;
  
  /**
    * Set the shape of a node.
    */
  Shape shape;
  
  /**
    * (Deprecated) If defined, shapefile specifies a file containing user-supplied node content. 
    * The <a rel="attr">shape</a> of the node is set to box. 
    * The image in the shapefile must be
    * rectangular. The image formats supported as well as the precise semantics of 
    * how the file is used depends on the
    * <a href="http://www.graphviz.org/doc/info/output.html">output format</a>.  For further details, see
    * <a href="http://www.graphviz.org/Documentation/html/shapehowto.html#ext_image">External PostScript files</a>.
    * There is one exception to this usage. 
    * If <a rel="attr">shape</a> is set to &quot;epsf&quot;, shapefile gives
    * a filename containing a definition of the node in PostScript. 
    * The graphics defined must be contain all of the
    * node content, including any desired boundaries.
    * For further details, see
    * <a href="http://www.graphviz.org/Documentation/html/shapehowto.html#ext_ps">
    * External PostScript files</a>.
    */
  String shapefile;
  
  /**
    * Print guide boxes in PostScript at the beginning of
    * routesplines if 1, or at the end if 2. (Debugging)
    */
  java.lang.Integer showboxes;
  
  /**
    * Number of sides if <a rel="attr">shape</a>=polygon.
    */
  java.lang.Integer sides;
  
  /**
    * Skew factor for <a rel="attr">shape</a>=polygon. Positive values
    * skew top of polygon to right; negative to left.
    */
  java.lang.Double skew;
  
  /**
    * Set style for node or edge. For cluster subgraph, if &quot;filled&quot;, the
    * cluster box's background is filled.
    */
  Style style;
  
  /**
    * If the object has a URL, this attribute determines which window 
    * of the browser is used for the URL.
    * See <a href="http://www.w3.org/TR/html401/present/frames.html#adef-target">W3C documentation</a>.
    */
  String target;
  
  /**
    * Tooltip annotation attached to the node or edge. If unset, Graphviz
    * will use the object's <a rel="attr">label</a> if defined.
    * Note that if the label is a record specification or an HTML-like
    * label, the resulting tooltip may be unhelpful. In this case, if
    * tooltips will be generated, the user should set a <tt>tooltip</tt>
    * attribute explicitly.
    */
  String tooltip;
  
  /**
    * If the input graph defines this attribute, the node is polygonal,
    * and output is dot or xdot, this attribute provides the
    * coordinates of the vertices of the node's polygon, in inches.
    * If the node is an ellipse or circle, the 
    * <a rel="attr">samplepoints</a> attribute affects
    * the output.
    */
  PointFList vertices;
  
  /**
    * Width of node, in inches. This is taken as the initial, minimum width
    * of the node. If <a rel="attr">fixedsize</a> is true, this
    * will be the final width of the node. Otherwise, if the node label
    * requires more width to fit, the node's width will be increased to
    * contain the label. Note also that, if the output format is dot, the
    * value given to <a rel="attr">width</a> will be the final value.
    */
  java.lang.Double width;
  
  /**
    * Provides z coordinate value for 3D layouts and displays. If the
    * graph has <a rel="attr">dim</a> set to 3 (or more), 
    * neato will use a node's <a rel="attr">z</a> value
    * for the z coordinate of its initial position if 
    * its <a rel="attr">pos</a> attribute is also defined.
    * Even if no <a rel="attr">z</a> values are specified in the input, it is necessary to
    * declare a <a rel="attr">z</a> attribute for nodes, e.g, using <tt>node[z=&quot;&quot;]</tt>
    * in order to get z values on output.
    * Thus, setting <tt>dim=3</tt> but not declaring <a rel="attr">z</a> will 
    * cause <tt>neato -Tvrml</tt> to
    * layout the graph in 3D but project the layout onto the xy-plane
    * for the rendering. If the <a rel="attr">z</a> attribute is declared, the final rendering
    * will be in 3D.
    */
  java.lang.Double z;

  public Map<String, Object> toAttributeMap() { 
    return Map.ofEntries(
      Map.entry("URL", URL),
      Map.entry("color", color),
      Map.entry("colorscheme", colorscheme),
      Map.entry("comment", comment),
      Map.entry("distortion", distortion),
      Map.entry("fillcolor", fillcolor),
      Map.entry("fixedsize", fixedsize),
      Map.entry("fontcolor", fontcolor),
      Map.entry("fontname", fontname),
      Map.entry("fontsize", fontsize),
      Map.entry("group", group),
      Map.entry("height", height),
      Map.entry("image", image),
      Map.entry("imagescale", imagescale),
      Map.entry("label", label),
      Map.entry("layer", layer),
      Map.entry("margin", margin),
      Map.entry("nojustify", nojustify),
      Map.entry("peripheries", peripheries),
      Map.entry("pin", pin),
      Map.entry("pos", pos),
      Map.entry("rects", rects),
      Map.entry("regular", regular),
      Map.entry("root", root),
      Map.entry("samplepoints", samplepoints),
      Map.entry("shape", shape),
      Map.entry("shapefile", shapefile),
      Map.entry("showboxes", showboxes),
      Map.entry("sides", sides),
      Map.entry("skew", skew),
      Map.entry("style", style),
      Map.entry("target", target),
      Map.entry("tooltip", tooltip),
      Map.entry("vertices", vertices),
      Map.entry("width", width),
      Map.entry("z", z)).entrySet().stream()
        .filter(entry -> entry.getValue() != null)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }}
