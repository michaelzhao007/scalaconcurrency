
import scala.io.Source
import scala.concurrent._
import ExecutionContext.Implicits.global
import org.learningconcurrency._
import scala.util.{Try, Success, Failure}

object FuturesNonFatal extends App {
	val f = Future {throw new InterruptedException}
    val g = Future {throw new IllegalArgumentException}
    f.failed foreach {
    	case t => log(s"error $t")
    }
    g.failed foreach {
    	case t => log(s"error $t")
    }
}