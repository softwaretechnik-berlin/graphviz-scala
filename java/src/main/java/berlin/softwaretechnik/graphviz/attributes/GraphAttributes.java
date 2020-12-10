package berlin.softwaretechnik.graphviz.attributes;
import java.util.Map;
import java.util.stream.Collectors;
public class GraphAttributes {
  /**
    * Specifies the path to images referenced within the graph.
    */
  String imagepath;
  
  /**
    * Factor damping force motions. On each iteration, a nodes movement
    * is limited to this factor of its potential motion. By being less than
    * 1.0, the system tends to &quot;cool&quot;, thereby preventing cycling.
    */
  java.lang.Double Damping;
  
  /**
    * Spring constant used in virtual physical model. It roughly corresponds
    * to an ideal edge length (in inches), in that increasing K tends to 
    * increase the distance between nodes.
    * Note that the edge attribute <a rel="attr">len</a> can be used to
    * override this value for adjacent nodes.
    */
  java.lang.Double K;
  
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
    * Bounding box of drawing in integer points.            
    */
  Rect bb;
  
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
  Color bgcolor;
  
  /**
    * If true, the drawing is centered in the output canvas.
    */
  java.lang.Boolean center;
  
  /**
    * Specifies the character encoding used when interpreting string input
    * as a text label. The default value is <span class="val">UTF-8</span>.
    * The other legal value is <span class="val">iso-8859-1</span> or, 
    * equivalently,
    * <span class="val">Latin1</span>. The <a rel="attr">charset</a> attribute is case-insensitive.
    * Note that if the character encoding used in the input does not
    * match the <a rel="attr">charset</a> value, the resulting output may be very strange.
    */
  String charset;
  
  /**
    * Mode used for handling clusters. If <a rel="attr">clusterrank</a> is <span class="val">local</span>, a
    * subgraph whose name begins with &quot;cluster&quot; is given special treatment.
    * The subgraph is laid out separately, and then integrated as a unit into
    * its parent graph, with a bounding rectangle drawn about it. 
    * If the cluster has a <a rel="attr">label</a> parameter, this label
    * is displayed within the rectangle.
    * Note also that there can be clusters within clusters.
    * At present, the modes <span class="val">global</span> and <span class="val">none</span>
    * appear to be identical, both turning off the special cluster processing.
    */
  ClusterMode clusterrank;
  
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
    * If <span class="val">true</span>, allow edges between clusters. (See <a rel="attr">lhead</a> and <a rel="attr">ltail</a> below.)
    */
  java.lang.Boolean compound;
  
  /**
    * If <span class="val">true</span>, use edge concentrators.
    */
  java.lang.Boolean concentrate;
  
  /**
    * This specifies the distance between nodes in separate connected
    * components. If set too small, connected components may overlap.
    * Only applicable if <a rel="attr">pack</a>=false.
    */
  java.lang.Double defaultdist;
  
  /**
    * Set the number of dimensions used for the layout. The maximum value
    * allowed is 10.
    */
  java.lang.Integer dim;
  
  /**
    * Only valid when <a rel="attr">mode</a>=&quot;ipsep&quot;.
    * If <span class="val">true</span>, constraints are generated for each edge in the largest (heuristic) 
    * directed acyclic subgraph such that the edge must point downwards.
    * If <span class="val">hier</span>, generates level constraints similar to those used with
    * <a rel="attr">mode</a>=&quot;hier&quot;. The main difference is that, in the latter
    * case, only these constraints are involved, so a faster solver can be used.
    */
  String diredgeconstraints;
  
  /**
    * This specifies the expected number of pixels per inch on a display device.
    * For bitmap output, this guarantees that text rendering will be
    * done more accurately, both in size and in placement. For SVG output,
    * it is used to guarantee that the dimensions in the output correspond to
    * the correct number of points or inches.
    */
  java.lang.Double dpi;
  
  /**
    * Terminating condition. If the length squared of all energy gradients are
    * &lt; <a rel="attr">epsilon</a>, the algorithm stops.
    */
  java.lang.Double epsilon;
  
