import scala.io.Source

object LongLines {
    /*
    private def processLine(filename: String, width: Int, line: String) = {
        if (line.length > width) {
            println(filename + ": " + line.trim)
        }
    }

    def processFile(filename: String, width: Int) = {
        val source = Source.fromFile(filename)
        for (line <- source.getLines) {
            processLine(filename, width, line)
        }
    }
    */
    
    // Same as

    def processFile(filename: String, width: Int) = {
        def processLine(filename: String, width: Int, line: String) = {
            if (line.length > width) {
                println(filename + ": " + line.trim)
            }
        }
        val source = Source.fromFile(filename)
        for (line <- source.getLines) {
            processLine(filename, width, line)
        }
    }
    
}

object FindLongLines {
    def main(args: Array[String]) = {
        val width = args(0).toInt
        for (arg <- args.drop(1)) {
            LongLines.processFile(arg, width)
        }
    }
}