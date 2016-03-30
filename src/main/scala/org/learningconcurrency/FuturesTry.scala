import scala.io.Source
import scala.concurrent._
import ExecutionContext.Implicits.global
import org.learningconcurrency._
import scala.util.{Try, Success, Failure}

object FuturesTry extends App {
	val threadName: Try[String] = 
	Try(Thread.currentThread.getName)
	
	val someText: Try[String] = Try("try obj sync")

	val message: Try[String] = for {
		tn <- threadName
		st <- someText
	} yield s"message $st created on $tn"

    def handleMessage(t :Try[String]) = t match {
        case Success(msg) => log(msg)
        case Failure(error) => log(s"error $error")
    }
    
	handleMessage(message)
}