  /**
    * Fraction to increase polygons (multiply
    * coordinates by 1 + esep) for purposes of spline edge routing. 
    * This should normally be strictly less than 
    * <a rel="attr">sep</a>.
    */
  java.lang.Double esep;
  
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
    * Allows user control of how basic fontnames are represented in SVG output.
    * If <a rel="attr">fontnames</a> is undefined or <span class="val">svg</span>, 
    * the output will try to use known SVG fontnames. For example, the
    * default font <code>Times-Roman</code> will be mapped to the
    * basic SVG font <code>serif</code>. This can be overridden by setting
    * <a rel="attr">fontnames</a> to <span class="val">ps</span> or <span class="val">gd</span>.
    * In the former case, known PostScript font names such as
    * <code>Times-Roman</code> will be used in the output.
    * In the latter case, the fontconfig font conventions
    * are used. Thus, <code>Times-Roman</code> would be treated as
    * <code>Nimbus Roman No9 L</code>. These last two options are useful
    * with SVG viewers that support these richer fontname spaces.
    */
  String fontnames;
  
  /**
    * Directory list used by libgd to search for bitmap fonts if Graphviz
    * was not built with the fontconfig library.
    * If <a rel="attr">fontpath</a> is not set, the environment 
    * variable <code>DOTFONTPATH</code> is checked.
    * If that is not set, <code>GDFONTPATH</code> is checked.
    * If not set, libgd uses its compiled-in font path.
    * Note that fontpath is an attribute of the root graph.
    */
  String fontpath;
  
  /**
    * Font size, in <a rel="note">points</a>, used for text.
    */
  java.lang.Double fontsize;
  
  /**
    * Text label attached to objects.
    * If a node's <a rel="attr">shape</a> is record, then the label can
    * have a <a href="http://www.graphviz.org/doc/info/shapes.html#record">special format</a> 
    * which describes the record layout.
    */
  LabelString label;
  
  /**
    * Justification for cluster labels. If <span class="val">r</span>, the label
    * is right-justified within bounding rectangle; if <span class="val">l</span>, left-justified;
    * else the label is centered.
    * Note that a subgraph inherits attributes from its parent. Thus, if
    * the root graph sets <a rel="attr">labeljust</a> to <span class="val">l</span>, the subgraph inherits
    * this value.
    */
  String labeljust;
  
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
  String labelloc;
  
  /**
    * If true, the graph is rendered in landscape mode. Synonymous with
    * <code><a rel="attr">rotate</a>=90</code> or 
    * <code><a rel="attr">orientation</a>=landscape</code>.
    */
  java.lang.Boolean landscape;
  
  /**
    * Specifies a linearly ordered list of layer names attached to the graph
    * The graph is then output in separate layers. Only those components 
    * belonging to the current output layer appear. For more information,
    * see the page <a href="http://www.graphviz.org/Documentation/html/layers/">How to use drawing layers (overlays)</a>.
    */
  LayerList layers;
  
  /**
    * Specifies the separator characters used to split the 
    * <a rel="attr">layers </a>attribute into a list of layer names.
    */
  String layersep;
  
  /**
    * Specifies the name of the layout algorithm to use, such as <span class="val">dot</span>
    * or <span class="val">neato</span>. Normally, graphs should be kept independent of a type of
    * layout. In some cases, however, it can be convenient to embed the type
    * of layout desired within the graph. For example, a graph containing
    * position information from a layout might want to record what the
    * associated layout algorithm was.
    * This attribute takes precedence over 
    * the <a href="http://www.graphviz.org/doc/info/command.html#minusK">-K flag</a> 
    * or the actual command name used.
    */
  String layout;
  
  /**
    * Specifies strictness of level constraints in neato
    * when <code><a rel="attr">mode</a>=&quot;ipsep&quot; or &quot;hier&quot;</code>.
    * Larger positive values mean stricter constraints, which demand more 
    * separation between levels. On the other hand, negative values will relax 
    * the constraints by allowing some overlap between the levels.
    */
  java.lang.Double levelsgap;
  
