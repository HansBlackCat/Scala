
class Person {
    var name: Option[String] = None
    var age: Option[Int] = None
    override def toString = s"$name, $age"
}

object Person {
    def apply(name: Option[String]): Person = {
        var p = new Person
        p.name = name
        p
    }

    def apply(name: Option[String], age: Option[Int]): Person = {
        var p = new Person
        p.name = name
        p.age = age
        p
    }
}

object fp extends App {

    def toInt(s: String): Option[Int] = {
        try {
            Some(Integer.parseInt(s.trim))
        } catch {
            case e: Exception => None
        }
    }

    // example
    

}

