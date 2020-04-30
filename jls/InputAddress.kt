package jls

class InputAddress constructor(element: CircuitElement?, inputNum: Int, wireNum: Int) {
    val circuitElement: CircuitElement? = element
    val inputNumber: Int = inputNum
    val wireNumber: Int = wireNum
}