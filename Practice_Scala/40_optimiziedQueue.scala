
// Non-Functional Queue
// Hide class constructor
class Queue[+T] private (
    private[this] var leading: List[T],
    private[this] var trailing: List[T]
) {
    // auxiliary constructor
    def this(elems: T*) = this(elems.toList, Nil)

    private def mirror() = {
        if (leading.isEmpty) {
            while (!trailing.isEmpty) {
                leading = trailing.head :: leading
                trailing = trailing.tail
            }
        }
    }

    def head: T = {
        mirror()
        leading.head
    }
    def tail: Queue[T] = {
        mirror()
        new Queue[T](leading.tail, trailing)
    }
    // T as a lower bound of U
    // U is required to be a supertype of T
    def enqueue[U >: T](x: U) = {
        new Queue[U](leading, x :: trailing)
    }

    override def toString(): String = {
        val tmp = leading ::: trailing.reverse 
        "Queue" + tmp.toString.substring(4)
    }
}

object Queue {
    def apply[T](xs: T*) = new Queue[T](xs.toList, Nil)
}


class StrangeIntQueue extends Queue[Int] {
    override def enqueue(x: Int) = {
        println(math.sqrt(x))
        super.enqueue(x)
    }
}
