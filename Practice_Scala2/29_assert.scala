
object main {
    def abs(a: Int, b: Int) = {
        if (a>b) {
            1
        } else {
            0
        } ensuring (a<b) // if abs(2,2), AssertionError
    }

    try {
        abs(2,2)
    } catch {
        case e: AssertionError => println("1")
    } finally {
        println("2")
    }
}