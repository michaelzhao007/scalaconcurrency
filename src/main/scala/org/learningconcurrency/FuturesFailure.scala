import scala.io.Source
import scala.concurrent._
import ExecutionContext.Implicits.global
import org.learningconcurrency._
import scala.util.{Try, Success, Failure}

object FuturesFailure extends App {
	val urlSpec: Future[String] = Future {
	    val invalidUrl = "http://www.w3.org/nonexist"
	    Source.fromURL(invalidUrl).mkString
	}
     
	Thread.sleep(1000)
}