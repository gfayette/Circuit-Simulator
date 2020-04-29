package jls

import java.util.*

class CircuitElementOutput constructor(size: Int) {
    private val size = size
    private val bits: BitSet = BitSet(size)
    private val connectedInputs = buildDefaultInputs(size)
    private val nullElement = NullElement()
    private val nullAddress = InputAddress(nullElement, 0, 0)

    private fun buildDefaultInputs(size: Int): Array<InputAddress> = Array(size) {
        nullAddress
    }

    fun getBit(bitNum: Int): Boolean {
        return bits[bitNum]
    }

    fun connectInput(address: InputAddress, outputNum: Int) {
        connectedInputs[outputNum] = address
    }

    fun setBits(newBits: BitSet) {
        for (i in 0 until size - 1) {
            if (bits[i] != newBits[i]) {
                bits[i] = newBits[i]
                if (connectedInputs[i] != nullAddress) {
                    val address = connectedInputs[i]
                    val element = address.circuitElement
                    val input = address.inputNumber
                    val wire = address.wireNumber
                    element.setInputBit(input, wire, bits[i])
                }
            }
        }
    }
}