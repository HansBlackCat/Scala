
package bobsdelights
abstract class Fruit(
    val name: String,
    val color: String
)
package object bobsdelights {
    def showFruit(fruit: Fruit) = {
        import fruit._
        println(name + "s are " + color)
    }    
}

object Fruits {
    object Apple extends Fruit("apple", "red")
    object Orange extends Fruit("orange", "orange")
    object Pear extends Fruit("pear", "yellowish")
    val menu = List(Apple, Orange, Pear)
}

class FruitPrint(
    override val name: String,
    override val color: String
) extends Fruit

class AstarB {
    val pat = java.util.regex.Pattern.compile("a*b")
}


package  bobsrockects {
    package navigation {
        private[bobsrockects] class Navigator {
            protected[navigation] def useStarChart() = {}
            class LegOfJourney {
                private[Navigator] val distance = 100
            }
            private[this] var speed = 200
        }
        private class PureNavi {}
    }
    class BoB {
        import navigation._
        def boB = new Navigator
        // def boC = new PureNavi
    }
    package launch {
        import navigation._
        object Vehicle {
            private[launch] val guide = new Navigator
        }
    }
}

class Rocket {
    import Rocket.fuel
    private def canGoHomeAgain = fuel > 20
}
object  Rocket {
    private def fuel = 10
    def chooseStrategy(rocket: Rocket) = {
        if (rocket.canGoHomeAgain) goHome()
        else pickAStar()
    }
    def goHome() = {}
    def pickAStar() = {}
}
