import kotlin.math.pow
import kotlin.math.sqrt

fun distance(x1: Double, y1: Double, x2: Double, y2: Double): Double {
    return sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2))
}

fun readDouble(): Double? {
    return try {
        readlnOrNull()?.trim()?.toDoubleOrNull()
    } catch (_: Exception) {
        null
    }
}

fun main() {
    val coords = DoubleArray(6)

    while (true) {
        println("Enter coordinates (x1,y1,x2,y2,x3,y3):")
        var validInput = true

        // Читаем 6 координат
        for (i in 0..5) {
            val value = readDouble()
            if (value != null) {
                coords[i] = value
            } else {
                println("Couldn't parse a number. Please, try again")
                validInput = false
                break
            }
        }

        if (!validInput) continue

        val ab = distance(coords[0], coords[1], coords[2], coords[3])
        val bc = distance(coords[2], coords[3], coords[4], coords[5])
        val ca = distance(coords[4], coords[5], coords[0], coords[1])

        if ((ab + bc > ca) && (ab + ca > bc) && (bc + ca > ab)) {
            val perimeter = ab + bc + ca
            println("Perimeter: %.3f".format(perimeter))
        } else {
            println("It's not a triangle")
        }

        break
    }
}
