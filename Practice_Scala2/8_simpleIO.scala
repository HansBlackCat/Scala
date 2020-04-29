import scala.io.Source

object main extends App {
    def widthOfLength(s:String) = s.length.toString.length    

    if (args.length > 0) {
        val lines = Source.fromFile(args(0)).getLines.toList
        val longestLine = lines.reduceLeft(
            (a,b) => if (a.length > b.length) a else b
        )
        val maxWidth = widthOfLength(longestLine)

        for (line <- lines) {
            val numSpace = maxWidth - widthOfLength(line)
            val padding = " "*numSpace
            println(padding + line.length + " | " + line)
        }
    } else {
        Console.err.println("Please enter Filename")
    }
}