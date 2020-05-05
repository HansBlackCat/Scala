
// Have default superclass of `AnyRef`
trait Philosophical {
    def philosophize() = {
        println("I consume memory, therefore I am!")
    }
}

// Mixing in a trait
class Frog extends Philosophical {
    override def toString(): String = "green"
}

class Water {
    val b = 10
}
class Skinny {
    val a = 12
}
// error: class Water needs to be a trait to be mixed in
class Lizard extends Skinny with Water


class Animal
trait HasLegs
class FrogV2 extends Animal with Philosophical with HasLegs {
    override def toString(): String = "green"
    override def philosophize(): Unit = println(s"It's ain't easy being ${toString}!")
}

class Superman {
    def mountainKing = "Storm bolt"
}
class Subman extends Superman {
    override def mountainKing: String = "Thunder clap"
    def oriKing = super.mountainKing
}

trait SuperTest1 { override def toString(): String = "ME" }
trait SuperTest2 { override def toString(): String = "YOU" }
class SubTest extends SuperTest2 with SuperTest1 {
    override def toString(): String = super.toString
}