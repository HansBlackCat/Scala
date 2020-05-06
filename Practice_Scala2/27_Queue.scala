import scala.collection.mutable.ArrayBuffer

abstract class IntQueue {
    def get(): Int
    def put(x: Int): Unit
}

trait Doubling extends IntQueue {
    // Due `super` calls are dynamically bound in trait
    abstract override def put(x: Int) = super.put(2*x)
}

trait Incrementing extends IntQueue {
    abstract override def put(x: Int) = super.put(x+1)
}

trait Filtering extends IntQueue {
    abstract override def put(x: Int) = {
        if (x >= 0) super.put(x)
    }
}

// error: method put in class IntQueue is accessed from super. 
// It may not be abstract unless it is overridden by a member declared `abstract` and `override`
/*
trait NoAbsIncre extends IntQueue {
    def put(x: Int) = super.put(x+1)
}
*/

class BasicIntQueue extends IntQueue {
    private val buf = new ArrayBuffer[Int]
    def get() = buf.remove(0)
    def put(x: Int): Unit = { buf += x }
}

case class testCase()

