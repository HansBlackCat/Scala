
// abstract class cannot be instantiated
abstract class Element {
    override def toString(): String = contents.mkString("\n")

    def contents: Array[String]

    // no-parentheses method
    def height: Int = contents.length
    // if we make hight to `val`, slightly faster, but allocate more memory
    // val height: Int = contents.length

    def width: Int = if (height == 0) 0 else contents(0).length
}

class ArrayElement(conts: Array[String]) extends Element {
    // override contents
    def contents: Array[String] = conts
}

class LineElement(s: String) extends ArrayElement(Array(s)) {
    override def width: Int = s.length
    override def height: Int = 1
}

/* error: class ErrorElement needs to be abstract. Missing implementation for ...
class ErrorElement(conts: Array[String]) extends Element {
    override def height: Int = conts.length
}
*/

class UniformElement (
    ch: Char,
    // `override` required
    override val width: Int,
    override val height: Int,
) extends Element {
    private val line = ch.toString * width
    final def onlyInUniform = println("I'm uniform")
    def contents: Array[String] = Array.fill(height)(line)
}

/* error: cannot override final member ...
class FinalTestElement extends UniformElement('a',3,3) {
    override def onlyInUniform: Unit = println("hi")
}
*/

