
// Functional Queue
// Hide class constructor
class Queue[T] private (
    private val leading: List[T],
    private val trailing: List[T]
) {
    // auxiliary constructor
    def this(elems: T*) = this(elems.toList, Nil)

    private def mirror = {
        if (leading.isEmpty) {
            new Queue(trailing.reverse, Nil)
        } else {
            this
        }
    }
    def head = mirror.leading.head
    def tail = {
        val q = mirror
        new Queue(q.leading.tail, q.trailing)
    }
    def enqueue(x: T) = {
        new Queue(leading, x :: trailing)
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
