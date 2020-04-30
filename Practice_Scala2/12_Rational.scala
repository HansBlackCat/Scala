import scala.language.implicitConversions

class Rational(n: Int, d: Int) {
    // Implicit def
    // implicit def intToRational(x: Int) = new Rational(x)
    // enable `2*x`

    // Initial Condition
    require(d != 0) // IllegalArgumentException
    
    // Field
    private val g = gcd(n.abs, d.abs)
    val numer: Int = n / g
    val denom: Int = d / g

    // Constructor
    def this(n: Int) = this(n,1)

    // Override
    override def toString(): String = s"$numer/$denom"

    // Method
    private def gcd(a: Int, b: Int): Int = {
        if (b == 0) a else gcd(b, a%b)
    }

    private def add(that: Rational): Rational = {
        new Rational(
            numer*that.denom + that.numer*denom, 
            denom*that.denom
        )
    }

    private def min(that: Rational): Rational = {
        new Rational(
            numer * that.denom - that.numer * denom,
            denom * that.denom
        )
    }

    private def mul(that: Rational): Rational = {
        new Rational(
            numer * that.numer, denom * that.denom
        )
    }

    private def div(that: Rational): Rational = {
        new Rational(
            numer * that.denom, denom * that.numer
        )
    }

    def + (that: Rational): Rational = {
        add(that)
    }
    
    def + (i: Int): Rational = {
        val temp = new Rational(i,1)
        add(temp)
    }

    def - (that: Rational): Rational = {
        min(that)
    }

    def - (i: Int): Rational = {
        val temp = new Rational(i,1)
        min(temp)
    }

    def * (that: Rational): Rational = {
        mul(that)
    }

    def * (i: Int): Rational = {
        val temp = new Rational(i,1)
        mul(temp)
    }

    def / (that: Rational): Rational = {
        div(that)
    }

    def / (i: Int): Rational = {
        val temp = new Rational(i,1)
        div(temp)
    }

    def lessThan(that: Rational) = {
        that.numer * that.denom < that.numer * that.denom
    }

    def max(that: Rational) = {
        if (this.lessThan(that)) that else this
    }
}
