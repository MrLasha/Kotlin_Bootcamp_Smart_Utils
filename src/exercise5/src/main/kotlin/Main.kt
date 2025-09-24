fun main() {
    val size = readSize()
    if (size == null) {
        println("Couldn't parse a number. Please, try again")
        return
    }
    if (size <= 0) {
        println("Input error. Size <= 0")
        return
    }

    val numbers = mutableListOf<Int>()
    var count = 0
    while (count < size) {
        print("Input #${count + 1}: ")
        val num = readLine()?.toIntOrNull()
        if (num == null) {
            println("Couldn't parse a number. Please, try again")
            continue
        }
        numbers.add(num)
        count++
    }

    val matchingNumbers = numbers.filter { hasSameFirstAndLastDigit(it) }

    if (matchingNumbers.isEmpty()) {
        println("There are no such elements")
    } else {
        println(matchingNumbers.joinToString(" "))
    }
}

fun readSize(): Int? {
    print("Enter the count of numbers: ")
    val input = readLine()
    return input?.toIntOrNull()
}

fun hasSameFirstAndLastDigit(n: Int): Boolean {
    val num = kotlin.math.abs(n)
    val lastDigit = num % 10
    var firstDigit = num
    while (firstDigit >= 10) {
        firstDigit /= 10
    }
    return firstDigit == lastDigit
}
