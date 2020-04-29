package jls

open class CircuitElement constructor(
    inputs: Array<CircuitElementInput>?,
    outputs: Array<CircuitElementOutput>?,
    propagationTime: Int
) {
    val inputs = inputs
    val outputs = outputs
    val propagationTime = propagationTime
    var ticksSinceInputChanged: Int = propagationTime



    fun tick() {
            if(ticksSinceInputChanged < propagationTime){
                if(ticksSinceInputChanged == propagationTime - 1){
                    propagate()
                }
                ++ticksSinceInputChanged
            }

    }

    fun setInputBit(inputNum: Int, wireNum: Int, value: Boolean) {
        inputs?.get(inputNum)?.setInputBit(wireNum, value)
        ticksSinceInputChanged = 0
        if(propagationTime == 0){
            propagate()
        }
    }

    open fun propagate() {}

}

class Or (size: Int, propagationTime: Int): CircuitElement(Array(2){ CircuitElementInput(size) }, Array(1){ CircuitElementOutput(size) }, propagationTime){
    override fun propagate() {
        outputs!![0]!!.setBits(inputs!![0]!!.bits)
    }
}