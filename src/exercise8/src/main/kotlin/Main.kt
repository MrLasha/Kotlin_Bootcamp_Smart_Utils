fun main() {
    var prevNumber: Int? = null
    var ordinal = 0
    var inputExists = false

    while (true) {
        val input = readLine() ?: break
        val number = input.toIntOrNull()

        if (number == null) {
            if (!inputExists) {
                println("Input error")
            } else {
                println("The sequence is ordered in ascending order")
            }
            break
        }

        inputExists = true
        ordinal++

        if (prevNumber != null && number < prevNumber) {
            println("The sequence is not ordered from the ordinal number of the number ${ordinal - 1}")
            break
        }

        prevNumber = number
    }
}