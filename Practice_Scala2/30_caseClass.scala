
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
}