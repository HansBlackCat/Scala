

object main {
    def isort(xs: List[Int]): List[Int] = {
        if (xs.isEmpty) Nil
        else insert(xs.head,isort(xs.tail))
    }

    def insert(x: Int, xs: List[Int]): List[Int] = {
        if (xs.isEmpty || x <= xs.head) x::xs
        else xs.head :: insert(x, xs.tail)
    }

    def rev[T](xs: List[T]): List[T] = {
        xs match {
            case Nil => xs
            case x :: xs1 => rev(xs1) ::: List(x)
        }
    }

    def msort[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = {
        def merge(xs: List[T], ys: List[T]): List[T] = {
            (xs, ys) match {
                case (Nil, _) => ys
                case (_, Nil) => xs
                case (x :: xss, y :: yss) => {
                    if (less(x,y)) x :: merge(xss, ys)
                    else y :: merge(xs, yss)
                }
            }
        }
        val n = xs.length/2
        if (n == 0) xs
        else {
            val (ys,zs) = xs splitAt n
            merge(msort(less)(ys), msort(less)(zs))
        }
    }
    // msort(_>_)(List(1,6,3,5,3,3,2,2))
    // error: missing parameter type for expanded function
    // msort[Int](_>_)(List(1,6,3,5,3,3,2,2))

    def msortSwapped[T](xs: List[T])(less: (T, T) => Boolean): List[T] = {
        msort(less)(xs)
    }
    // msortSwapped(List(1,6,3,5,3,3,2,2))(_>_)

    

}