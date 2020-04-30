package jls

import java.util.*

open class CircuitElement constructor(
    name: String,
    inputs: Array<CircuitElementInput>?,
    outputs: Array<CircuitElementOutput>?,
    propagationTime: Int
) {
    val name = name
    protected val inputs = inputs
    protected val outputs = outputs
    private val propagationTime = propagationTime
    private var ticksSinceInputChanged: Int = propagationTime
    private var inputSet: Boolean = false


    fun beginTick() {
        println("tick, ticks since last, prop time: $ticksSinceInputChanged, $propagationTime")
        if (ticksSinceInputChanged < propagationTime && !inputSet) {
            ++ticksSinceInputChanged
            if (ticksSinceInputChanged == propagationTime) {
                propagate()
            }
        }
    }

    fun endTick(){
        inputSet = false
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
        inputSet = true
        if (propagationTime == 0) {
            propagate()
        }
    }

    open fun propagate() {}

}

class Or constructor(name: String, numWires: Int, propagationTime: Int) :
    CircuitElement(
        name,
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

class And constructor(name: String, numWires: Int, propagationTime: Int) :
    CircuitElement(
        name,
        Array(2) { CircuitElementInput(numWires) },
        Array(1) { CircuitElementOutput(numWires) },
        propagationTime
    ) {
    override fun propagate() {
        val outBits = inputs!![0].bits.clone() as BitSet
        outBits.and(inputs!![1].bits)
        outputs!![0]!!.setBits(outBits)
    }
}