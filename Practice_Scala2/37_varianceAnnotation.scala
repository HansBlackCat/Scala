
class Cell[T](init: T) {
    private[this] var current = init
    def get = current
    def set(x: T) = { current = x }
}

/* (in.. def set(x:T) ) error: covariant type T occurs in contravariant position in type T of value x
class CovCell[+T](private[this] var _current: T) {
    def current = _current
    def current_= (setter: T) = { _current = setter }
}
*/


// val c1 = new Cell("abc")
// val c2: Cell[Any] = c1
// error: String <: Any, but class Cell is invariant in type T. You may wish to define T as +T instead.

class ScalaticCell[T](private[this] var _current: T) {
    def current = _current
    def current_= (setter: T) = { _current = setter }
}

// val a1 = Array("abc")
// val a2: Array[Any] = a1
//                      ^
// error: Note: String <: Any, but class Array is invariant in type T.

// 35_Queue1