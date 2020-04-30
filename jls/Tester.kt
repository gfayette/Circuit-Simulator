package jls

fun tickAsc(tickNum: Int, ce1: CircuitElement, ce2: CircuitElement, ce3: CircuitElement) {
    println("Tick #: $tickNum")
    ce1.beginTick()
    ce2.beginTick()
    ce3.beginTick()

    ce1.endTick()
    ce2.endTick()
    ce3.endTick()

    println("ce1 out: " + ce1.getOutputBit(0, 0))
    println("ce2 out: " + ce2.getOutputBit(0, 0))
    println("ce3 out: " + ce3.getOutputBit(0, 0))
}

fun tickDesc(tickNum: Int, ce1: CircuitElement, ce2: CircuitElement, ce3: CircuitElement) {
    println("Tick #: $tickNum")
    ce3.beginTick()
    ce2.beginTick()
    ce1.beginTick()

    ce3.endTick()
    ce2.endTick()
    ce1.endTick()

    println("ce1 out: " + ce1.getOutputBit(0, 0))
    println("ce2 out: " + ce2.getOutputBit(0, 0))
    println("ce3 out: " + ce3.getOutputBit(0, 0))
}

fun main(args: Array<String>) {
    val or1 = Or("OR1", 1, 1)
    val or2 = Or("OR2", 1, 0)
    val or3 = Or("OR3", 1, 2)
    var ticks = 0

    or1.assignInputToOutput(0, 0, InputAddress(or2, 1, 0))
    or2.assignInputToOutput(0, 0, InputAddress(or3, 0, 0))

    or1.setInputBit(0, 0, true)
/*
    tickAsc(ticks++, or1, or2, or3)
    tickAsc(ticks++, or1, or2, or3)
    tickAsc(ticks++, or1, or2, or3)
    tickAsc(ticks++, or1, or2, or3)
    tickAsc(ticks++, or1, or2, or3)
    tickAsc(ticks++, or1, or2, or3)

 */

    tickDesc(ticks++, or1, or2, or3)
    tickDesc(ticks++, or1, or2, or3)
    tickDesc(ticks++, or1, or2, or3)
    tickDesc(ticks++, or1, or2, or3)
    tickDesc(ticks++, or1, or2, or3)
    tickDesc(ticks++, or1, or2, or3)
    tickDesc(ticks++, or1, or2, or3)

}