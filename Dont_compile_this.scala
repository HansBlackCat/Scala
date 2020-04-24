
object Dont_compile_this {
  val x: Int = 1
  val s: String = "a string"
  val b: Boolean = true
  val byte: Byte = 1
  val l: Long = 100
  // val p: Person = new Person("Regina")

  if (x == 1) {
      return 3
  } else if (x == 2) {
      return 4.5
  } else {
      return 4
  }

  val y = if (x>10) 10 else 30
  val result = x match {
      case 1 => "one"
      case 2 => "two"
      case 3 => "three"
      case _ => "else"
  }

  val nums = List.range(0,10)
  val nums = (1 to 10 by 2).toList
  val letters = ('a' to 'f').toList
  val letters = ('a' to 'f' by 2).toList

  val names = List("joel", "ed", "chris", "maurice")
  // names.foreach(println)

  val firstName = "John"
  val mi = 'V'
  val lastName = "Nohman"

  val name1 = firstName + " " + mi + " " + lastName
  val name2 = 
}