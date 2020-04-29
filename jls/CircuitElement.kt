package jls

abstract class CircuitElement constructor(
    val inputs: Array<CircuitElementInput>,
    val outputs: Array<CircuitElementOutput>,
    val propagationTime: Int
) {

    fun tick(){

    }

    abstract fun propagate()

}