

object main extends App {
    // Not `java.util.List` -> mutable list
    // `scala.List` -> immutable always
    val oneTwoThree1 = List(1,2,3)
    val oneTwoThree2 = scala.List(1,2,3) // immutable
    val another = java.util.List(1,2,3) // mutable

    val fourFive = List(4,5)
    val oneToFive1 = oneTwoThree1 ::: fourFive
    val oneToFive2 = oneTwoThree1 ++ fourFive
    val oneToFive3 = 1 :: 2 :: fourFive
    val oneToFive3_prime = fourFive.::(2).::(1) // right operand

    // ++, +: -> O(n)
    // ::     -> O(1)

    val emptyList = Nil
    val thrill = "Will" :: "fill" :: "until" :: Nil
    val concat = oneTwoThree1 ::: fourFive
    val snd = thrill(2)
    val count = thrill.count(s => s.length == 4) // "Will", "fill" -> 2
    val drop = thrill.drop(2) // List("util")
    val right_drop = thrill.dropRight(2) // List("Will")
    val exists = thrill.exists("until") // true
    val mkstring = thrill.mkString(" ") // "Will fill until"
}