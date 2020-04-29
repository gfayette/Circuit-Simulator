package jls

open class CircuitElement constructor(
    val inputs: Array<CircuitElementInput>,
    val outputs: Array<CircuitElementOutput>,
    val propagationTime: Int
) {


}