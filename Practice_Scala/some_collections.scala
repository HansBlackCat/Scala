import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Map

object some_collections extends App {
    // ArrayBuffer -- mutable
    val ints = ArrayBuffer[Int]()
    val names = ArrayBuffer[String]()

    ints += 30
    ints += 10
    // ints.type = ArrayBuffer(30, 10)

    val nums = ArrayBuffer(1, 2, 3)
    nums += 5 += 6
    nums ++= List(7,8,9)

    nums -= 9
    nums --= Array(6,7,8)

    // List -- immutable
    val ints = List(1,2,3)
    val names = List("Joel", "Chris", "Ed")
    val list = 1::2::3::Nil
    
    val a = List.range(1,4)
    // prepend
    val b = 0 +: a
    val b_prime = List(-1,0) ++: a

    for (name<-names) println(name)

    // Vector -- immutable

    val vecs = Vector(1,2,3,4,5)
    val strings = Vector("one", "two")

    val b = a :+ 4
    val b2 = a ++ Vector(6,7)


    // Mutable Map
    val states = collection.mutable.Map("AK" -> "Alaska")
    states += ("AL" -> "Alabama")
    states ++= Map("CA" -> "California")

    for ((k,v) <- states) println(s"key: ${k}, value: ${v}")
    states.foreach {
        case (short, long) => println(s"key: ${short}, value: ${long}")
    }

    // Set

    val sets = scala.collection.mutable.Set[Int]()
    sets += 1
    sets += 2 += 3
    sets ++= Vector(4,5)

    sets.add(6) // Added and print `true`
    sets.add(5) // Already have, print `false

    // Some +

    val ints = List(1,2,3)
    val doubledInts = ints.map(_ * 2)
    val doubledInts = ints.map(i => i * 2)
    val doubledInts = ints.map((i:Int) => i * 2)

    val x = ints.filter(_ > 2)

    val nums = (1 to 10).toList
}