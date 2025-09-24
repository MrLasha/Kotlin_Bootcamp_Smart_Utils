fun main() {
    var first: Int? = null
    var second: Int? = null

    while (first == null) {
        val input = readLine()
        first = input?.toIntOrNull()
        if (first == null) {
            println("Couldn't parse a number. Please, try again")
        }
    }

    while (second == null) {
        val input = readLine()
        second = input?.toIntOrNull()
        if (second == null) {
            println("Couldn't parse a number. Please, try again")
        }
    }

    println(first.gcd(second))
}

fun Int.gcd(other: Int): Int {
    var a = kotlin.math.abs(this)
    var b = kotlin.math.abs(other)

    while (b != 0) {
        val temp = b
        b = a % b
        a = temp
    }
    return a
}
