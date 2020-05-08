
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

    def simplifyTop(expr: Expr): Expr =
        expr match {
            case UnOp("-", UnOp("-",e))   => e
            case Binop("+", e, Number(0)) => e 
            case BinOp("*", e, Number(1)) => e
            case _                        => expr
        }
    
}