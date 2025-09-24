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
    for (i in 1..size) {
        var num: Int?
        while (true) {
            print("Input #$i: ")
            num = readLine()?.toIntOrNull()
            if (num == null) {
                println("Couldn't parse a number. Please, try again")
            } else {
                break
            }
        }
        numbers.add(num)
    }

    val negatives = numbers.filter { it < 0 }
    if (negatives.isEmpty()) {
        println("There are no negative elements")
    } else {
        val sum = negatives.sum()
        val count = negatives.size
        val average = sum.toDouble() / count
        if (average % 1.0 == 0.0) {
            println(average.toInt())
        } else {
            println(average)
        }
    }
}

fun readSize(): Int? {
    print("Enter the count of numbers: ")
    val input = readLine()
    return input?.toIntOrNull()
}
