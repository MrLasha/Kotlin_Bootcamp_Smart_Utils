fun main() {
    while (true) {
        val n = readN()
        if (n == null) {
            println("Couldn't parse a number. Please, try again")
            continue
        }

        if (n < 0) {
            println("Incorrect number")
            continue
        }

        if (n > 92) {
            println("Too large n")
            continue
        }

        val result = fibonacci(n)
        println(result)
        break
    }
}

fun readN(): Long? {
    print("Enter the number of Fibo: ")
    val input = readLine()
    return input?.toLongOrNull()
}

fun fibonacci(n: Long): Long {
    return when (n) {
        0L -> 0L
        1L -> 1L
        else -> fibonacci(n - 1) + fibonacci(n - 2)
    }
}
