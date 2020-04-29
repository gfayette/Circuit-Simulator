package jls

import java.util.*

class CircuitElementOutput constructor(size: Int) {
    private val size = size
    private val bits: BitSet = BitSet(size)

    private val connectedInputs = arrayOfNulls<CircuitElementInput>(size)
    private val inputWireNumbers = IntArray(size)

    public fun getBit(bitNum: Int){

    }

    fun setBits(newBits: BitSet){
        for(i in 0 until size - 1){

            if(bits[i] != newBits[i]){
                bits[i] = newBits[i]

            }
        }
        
    }
}