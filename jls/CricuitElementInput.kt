package jls

import java.util.*

class CircuitElementInput constructor(size: Int) {
    private val bits: BitSet = BitSet(size)
    private val size = size
    private var inputChanged: Boolean = false

    public fun setInputBit(inputWireNum: Int, inputWireValue: Boolean): Boolean {
        if (bits[inputWireNum] == inputWireValue) {
            return false
        } else {
            bits[inputWireNum] = inputWireValue
            return true
        }
    }

}