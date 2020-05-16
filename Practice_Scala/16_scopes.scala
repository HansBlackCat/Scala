

object main extends App {
    val a = 1
    {
        val a = 2
        println(a)
    }
    println(a)
}