  /**
    * Label position, in <a rel="note">points</a>.
    * The position indicates the center of the label.
    */
  Point lp;
  
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
    * Sets the number of iterations used.
    */
  java.lang.Integer maxiter;
  
  /**
    * Multiplicative scale factor used to alter the MinQuit (default = 8)
    * and MaxIter (default = 24) parameters used during crossing
    * minimization. These correspond to the 
    * number of tries without improvement before quitting and the
    * maximum number of iterations in each pass.
    */
  java.lang.Double mclimit;
  
  /**
    * Specifies the minimum separation between all nodes.
    */
  java.lang.Double mindist;
  
  /**
    * Technique for optimizing the layout. If <a rel="attr">mode</a> is <span class="val">major</span>,
    * neato uses stress majorization. If <a rel="attr">mode</a> is <span class="val">KK</span>,
    * neato uses a version of the gradient descent method. The only advantage
    * to the latter technique is that it is sometimes appreciably faster for
    * small (number of nodes &lt; 100) graphs. A significant disadvantage is that
    * it may cycle.
    * There are two new, experimental modes in neato, <span class="val">hier</span>, which adds a top-down
    * directionality similar to the layout used in dot, and <span class="val">ipsep</span>, which 
    * allows the graph to specify minimum vertical and horizontal distances
    * between nodes. (See the <a rel="attr">sep</a> attribute.)
    */
  String mode;
  
  /**
    * This value specifies how the distance matrix is computed for the input
    * graph. The distance matrix specifies the ideal distance between every
    * pair of nodes. neato attemps to find a layout which best achieves
    * these distances. By default, it uses the length of the shortest path,
    * where the length of each edge is given by its <a rel="attr">len</a>
    * attribute. If <a rel="attr">model</a> is <span class="val">circuit</span>, neato uses the
    * circuit resistance 
    * model to compute the distances. This tends to emphasize clusters. If
    * <a rel="attr">model</a> is <span class="val">subset</span>, neato uses the subset model. This sets the
    * edge length to be the number of nodes that are neighbors of exactly one
    * of the end points, and then calculates the shortest paths. This helps
    * to separate nodes with high degree. 
    */
  String model;
  
  /**
    * If Graphviz is built with MOSEK defined, mode=ipsep and mosek=true, 
    * the Mosek software (www.mosek.com) is use to solve the ipsep constraints.
    */
  java.lang.Boolean mosek;
  
  /**
    * Minimum space between two adjacent nodes in the same rank, in inches.
    */
  java.lang.Double nodesep;
  
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
    * If set, normalize coordinates of final
    * layout so that the first point is at the origin, and then rotate the
    * layout so that the first edge is horizontal.
    */
  java.lang.Boolean normalize;
  
  /**
    * Used to set number of iterations in
    * network simplex applications, used in
    * computing node x coordinates.
    * If defined, # iterations =  <a rel="attr">nslimit</a> * # nodes;
    * otherwise,  # iterations = MAXINT.
    */
  java.lang.Double nslimit;
  
  /**
    * Used to set number of iterations in
    * network simplex applications, used for ranking nodes.
    * If defined, # iterations =  <a rel="attr">nslimit1</a> * # nodes;
    * otherwise,  # iterations = MAXINT.
    */
  java.lang.Double nslimit1;
  
  /**
    * If &quot;out&quot; for a graph G, and n is a node in G, then edges n-&gt;* appear
    * left-to-right in the same order in which they are defined.
    * If &quot;in&quot;, the edges *-&gt;n appear
    * left-to-right in the same order in which they are defined for all
    * nodes n.
    */
  String ordering;
  
  /**
    * Specify order in which nodes and edges are drawn.
    */
  OutputMode outputorder;
  
