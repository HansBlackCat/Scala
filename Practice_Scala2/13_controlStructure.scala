
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


}
