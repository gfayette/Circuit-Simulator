package jls

import java.util.*

open class CircuitElement constructor(
    inputs: Array<CircuitElementInput>?,
    outputs: Array<CircuitElementOutput>?,
    propagationTime: Int
) {
    protected val inputs = inputs
    protected val outputs = outputs
    val propagationTime = propagationTime
    private var ticksSinceInputChanged: Int = propagationTime


    fun tick() {
        println("tick, ticks since last, prop time: $ticksSinceInputChanged, $propagationTime")
        if (ticksSinceInputChanged < propagationTime) {
            if (ticksSinceInputChanged == propagationTime - 1) {
                propagate()
            }
            ++ticksSinceInputChanged
        }
    }

    fun assignInputToOutput(outputNum: Int, wireNum: Int, address: InputAddress) {
        outputs!![outputNum].connectInput(address, wireNum)
    }

    fun getOutputBit(outputNum: Int, wireNum: Int): Boolean {
        return outputs!![outputNum].getBit(wireNum)
    }

    fun setInputBit(inputNum: Int, wireNum: Int, value: Boolean) {
        inputs?.get(inputNum)?.setInputBit(wireNum, value)
        ticksSinceInputChanged = 0
        if (propagationTime == 0) {
            propagate()
        }
    }

    open fun propagate() {}

}

class Or constructor(numWires: Int, propagationTime: Int) :
    CircuitElement(
        Array(2) { CircuitElementInput(numWires) },
        Array(1) { CircuitElementOutput(numWires) },
        propagationTime
    ) {
    override fun propagate() {
        val outBits = inputs!![0].bits.clone() as BitSet
        outBits.or(inputs!![1].bits)
        outputs!![0]!!.setBits(outBits)
    }
}