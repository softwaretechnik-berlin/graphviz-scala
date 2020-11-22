import $ivy.`org.jsoup:jsoup:1.12.1`
import org.jsoup._
import scala.jdk.CollectionConverters._

val doc = Jsoup.connect("https://graphviz.org/doc/info/attrs.html").get()
