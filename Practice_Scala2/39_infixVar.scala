
trait OutputChannel[-T] {
    def write(x: T): Unit
}

// Scala basic function trait
// f: A => B

trait ImplFunction1[-S, +T] {
    def apply(x: S): T
}


class Publication(val title: String)
class Book(title: String) extends Publication(title)

object Library {
    val books: Set[Book] = 
        Set(
            new Book("Programming in Scala"),
            new Book("Walden")
        )
    def printBookList(info: Book => AnyRef) = {
        for (book <- books) println(info(book))
    }
}
object Customer extends App {
    //              Book       => AnyRef
    def getTitle(p: Publication): String = p.title
    //              ^~ Superclass of Book
    //                            ^~ Subclass of AnyRef
    Library.printBookList(getTitle)

    def plusOne(x: Int): Any = { x + 1 }
}