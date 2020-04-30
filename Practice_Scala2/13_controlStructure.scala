
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

    
}
