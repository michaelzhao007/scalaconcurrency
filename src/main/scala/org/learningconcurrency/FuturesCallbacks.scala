import scala.io.Source
import scala.concurrent._
import ExecutionContext.Implicits.global
import org.learningconcurrency._

object FuturesCallbacks extends App {
	def getUrlSpec(): Future[List[String]] = 
	Future {
		val url = "https://www.w3.org/Addressing/URL/url-spec.txt"
		val f = Source.fromURL(url)
		try f.getLines.toList finally f.close
	}

	val urlSpec: Future[List[String]] = getUrlSpec()

	def find(lines: List[String], keyword: String) : String = 
	   lines.zipWithIndex collect {
	   	   case (line, n) if line.contains(keyword) => (n, line)
	   } mkString("\n")

	 urlSpec foreach {
	 	case lines => log(find(lines, "telnet"))
	 }
     log("callback registered, do other work")

	 Thread.sleep(3000)
}