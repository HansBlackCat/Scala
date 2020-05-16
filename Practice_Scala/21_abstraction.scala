import java.io._


object Abstraction {
    def containsNeg(nums: List[Int]): Boolean = {
        var exists = false
        for (num <- nums) {
            if (num < 0) exists = true
        }
        exists
    }

    def containsNeg2(nums: List[Int]): Boolean = nums.exists(_ < 0)

    def containsOdd(nums: List[Int]): Boolean = nums.exists(_ % 2 == 1)

    // Currying
    def curriedSum(x: Int)(y: Int) = x+y
    def plusOne = curriedSum (1) _

    def twice(fn: Int => Int, x: Int) = fn(fn(x))

    // Loan Pattern
    def withPrintWriter(file: File, op: PrintWriter => Unit) = {
        val writer = new PrintWriter(file)
        try {
            op(writer)
        } finally {
            writer.close()
        }
    }

    // by-name parameter
    // Not-eval before the call to Assert
    val tmpB: Boolean = false
    def byNameAssert(predicate: => Boolean) = {
        if (tmpB && !predicate) throw new AssertionError
        else println("T")
    }
    // byNameAssert(5>3)

    def boolAssert(predicate: Boolean) = {
        if (tmpB && !predicate) throw new AssertionError
        else println("T") 
    }
    /* byNameAssert(5/0==0) -> T
     * boolAssert(5/0==0) -> java.lang.ArithmeticException: / by zero
     */
    
}