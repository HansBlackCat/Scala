import scala.collection.mutable

class CheckSummAccumulator {
    var public_sum = 0
    private var private_sum = 0

    def add(b: Byte): Unit = {
        private_sum += b
    }
    def checksum(): Int = {
        return ~(private_sum & 0xFF) +1
    }
}

object CheckSummAccumulator {
    private val cache = mutable.Map.empty[String, Int]

    def calculate(s: String): Int = {
        if (cache.contains(s)) cache(s)
        else {
            val acc = new CheckSummAccumulator
            for (c <- s) {
                acc.add(c.toByte)
            }
            val cs = acc.checksum()
            cache += (s -> cs)
            cs
        }
    }
}

/*
object main extends App {
    val acc = new CheckSummAccumulator
    acc.public_sum = 10

    // Compile Error
    // acc = new CheckSummAccumulator
    // acc.private_sum = 12


}
*/