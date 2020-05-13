import java.time._

class BankAccount {
    private var bal: Int = 0
    def balance: Int = bal

    def deposit(amount: Int) = {
        require(amount > 0)
        bal += amount
    }
    def withdraw(amount: Int) = {
        if (amount > bal) false
        else {
            bal -= amount
            true
        }
    }
}

class Time {
    private[this] var _hour = 12
    private[this] var _minute = 0

    // getter
    def hour: Int = _hour
    // setter
    def hour_= (setter: Int) = { _hour = setter }

    def minute: Int = _minute
    def minute_= (setter: Int) = {
        require(0 <= setter && setter < 60)
        _minute = setter
    }
}

class Thermometer {
    var celsius: Float = _ 
    
    def fahrenheit = celsius * 9 / 5 + 32
    def fahrenheit_= (setter: Float) = {
        celsius = (setter - 32) * 5 / 9
    }

    override def toString(): String = s"${fahrenheit}F/${celsius}C"
}


