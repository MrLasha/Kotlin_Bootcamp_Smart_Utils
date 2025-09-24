import java.io.File

fun main() {
    println("Enter the file path:")
    val fileName = readLine()?.trim() ?: return

    val file = File(fileName)
    if (!file.exists()) {
        println("Input error. File isn't exist")
        return
    }

    val tokens = file.readText().split(Regex("\\s+"))
        .filter { it.isNotBlank() }

    if (tokens.isEmpty()) {
        println("Input error. Size <= 0")
        return
    }

    val size = tokens[0].toIntOrNull()
    if (size == null || size <= 0) {
        println("Input error. Size <= 0")
        return
    }

    val numbers = mutableListOf<Double>()
    for (i in 1 until tokens.size) {
        val num = tokens[i].toDoubleOrNull()
        if (num != null) {
            numbers.add(num)
            if (numbers.size == size) break
        }
    }

    if (numbers.size < size) {
        println("Input error. Insufficient number of elements")
        return
    }

    print("$size ")
    println(numbers.joinToString(" ") + "\nSaving min and max values in file")
    val min = numbers.minOrNull()!!
    val max = numbers.maxOrNull()!!

    File("result.txt").writeText("$min $max")

    println("$min $max")
}
