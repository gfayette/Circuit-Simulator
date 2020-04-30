package jls

import java.util.*

class CircuitElementOutput constructor(numWires: Int) {
    private val size = numWires
    private val bits: BitSet = BitSet(numWires)
    private val connectedInputs = buildNullInputs(numWires)

    private fun buildNullInputs(size: Int): Array<InputAddress?> = Array(size) {
        null
    }

    fun getBit(bitNum: Int): Boolean {
        return bits[bitNum]
    }

    fun connectInput(address: InputAddress, wireNum: Int) {
        connectedInputs[wireNum] = address
    }

    fun setBits(newBits: BitSet) {
        for (i in 0 until size) {
            if (bits[i] != newBits[i]) {
                bits[i] = newBits[i]
                if (connectedInputs[i] != null) {
                    val address = connectedInputs[i]
                    val element = address!!.circuitElement
                    val input = address!!.inputNumber
                    val wire = address!!.wireNumber
                    element!!.setInputBit(input, wire, bits[i])
                }
            }
        }
    }
}