fun main() {
    val sizeInput = readLine()?.trim()
    val size = sizeInput?.toIntOrNull()

    if (size == null || size <= 0) {
        println("Input error. Size <= 0")
        return
    }

    val numbers = mutableListOf<Double>()
    for (i in 1..size) {
        var number: Double? = null
        while (number == null) {
            println("Input #$i:")
            val input = readLine()?.trim()
            number = input?.toDoubleOrNull()
            if (number == null) {
                println("Couldn't parse a number. Please, try again")
            }
        }
        numbers.add(number)
    }

    selectionSort(numbers)

    println(numbers.joinToString(" "))
}

fun selectionSort(list: MutableList<Double>) {
    val n = list.size
    for (i in 0 until n - 1) {
        var minIndex = i
        for (j in i + 1 until n) {
            if (list[j] < list[minIndex]) {
                minIndex = j
            }
        }
        val temp = list[i]
        list[i] = list[minIndex]
        list[minIndex] = temp
    }
}
