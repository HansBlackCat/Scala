package dev.circuitDSL.simulation
import dev.circuitDSL.Base

abstract class Element extends Base {
    def InverterDelay: Int
    def AndGateDelay: Int
    def OrGateDelay: Int

    class Wire {
        private var sigVal = false
        private var actions: List[Action] = List()

        def getSignal = sigVal
        def setSignal(s: Boolean) = {
            if (s != sigVal) {
                sigVal = s
                actions.foreach(_())
            }
        }

        def addAction(a: Action) = {
            actions = a :: actions
            a()
        }
    }

    def inverter(ipt: Wire, opt: Wire) = {
        def invertAction() = {
            val inputSig = ipt.getSignal
            afterDelay(InverterDelay) {
                opt.setSignal(!inputSig)
            }
        }
        ipt.addAction(invertAction)
    }

    def andGate(ipt1: Wire, ipt2: Wire, opt:Wire) = {
        def andAction() = {
            val ipt1Sig = ipt1.getSignal
            val ipt2Sig = ipt2.getSignal
            afterDelay(AndGateDelay) {
                opt.setSignal(ipt1Sig | ipt2Sig)
            }
        }
        ipt1.addAction(andAction)
        ipt2.addAction(andAction)
    }

    def orGate(ipt1: Wire, ipt2: Wire, opt: Wire) = {
        def orAction() = {
            val ipt1Sig = ipt1.getSignal
            val ipt2Sig = ipt2.getSignal
            afterDelay(OrGateDelay) {
                opt.setSignal(ipt1Sig | ipt2Sig)
            }
        }
        ipt1.addAction(orAction)
        ipt2.addAction(orAction)
    }

    def probe(name: String, wire: Wire) = {
        def probeAction() = {
            println(name + " " + currentTime +
                " new-value = " + wire.getSignal)
        }
        wire.addAction(probeAction)
    }

}