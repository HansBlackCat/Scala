
// add Subclasses only in this file
sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

object main {
    def describe(e: Expr): String = {
        e match {
            case Number(_) => "a num"
            case Var(_) => "a var"
            case _ => throw new RuntimeException
        }
    }

    def decsribeLite(e: Expr): String = {
        (e: @unchecked) match {
            case Number(_) => "a num"
            case Var(_) => "a var"
        }
    }

    val capitals = 
        Map(
            "France" -> "Paris",
            "Japan" -> "Tokyo"
        )
    val cap_get = capitals get "France"
 
    def show(x: Option[String]) = {
        x match {
            case Some(s) => s
            case None => "?"
        }
    }

    val myTuple = (123, "abc")
    val (number, string) = myTuple

    // warning: match may not be exhaustive.
    val second1: List[Int] => Int = {
        case x :: y :: _ => y
    }

    val second2: PartialFunction[List[Int], Int] = {
        case x :: y :: _ => y
    }
    // second2.isDefinedAt(Nil) // false

    // Partial Function
    val divi = new PartialFunction[Int, Int] {
        def apply(v1: Int): Int = 42 / v1
        def isDefinedAt(x: Int): Boolean = x != 0
    }

    
}