  /**
    * Determines if and how node overlaps should be removed. Nodes are first
    * enlarged using the <a rel="attr">sep</a> attribute. 
    * If <span class="val">true</span>, overlaps are retained.
    * If the value is <span class="val">scale</span>, overlaps are removed by uniformly scaling in x and y.
    * If the value converts to <span class="val">false</span>, node overlaps are removed by a 
    * Voronoi-based technique. 
    * If the value is <span class="val">scalexy</span>, x and y are separately
    * scaled to remove overlaps. 
    * If the value is <span class="val">orthoxy</span> or <span class="val">orthoyx</span>, overlaps
    * are moved by optimizing two constraint problems, one for the x axis and
    * one for the y. The suffix indicates which axis is processed first.
    * If the value is <span class="val">ortho</span>, the technique is similar to <span class="val">orthoxy</span> except a
    * heuristic is used to reduce the bias between the two passes.
    * If the value is <span class="val">ortho_yx</span>, the technique is the same as <span class="val">ortho</span>, except
    * the roles of x and y are reversed.
    * The values <span class="val">portho</span>, <span class="val">porthoxy</span>, <span class="val">porthoxy</span>, and <span class="val">portho_yx</span> are similar
    * to the previous four, except only pseudo-orthogonal ordering is
    * enforced.
    * If the value is <span class="val">compress</span>, the layout will be scaled down as much as
    * possible without introducing any overlaps, obviously assuming there are
    * none to begin with.
    * If the value is <span class="val">ipsep</span>, and the layout is done by neato with 
    * <a rel="attr">mode</a>=&quot;ipsep&quot;, the overlap removal constraints are
    * incorporated into the layout algorithm itself.
    * N.B. At present, this only supports one level of clustering.
    * If the value is <span class="val">vpsc</span>, overlap removal is similarly to <span class="val">ortho</span>, except
    * quadratic optimization is used to minimize node displacement.
    * N.B. At present, this mode only works when <a rel="attr">mode</a>=&quot;ipsep&quot;.
    * Except for fdp, the layouts assume <code>overlap=&quot;true&quot;</code> as the default. 
    * Fdp first uses a number of passes using built-in, force-directed technique
    * to remove overlaps. Thus, fdp accepts <a rel="attr">overlap</a> with an integer
    * prefix followed by a colon, specifying the number of tries. If there is
    * no prefix, no initial tries will be performed. If there is nothing following
    * a colon, none of the above methods will be attempted. By default, fdp
    * uses <code>overlap=&quot;9:portho&quot;</code>. Note that <code>overlap=&quot;true&quot;</code>,
    * <code>overlap=&quot;0:true&quot;</code> and <code>overlap=&quot;0:&quot;</code> all turn off all overlap
    * removal.
    * Except for the Voronoi method, all of these transforms preserve the
    * orthogonal ordering of the original layout. That is, if the x coordinates
    * of two nodes are originally the same, they will remain the same, and if
    * the x coordinate of one node is originally less than the x coordinate of
    * another, this relation will still hold in the transformed layout. The
    * similar properties hold for the y coordinates.
    * This is not quite true for the &quot;porth*&quot; cases. For these, orthogonal
    * ordering is only preserved among nodes related by an edge.
    * <b>NOTE</b>The methods <span class="val">orthoxy</span> and <span class="val">orthoyx</span> are still evolving. The semantics of these may change, or these methods may disappear altogether.
    */
  String overlap;
  
  /**
    * This is true if the value of pack is <span class="val">true</span> (case-insensitive) or a
    * non-negative integer. If true, each connected component of the graph is 
    * laid out separately, and then the graphs are packed tightly. 
    * If pack has an integral value, this is used as the size,
    * in <a href="#points">points</a>, of
    * a margin around each part; otherwise, a default margin of 8 is used.
    * If pack is interpreted as false, the entire graph is laid out together.
    * The granularity and method of packing is influenced by the
    * <a rel="attr">packmode</a> attribute.
    * For layouts which always do packing, such a twopi, the <a rel="attr">pack</a>
    * attribute is just used to set the margin.
    */
  String pack;
  
  /**
    * This indicates the granularity and method used for packing
    * (cf. <a rel="type">packMode</a>). Note that defining
    * <a rel="attr">packmode</a> will automatically turn on packing as though one had
    * set <code>pack=true</code>.
    */
  PackMode packmode;
  
