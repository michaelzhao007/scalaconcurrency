package org.learningconcurreny;

class Printer(val greeting: String) {
	def printMessage(): Unit = println(greeting + "!")
	def printNumber(x: Int): Unit = println("Number: " + x)
}