package jls

class CircuitElementInput constructor(size: Int) {
    var data: Long = 0
        private set
    var connectedOutputs = arrayOfNulls<CircuitElementOutput>(size)


}