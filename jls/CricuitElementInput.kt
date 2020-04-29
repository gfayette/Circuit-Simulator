package jls

import java.util.*

class CircuitElementInput constructor(size: Int) {
    val bits: BitSet = BitSet(size)
    private val size = size

    fun setInputBit(wireNum: Int, value: Boolean) {
        bits[wireNum] = value
    }

}