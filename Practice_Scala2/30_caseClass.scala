import math._

abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

object main {
    val v = Var("2")
    val op = BinOp("+", Number(1), v)
    val v_name = v.name
    val op_copy = op.copy(operator = "-")

    def simplifyTop(expr: Expr): Expr = {
        expr match {
            case UnOp("-", UnOp("-",e))   => e
            case BinOp("+", e, Number(0)) => e 
            case BinOp("*", e, Number(1)) => e
            case _                        => expr
        }
    }

    def binOpFind(expr: Expr) = {
        expr match {
            case BinOp(_,_,_) => println(s"$expr is a binary operation")
            case _            => println("It's something else")
        }
    }

    def describe(x: Any) = {
        val pi = math.Pi
        x match {
            case 5 => "five"
            case true => "truth"
            case "hello" => "hi!"
            // case Nil => "empty list"
            case E => "It's exp"
            case `pi` => "variable pi"
            case List(0,_,_) => "List with first zero and 3 elements"
            case List(1,_*) => "List with first one"
            case List(_*) => "Universal list"
            case _ => "something else"
        }
    }

    def generalSize(x: Any) = {
        x match {
            case s: String => s.length
            case m: Map[_,_] => m.size
            case _ => -1
        }
    }

    // type erasure run
    def isIntToIntMap(x: Any) = {
        x match {
            case m: Map[Int, Int] => true
            case _                => false
        }
    }
    // isIntToMap(Map(1->1))
    // isIntToMap(Map(2->'c'))
}