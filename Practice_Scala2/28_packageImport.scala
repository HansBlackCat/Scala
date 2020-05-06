
package bobsdelights
abstract class Fruit(
    val name: String,
    val color: String
)

object Fruits {
    object Apple extends Fruit("apple", "red")
    object Orange extends Fruit("orange", "orange")
    object Pear extends Fruit("pear", "yellowish")
    val menu = List(Apple, Orange, Pear)
}

object mainApp extends App {
    def showFruit(fruit: Fruit) = {
        import fruit._
        println(name + "s are " + color)
    }
}

class AstarB {
    val pat = java.util.regex.Pattern.compile("a*b")
}


