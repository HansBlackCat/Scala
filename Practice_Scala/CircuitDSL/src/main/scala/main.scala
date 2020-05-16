import dev.circuitDSL._
import dev.circuitDSL.simulation._

object MySimulation extends Adder {
    def InverterDelay: Int = 1
    def AndGateDelay: Int = 3
    def OrGateDelay: Int = 5
}

object MainApp extends App {
    import MySimulation._

    val ipt1, ipt2, sum, carry = new Wire
    ipt1 setSignal false
    ipt2 setSignal true

    halfAdder(ipt1, ipt2, sum, carry)

    run()
    probe("carry", carry)
    probe("sum", sum)
}