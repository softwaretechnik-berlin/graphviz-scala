package berlin.softwaretechnik.graphviz.attributes.html

import berlin.softwaretechnik.graphviz.attributes.Color

case class TableCellAttributes(
  /**
   * specifies horizontal placement. When an object is allocated more space than
   * required, this value determines where the extra space is placed left and
   * right of the object.
   *
   * CENTER aligns the object in the center. (Default)
   * LEFT aligns the object on the left.
   * RIGHT aligns the object on the right.
   *
   * (<TD> only) TEXT aligns lines of text using the full cell width. The
   * alignment of a line is determined by its (possibly implicit) associated
   * <BR> element.
   *
   * The contents of a cell are normally aligned as a block. In particular, lines
   * of text are first aligned as a text block based on the width of the widest
   * line and the corresponding <BR> elements. Then, the entire text block is
   * aligned within a cell. If, however, the cell's ALIGN value is "TEXT", and the
   * cell contains lines of text, then the lines are justified using the entire
   * available width of the cell. If the cell does not contain text, then the
   * contained image or table is centered.
   */
  align: Align = null,


  /**
   * specifies the default alignment of <BR> elements contained in the cell.
   * That is, if a <BR> element has no explicit ALIGN attribute, the attribute
   * value is specified by the value of BALIGN.
   */
  balign: Align = null,

  /**
   * sets the color of the background. This color can be overridden by a BGCOLOR
   * attribute in descendents. The value can be a single color or two colors
   * separated by a colon, the latter indicating a gradient fill.
   *
   * todo: Make gradient case work.
   */
  bgcolor: Color = null,

  /**
   * specifies the width of the border around the object in points. A value of
   * zero indicates no border. The default is 1. The maximum value is 255. If
   * set in a table, and CELLBORDER is not set, this value is also used for all
   * cells in the table. It can be overridden by a BORDER tag in a cell.
   */
  border: java.lang.Integer = null,


  /**
   * specifies the space, in points, between a cell's border and its content.
   * The default is 2. The maximum value is 255.
   */
  cellPadding: java.lang.Integer = null,

  /**
   * specifies the space, in points, between cells in a table and between a cell
   * and the table's border. The default is 2. The maximum value is 127.
   */
  cellSpacing: java.lang.Integer = null,

  /**
   * sets the color of the font within the scope of <FONT>...</FONT>, or the
   * border color of the table or cell within the scope of <TABLE>...</TABLE>,
   * or <TD>...</TD>. This color can be overridden by a COLOR attribute in
   * descendents. By default, the font color is determined by the fontcolor attribute
   * of the corresponding node, edge or graph, and the border color is determined
   * by the color attribute of the corresponding node, edge or graph.
   */
  color: Color = null,

  /**
   * specifies the number of columns spanned by the cell. The default is 1. The
   * maximum value is 65535.
   */
  colspan: java.lang.Integer = null,

  /**
   * specifies whether the values given by the `WIDTH` and `HEIGHT` attributes are enforced.
   *
   * * `FALSE` allows the object to grow so that all its contents will fit. (Default)
   * * `TRUE` fixes the object size to its given `WIDTH` and `HEIGHT`.
   *
   * Both of these attributes must be supplied.
   */
  fixedSize: java.lang.Boolean = null,

  /**
   * gives the angle used in a gradient fill if the BGCOLOR is a color list.
   * For the default linear gradient, this specifies the angle of a line through
   * the center along which the colors transform. Thus, an angle of 0 will cause
   * a left-to-right progression. For radial gradients (see STYLE), the angle
   * specifies the position of the center of the coloring. An angle of 0 places
   * the center at the center of the table or cell; an non-zero angle places the
   * fill center along that angle near the boundary.
   */
  gradientAngle: java.lang.Integer = null,

  /**
   * specifies the mininum height, in points, of the object. The height
   * includes the contents, any spacing and the border. Unless
   * FIXEDSIZE is true, the height will be expanded to allow the
   * contents to fit. The maximum value is 65535. */
  height: java.lang.Integer = null,

  /**
   * attaches a URL to the object. Note that the "value" is treated as an
   * escString similarly to the URL attribute.
   */
  href: String = null,

  /**
   * allows the user to specify a unique ID for a table or cell. See the id
   * attribute for more information. Note that the "value" is treated as an
   * escString similarly to the id attribute
   */
  id: String = null,

  /**
   * attaches a portname to the object. (See portPos.) This can be used to
   * modify the head or tail of an edge, so that the end attaches directly to
   * the object.
   */
  port: String = null,

  /**
   * specifies the number of rows spanned by the cell. The default is 1.
   * The maximum value is 65535.
   */
  rowSpan: java.lang.Integer = null,

  /**
   * specifies which sides of a border in a cell or table should be drawn,
   * if a border is drawn. By default, all sides are drawn. The "value" string
   * can contain any collection of the (case-insensitive) characters
   * 'L', 'T', 'R', or 'B', corresponding to the left, top, right and, bottom
   * sides of the border, respectively. For example, SIDES="LB" would indicate
   * only the left and bottom segments of the border should be drawn.
   */
  sides: String = null,

  /**
   * specifies style characteristics of the table or cell. Style characteristics
   * are given as a comma or space separated list of style attributes. At
   * present, the only legal attributes are "ROUNDED" and "RADIAL" for tables,
   * and "RADIAL" for cells. If "ROUNDED" is specified, the table will have
   * rounded corners. This probably works best if the outmost cells have no
   * borders, or their CELLSPACING is sufficiently large. If it is desirable to
   * have borders around the cells, use HR and VR elements, or the COLUMNS and
   * ROWS attributes of TABLE.
   *
   * The "RADIAL" attribute indicates a radial gradient fill. See the BGCOLOR
   * and GRADIENTANGLE attributes.
   */
  style: String = null,

  /**
   * determines which window of the browser is used for the URL if the object
   * has one. See W3C documentation. Note that the "value" is treated as an
   * escString similarly to the target attribute.
   */
  target: String = null,

  /**
   * sets the tooltip annotation attached to the element. This is used only if
   * the element has a HREF attribute. Note that the "value" is treated as an
   * escString similarly to the tooltip attribute.
   */
  title: String = null,

  /**
   * is an alias for TITLE.
   */
  tooltip: String = null,

  /**
   * specifies vertical placement. When an object is allocated more space than
   * required, this value determines where the extra space is placed above and
   * below the object.
   *
   * MIDDLE aligns the object in the center. (Default)
   * BOTTOM aligns the object on the bottom.
   * TOP aligns the object on the top.
   */
  valign: VAlign = null,

  /**
   * specifies the mininum width, in points, of the object. The width includes
   * the contents, any spacing and the border. Unless FIXEDSIZE is true, the
   * width will be expanded to allow the contents to fit.
   * The maximum value is 65535.
   * */
  width: java.lang.Integer = null,
) {

  def toAttributeMap(): Seq[(String, Any)] =
    productElementNames
      .zip(productIterator).toSeq
      .filter { case (k, v) => v != null }

}

