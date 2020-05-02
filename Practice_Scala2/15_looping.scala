import scala.util.control.Breaks._
import java.io._

object main extends App {
    var i = 0
    var foundIt = false

    while (i < args.length && !foundIt) {
        if (!args(i).startsWith("-")) {
            if (args(i).endsWith(".scala")) {
                foundIt = true
            }
        }
        i = i + 1
    }

    // Break
    var in = new BufferedReader(new InputStreamReader(System.in))
    breakable {
        while (true) {
            println("? ")
            if (in.readLine() == "") break
        }
    }
}