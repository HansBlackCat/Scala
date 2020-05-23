object imp {

    implicit def doubleToInt(x: Double) = {
        import scala.math._
        (abs(x) * 2).toInt
    }

    implicit def intToDouble(x: Int) = {
        import scala.math._
        (x * 2 + 1).toDouble
    }


}

// Rational

object Maii {
    case class Rectangle(width: Int, height: Int)

    implicit class RectangleMaker (width: Int) {
        def x (height: Int) = Rectangle(width, height)
    }

    class PreferredPrompt (val preference: String)

    object Greeter {
        def greet(name: String)(implicit prompt: PreferredPrompt) = {
            println("Welcome, " + name + ". The system is ready.")
            println(drink.preference)
            println(prompt.preference)
        }
    }

    object JoesPrefs {
        implicit val prompt = new PreferredPrompt("Yes, master> ")
        implicit val drink = new PreferredPrompt("tea")
    }
 
    def maxListOrdering[T] (elements: List[T])(implicit ordering: Ordering[T]): T = {
        elements match {
            case List() =>
                throw new IllegalArgumentException("empty list!")
            case List(x) => x
            case x :: rest =>
                val maxRest = maxListOrdering(rest)(ordering)
                if (ordering.gt(x, maxRest)) x
                else maxRest
        }
    }

}

