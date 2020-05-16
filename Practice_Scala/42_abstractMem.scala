import java.awt.GradientPaint

// abstract type(T), method(transfrom), val(initial), var(current)
trait Abstract {
    type T
    def transfrom(x: T): T
    val initial: T
    var current: T
}

class Concrete extends Abstract {
    type T = String
    def transfrom(x: T) = x + x
    val initial = "hi"
    var current = initial
}

abstract class Fruit {
    val v: String
    def m: String
}

abstract class Apple extends Fruit {
    val v: String
    val m: String
}

abstract class BadApple extends Fruit {
    // error: stable, immutable value required to override
    // def v: String
    def m: String
}

trait AbstractTime {
    var hour: Int // var declaration in field come equipped with getter & setter
    // ==
    // def hour: Int
    // def hour_= (x: Int): Unit
    var minute: Int
}

trait RationalTrait {
    val numerArg: Int
    val denomArg: Int
}

object Demo {
    val x = { println("init x"); "done" }
}

object LazyDemo {
    lazy val x = { println("init x"); "done" }
}

trait RationalTraits {
    val numerArg: Int
    val denomArg: Int
    require(denomArg != 0)
    private val g = gcd(numerArg, denomArg)
    val numer = numerArg / g
    val denom = denomArg / g
    private def gcd(n: Int, d: Int): Int = {
        if (d == 0) n else gcd(d, n%d)
    }
    override def toString(): String = s"${numer}/${denom}"
}

// val x = 2
// new RationalTraits {val numerArg = 1*x; val denomArg = 2*x}
// Exception: java.lang.IllegalArgumentException: requirement failed

trait LazyRationalTraits {
    val numerArg: Int
    val denomArg: Int
    private lazy val g = {
        require(denomArg != 0)
        gcd(numerArg, denomArg)
    }
    lazy val numer = numerArg / g
    lazy val denom = denomArg / g
    private def gcd(n: Int, d: Int): Int = {
        if (d == 0) n else gcd(d, n%d)
    }
    override def toString(): String = s"${numer}/${denom}"
}

// scala> new LazyRationalTraits {val numerArg = 1*x; val denomArg = 2*x}
// val res37: LazyRationalTraits = 1/2

class Food
abstract class Animal {
    def eat(food: Food): Unit
}

class Grass extends Food
class DogFood extends Food
/*
class Cow extends Animal {
    // Won't compile b/c, no override exists
    // Type different from Superclass
    override def eat(food: Grass): Unit = {}
}
*/
class Fish extends Food
object CowEatFish {
    val syd: Animal = new Cow
    // syd.eat(new Fish)
}


abstract class AnimalTyped {
    type SuitableFood <: Food
    def eat(food: SuitableFood): Unit
}
class Cow extends AnimalTyped {
    type SuitableFood = Grass
    override def eat(food: Grass): Unit = {}
}
class Dog extends AnimalTyped {
    type SuitableFood = DogFood
    override def eat(food: DogFood): Unit = {}
}