  /**
    * The pad attribute specifies how much, in inches, to extend the 
    * drawing area around the minimal area needed to draw the graph.
    * If the pad is a single double, both the x and y pad values are set 
    * equal to the given value. This area is part of the
    * drawing and will be filled with the background color, if appropriate. 
    * Normally, a small pad is used for aesthetic reasons, especially when
    * a background color is used, to avoid having nodes and edges abutting
    * the boundary of the drawn region.
    */
  PointF pad;
  
  /**
    * Width and height of output pages, in inches. If this is set and is
    * smaller than the size of the layout, a rectangular array of pages of
    * the specified page size is overlaid on the layout, with origins
    * aligned in the lower-left corner, thereby partitioning the layout
    * into pages. The pages are then produced one at a time, in
    * <a rel="attr">pagedir</a> order.
    * At present, this only works for PostScript output. For other types of
    * output, one should use another tool to split the output into multiple
    * output files. Or use the <a rel="attr">viewport</a> to generate
    * multiple files.
    */
  PointF page;
  
  /**
    * If the <a rel="attr">page</a> attribute is set and applicable,
    * this attribute specifies the order in which the pages are emitted.
    * This is limited to one of the 8 row or column major orders.
    */
  PageDir pagedir;
  
  /**
    * If <a rel="attr">quantum</a> &gt; 0.0, node label dimensions
    * will be rounded to integral multiples of the quantum.
    */
  java.lang.Double quantum;
  
  /**
    * Sets direction of graph layout. For example, if <a rel="attr">rankdir</a>=&quot;LR&quot;, 
    * and barring cycles, an edge <code>T -&gt; H;</code> will go
    * from left to right. By default, graphs are laid out from top to bottom.
    */
  RankDir rankdir;
  
  /**
    * In dot, this gives the desired rank separation, in inches. This is
    * the minimum vertical distance between the bottom of the nodes in one
    * rank and the tops of nodes in the next. If the value
    * contains &quot;equally&quot;, the centers of all ranks are spaced equally apart.
    * Note that both
    * settings are possible, e.g., ranksep = &quot;1.2 equally&quot;.
    * In twopi, specifies radial separation of concentric circles.
    */
  java.lang.Double ranksep;
  
  /**
    * Sets the aspect ratio (drawing height/drawing width) for the drawing. 
    * Note that this is adjusted before
    * the <a rel="attr">size</a> attribute constraints are enforced.
    * If <a rel="attr">ratio</a> is numeric, it is taken as the desired aspect ratio.
    * Then, if the actual aspect ratio is less than the desired ratio, 
    * the drawing height is scaled up to achieve the
    * desired ratio; if the actual ratio is greater than that desired ratio, 
    * the drawing width is scaled up.
    * If <a rel="attr">ratio</a> = <span class="val">fill</span> and the <a rel="attr">size</a>
    * attribute is set, node positions are scaled, separately in both x
    * and y, so that the final drawing exactly fills the specified size.
    * If <a rel="attr">ratio</a> = <span class="val">compress</span> and the <a rel="attr">size</a>
    * attribute is set, dot attempts to compress the initial layout to fit 
    * in the given size. This achieves a tighter packing of nodes but 
    * reduces the balance and symmetry. This feature only works in dot.
    * If <a rel="attr">ratio</a> = <span class="val">expand</span>, the <a rel="attr">size</a>
    * attribute is set, and both the width and the height of the graph are
    * less than the value in  <a rel="attr">size</a>, node positions are scaled 
    * uniformly until at least
    * one dimension fits <a rel="attr">size</a> exactly.
    * Note that this is distinct from using <a rel="attr">size</a> as the
    * desired size, as here the drawing is expanded before edges are generated and
    * all node and text sizes remain unchanged.
    * If <a rel="attr">ratio</a> = <span class="val">auto</span>, the <a rel="attr">page</a>
    * attribute is set and the graph cannot be drawn on a single page,
    * then <a rel="attr">size</a> is set to an ``ideal'' value.
    * In particular, the size in a given dimension will be the smallest integral
    * multiple of the page size in that dimension which is at least half the
    * current size. The two dimensions are then scaled independently to the
    * new size. This feature only works in dot.
    */
  String ratio;
  
