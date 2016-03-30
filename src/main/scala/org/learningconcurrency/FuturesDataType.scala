import scala.io.Source
import scala.concurrent._
import ExecutionContext.Implicits.global
import org.learningconcurrency._

object FuturesDataType extends App {
	val buildFile: Future[String] = Future {
		val f = Source.fromFile("build.sbt")
	    try f.getLines.mkString("\n") finally f.close()
	}
	log(s"started reading the build async")
    log(s"status: ${buildFile.isCompleted}")
    Thread.sleep(250)
    log(s"status: ${buildFile.isCompleted}")
    log(s"value: ${buildFile.value}")
}