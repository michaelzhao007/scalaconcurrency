import scala.concurrent._
import ExecutionContext.Implicits.global
import org.learningconcurrency._

object FuturesCreate extends App {
	Future { log("the future is here")}
	log("the future is coming")
	Thread.sleep(1000)
}