

object main extends App {
    val greetingString = new Array[String](3)

    greetingString(0) = "Hello"
    greetingString(1) = ", "
    greetingString.update(2, "world!\n")

    for (i <- 0 to 2 /* 0.to(2) */)
        print(greetingString(i))
        // Same as
        // print(greetingString.apply(i))

    val numName1 = Array("zero", "one", "two")
    val numName2 = Array.apply("zero", "one", "two")
}

