package jls

class Tester {

}

fun main(args: Array<String>) {
    val or1 = Or(1, 2)
    val or2 = Or(1, 3)
    val or3 = Or(1, 2)

    or1.assignInputToOutput(0, 0, InputAddress(or2, 1, 0))
    or2.assignInputToOutput(0, 0, InputAddress(or3, 0, 0))

    or1.setInputBit(0, 0, true)

    println("or1 out: " + or1.getOutputBit(0, 0))
    println("or2 out: " + or2.getOutputBit(0, 0))
    println("or3 out: " + or3.getOutputBit(0, 0))

    or3.tick()
    or2.tick()
    or1.tick()

    println("or1 out: " + or1.getOutputBit(0, 0))
    println("or2 out: " + or2.getOutputBit(0, 0))
    println("or3 out: " + or3.getOutputBit(0, 0))

    or3.tick()
    or2.tick()
    or1.tick()


    println("or1 out: " + or1.getOutputBit(0, 0))
    println("or2 out: " + or2.getOutputBit(0, 0))
    println("or3 out: " + or3.getOutputBit(0, 0))

    or3.tick()
    or2.tick()
    or1.tick()


    println("or1 out: " + or1.getOutputBit(0, 0))
    println("or2 out: " + or2.getOutputBit(0, 0))
    println("or3 out: " + or3.getOutputBit(0, 0))

    or3.tick()
    or2.tick()
    or1.tick()


    println("or1 out: " + or1.getOutputBit(0, 0))
    println("or2 out: " + or2.getOutputBit(0, 0))
    println("or3 out: " + or3.getOutputBit(0, 0))

    or3.tick()
    or2.tick()
    or1.tick()


    println("or1 out: " + or1.getOutputBit(0, 0))
    println("or2 out: " + or2.getOutputBit(0, 0))
    println("or3 out: " + or3.getOutputBit(0, 0))

    or3.tick()
    or2.tick()
    or1.tick()

    println("or1 out: " + or1.getOutputBit(0, 0))
    println("or2 out: " + or2.getOutputBit(0, 0))
    println("or3 out: " + or3.getOutputBit(0, 0))

    or3.tick()
    or2.tick()
    or1.tick()

    println("or1 out: " + or1.getOutputBit(0, 0))
    println("or2 out: " + or2.getOutputBit(0, 0))
    println("or3 out: " + or3.getOutputBit(0, 0))

    or3.tick()
    or2.tick()
    or1.tick()



}