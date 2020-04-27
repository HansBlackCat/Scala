object classes extends App {
    val DefaultSize: Int = 12
    val DefaultType: String = "thin"

    class Pizza (var csize: Int, var ctype:String) {
        def this(csize: Int) {
            this(csize, DefaultType)
        }

        def this(ctype: String) {
            this(DefaultSize, ctype)
        }

        def this() {
            this(DefaultSize, DefaultType)
        }

        override def toString(): String = s"A $csize inch pizza with a $ctype crust"
    }

    class Socket(var timeout: Int = 2000, var linger: Int = 3000) {
        override def toString(): String = s"timeout: ${timeout}, linger: ${linger}"
    }

    def double(a: Int) = a*2
}