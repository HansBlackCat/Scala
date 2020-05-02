import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

import java.net.URI
import java.net.MalformedURLException

object main extends App {
    try {
        val f = new FileReader("input.txt")
        // use file with handler
    } catch {
        case ex: FileNotFoundException => println("A")
        case ex: IOException => println("B")
    }

    def urlFor(path: String) = {
        try {
            new URL(path)
        } catch {
            case e: MalformedURLException =>
                new URL("https://www.scala-lang.org")
        }
    }
}