
object main extends App {
    val filename = 
        if (!args.isEmpty) args(0)
        else "default"
    
    println(if (!args.isEmpty) args(0) else "default")

    def gcdLoop(x: Long, y: Long): Long = {
        var a = x
        var b = y
        while (a != 0) {
            val temp = a
            a = b % a
            b = temp
        }
        return b
    }

    def gcd(x: Long, y: Long): Long = 
        if (y == 0) x else gcd(y, x%y)

    def currentFilePrint() = {
        val filesHere = (new java.io.File(".")).listFiles
        for (file <- filesHere) println(file)
    }

    def ranger() = {
        for (i <- 1 to 4) println("Iteration " + i)
    }

    val filesHere = (new java.io.File(".")).listFiles

    def currentFilePrintV2() = {
        val filesHere = (new java.io.File(".")).listFiles
        for (
            file <- filesHere 
            if file.isFile
            if file.getName.endsWith(".scala")
        ) {
            println(file)
        }
    }

    def fileLines(file: java.io.File) =
        scala.io.Source.fromFile(file).getLines.toArray

    def grep(pattern: String) = {
        val filesHere = (new java.io.File(".")).listFiles
        for { 
            file <- filesHere
            if file.getName.endsWith(".scala")
            line <- fileLines(file)
            trimmed = line.trim
            if trimmed.matches(pattern)
         } println(s"$file: $trimmed")
    }

    // for {i <- List(1,2,3)} println("i")

    def scalaFiles = {
        val filesHere = (new java.io.File(".")).listFiles
        for {
            file <- filesHere
            if file.getName.endsWith(".scala")
        } yield file
    }    

    def forLineLengths = {
        val filesHere = (new java.io.File(".")).listFiles
        for {
            file <- filesHere
            if file.getName.endsWith(".scala")
            line <- fileLines(file)
            trimmed = line.trim
            if trimmed.matches(".*for.*")
        } yield trimmed.length
    }

    // throw new IllegalAccessException
    val half = {
        if (n % 2 == 0) n/2
        else throw new RuntimeException("n must be even")
    }
}
