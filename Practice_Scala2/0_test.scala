
class test {
    val k = 0
    class B {
        def temp() = println("Inner Inner")
        
    }
    val bcall = new B
    bcall.temp()

}

