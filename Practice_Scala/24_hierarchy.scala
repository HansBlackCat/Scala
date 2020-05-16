
object testInt extends Int {
    def temp = println("hi")
}

object mainApp extends App {
    val x = new String("abc")
    val y = new String("abc")

    val b1 = x == y // true
    val b2 = x eq y // false

    // Base class
    def divide(x: Int, y: Int): Int = {
        if (y != 0) x/y // Type: Int
        else sys.error("can't divide by zero") // Type: Nothing, It's Ok cause Nothing is subtype of all class
    }

    // Own value class
    class Dollar(val amount: Int) extends AnyVal {
        override def toString(): String = "$" + amount
    }

    // test
    val money = new Dollar(1000)
    val testMoney = money.amount

    // Use of value type
    // HTML
    
    class Anchor(val value: String) extends AnyVal
    class Style (val value: String) extends AnyVal
    class Text  (val value: String) extends AnyVal
    class HTML  (val value: String) extends AnyVal

    def title(text: Text, anchor: Anchor, style: Style): HTML = {
        new HTML(
            s"<a id='${anchor.value}'>" +
            s"<h1 class='${style.value}'>" +
            text.value +
            "</h1></a>"
        )
    }

}
