/*
object Hello {
  def main(args: Array[String]) = {
    println("Hello, world")
  }
}
*/

/*
object Hello2 extends App {
  println("Hello, world")
}
*/

object HelloYou extends App {
  if (args.size == 0) {
    println("Hello, you")
    println(args.size)
  } else {
    println("Hello, " + args(0))
    println(args.size)
  }
}


