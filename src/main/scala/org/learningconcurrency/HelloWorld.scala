package org.learningconcurreny;


object HelloWorld extends App {
	def square(x: Int): Int = x * x
	def runTwice(body: =>Unit) = {
		body
		body
	}
	val negatives = for (i <- 0 until 10) yield -i
	println(negatives)
	runTwice {
		println("this is fun!")
	}

	val pairs = for (x <- 0 until 4; y <- 0 until 4) yield (x, y)
	
    val successors = Map(1 -> 2, 2 -> 3, 3 -> 4)
    successors.get(5) match {
    	case Some(n) => println(s"Successor is : $n")
    	case None => println("cannot find successor")
    }
	val s = square(5)
	println(s"Result: $s")
	println("hello, world!")
	val printy = new Printer("Hi")
	printy.printMessage()
	printy.printNumber(5)
    val twice: Int => Int = (x: Int) => x * 2
    printy.printNumber(twice(30))
}