  /**
    * If true and there are multiple clusters, run cross
    * minimization a second time.
    */
  java.lang.Boolean remincross;
  
  /**
    * This is a synonym for the <a rel="attr">dpi</a> attribute.
    */
  java.lang.Double resolution;
  
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
    * If 90, set drawing orientation to landscape.
    */
  java.lang.Integer rotate;
  
  /**
    * During network simplex, maximum number of edges with negative cut values
    * to search when looking for one with minimum cut value.
    */
  java.lang.Integer searchsize;
  
  /**
    * Fraction to increase polygons (multiply
    * coordinates by 1 + sep) for purposes of determining overlap. Guarantees
    * a minimal non-zero distance between nodes.
    * If unset but <a rel="attr">esep</a> is defined, <a rel="attr">sep</a> will be
    * set to <code>esep/0.8</code>. If <a rel="attr">esep</a> is unset, the default value
    * is used. 
    * When <a rel="attr">overlap</a>=&quot;ipsep&quot; or &quot;vpsc&quot;,
    * <a rel="attr">sep</a> gives a minimum distance, in inches, to be left between nodes.
    * In this case, if <a rel="attr">sep</a> is a pointf, the x and y separations can be
    * specified separately.
    */
  PointF sep;
  
  /**
    * Print guide boxes in PostScript at the beginning of
    * routesplines if 1, or at the end if 2. (Debugging)
    */
  java.lang.Integer showboxes;
  
  /**
    * Maximum width and height of drawing, in inches.
    * If defined and the drawing is too large, the drawing is uniformly 
    * scaled down so that it fits within the given size. 
    * If <a rel="attr">size</a> ends in an exclamation point (<tt>!</tt>), 
    * then it is taken to be
    * the desired size. In this case, if both dimensions of the drawing are
    * less than <a rel="attr">size</a>, the drawing is scaled up uniformly until at
    * least one dimension equals its dimension in <a rel="attr">size</a>.
    * Note that there is some interaction between the <a rel="attr">size</a> and
    * <a rel="attr">ratio</a> attributes.
    */
  PointF size;
  
  /**
    * Controls how, and if, edges are represented. If true, edges are drawn as
    * splines routed around nodes; if false, edges are drawn as line segments.
    * If set to &quot;&quot;, no edges are drawn at all.
    * (1 March 2007) The values <span class="val">line</span> and <span class="val">spline</span> can be
    * used as synonyms for <span class="val">false</span> and <span class="val">true</span>, respectively.
    * In addition, the value <span class="val">polyline</span> specifies that edges should be
    * drawn as polylines.
    * By default, the attribute is unset. How this is interpreted depends on
    * the layout. For dot, the default is to draw edges as splines. For all
    * other layouts, the default is to draw edges as line segments. Note that
    * for these latter layouts, if <code>splines=&quot;true&quot;</code>, this
    * requires non-overlapping nodes (cf. <a rel="attr">overlap</a>).
    * If fdp is used for layout and <tt>splines=&quot;compound&quot;</tt>, then the edges are
    * drawn to avoid clusters as well as nodes.
    */
  String splines;
  
  /**
    * Parameter used to determine the initial layout of nodes. If unset, the
    * nodes are randomly placed in a unit square with
    * the same seed is always used for the random number generator, so the
    * initial placement is repeatable.
    */
  StartType start;
  
  /**
    * A URL or pathname specifying an XML style sheet, used in SVG output.
    */
  String stylesheet;
  
  /**
    * If the object has a URL, this attribute determines which window 
    * of the browser is used for the URL.
    * See <a href="http://www.w3.org/TR/html401/present/frames.html#adef-target">W3C documentation</a>.
    */
  String target;
  
