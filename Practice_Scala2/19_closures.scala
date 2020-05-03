
object main extends App {
    def baseEcho(args: String) = {
        for (arg <- args) println(arg)
    }

    // String*: Seq[String]
    // Like kwargs
    def echo(args: String*) = {
        for (arg <- args) println(arg)
    }

    // echo("a","b")
    // echo(Seq("1","2"): _*)

    def speed(distance: Float, time: Float): Float = {
        distance / time
    }
    // speed(time = 32, distance=12)

    def printTime(out: java.io.PrintStream = Console.out) = {
        out.println("time = " + System.currentTimeMillis())
    }

    def printTime2(out: java.io.PrintStream = Console.out, divisor: Int = 1) = {
        out.println("time = " + System.currentTimeMillis()/divisor)
    }

    // Tail Recur
    def boom(x: Int): Int = {
        if (x == 0) throw new Exception("boom!")
        else boom(x-1) + 1
    }
}