  /**
    * If set explicitly to true or false, the value determines whether or not
    * internal bitmap rendering relies on a truecolor color model or uses
    * a color palette.
    * If the attribute is unset, truecolor is not used 
    * unless there is a <a rel="attr">shapefile</a> property
    * for some node in the graph. 
    * The output model will use the input model when possible.
    * Use of color palettes results in less memory usage during creation of the
    * bitmaps and smaller output files.
    * Usually, the only time it is necessary to specify the truetype model
    * is if the graph uses more than 256 colors.
    * However, if one uses <a rel="attr">bgcolor</a>=transparent with 
    * a color palette, font
    * antialiasing can show up as a fuzzy white area around characters.
    * Using <a rel="attr">truecolor</a>=true avoids this problem.
    */
  java.lang.Boolean truecolor;
  
  /**
    * Clipping window on final drawing.
    */
  ViewPort viewport;
  
  /**
    * Factor to scale up drawing to allow margin for expansion in
    * Voronoi technique. dim' = (1+2*margin)*dim.
    */
  java.lang.Double voro_margin;

  public Map<String, Object> toAttributeMap() { 
    return Map.ofEntries(
      Map.entry("imagepath", imagepath),
      Map.entry("Damping", Damping),
      Map.entry("K", K),
      Map.entry("URL", URL),
      Map.entry("bb", bb),
      Map.entry("bgcolor", bgcolor),
      Map.entry("center", center),
      Map.entry("charset", charset),
      Map.entry("clusterrank", clusterrank),
      Map.entry("colorscheme", colorscheme),
      Map.entry("comment", comment),
      Map.entry("compound", compound),
      Map.entry("concentrate", concentrate),
      Map.entry("defaultdist", defaultdist),
      Map.entry("dim", dim),
      Map.entry("diredgeconstraints", diredgeconstraints),
      Map.entry("dpi", dpi),
      Map.entry("epsilon", epsilon),
      Map.entry("esep", esep),
      Map.entry("fontcolor", fontcolor),
      Map.entry("fontname", fontname),
      Map.entry("fontnames", fontnames),
      Map.entry("fontpath", fontpath),
      Map.entry("fontsize", fontsize),
      Map.entry("label", label),
      Map.entry("labeljust", labeljust),
      Map.entry("labelloc", labelloc),
      Map.entry("landscape", landscape),
      Map.entry("layers", layers),
      Map.entry("layersep", layersep),
      Map.entry("layout", layout),
      Map.entry("levelsgap", levelsgap),
      Map.entry("lp", lp),
      Map.entry("margin", margin),
      Map.entry("maxiter", maxiter),
      Map.entry("mclimit", mclimit),
      Map.entry("mindist", mindist),
      Map.entry("mode", mode),
      Map.entry("model", model),
      Map.entry("mosek", mosek),
      Map.entry("nodesep", nodesep),
      Map.entry("nojustify", nojustify),
      Map.entry("normalize", normalize),
      Map.entry("nslimit", nslimit),
      Map.entry("nslimit1", nslimit1),
      Map.entry("ordering", ordering),
      Map.entry("outputorder", outputorder),
      Map.entry("overlap", overlap),
      Map.entry("pack", pack),
      Map.entry("packmode", packmode),
      Map.entry("pad", pad),
      Map.entry("page", page),
      Map.entry("pagedir", pagedir),
      Map.entry("quantum", quantum),
      Map.entry("rankdir", rankdir),
      Map.entry("ranksep", ranksep),
      Map.entry("ratio", ratio),
      Map.entry("remincross", remincross),
      Map.entry("resolution", resolution),
      Map.entry("root", root),
      Map.entry("rotate", rotate),
      Map.entry("searchsize", searchsize),
      Map.entry("sep", sep),
      Map.entry("showboxes", showboxes),
      Map.entry("size", size),
      Map.entry("splines", splines),
      Map.entry("start", start),
      Map.entry("stylesheet", stylesheet),
      Map.entry("target", target),
      Map.entry("truecolor", truecolor),
      Map.entry("viewport", viewport),
      Map.entry("voro_margin", voro_margin)).entrySet().stream()
        .filter(entry -> entry.getValue() != null)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }}
