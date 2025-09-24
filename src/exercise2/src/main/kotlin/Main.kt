fun main() {
    while (true) {
        val seconds = readSeconds()
        if (seconds == null) {
            println("Couldn't parse a number. Please, try again")
            continue
        }

        if (seconds < 0) {
            println("Incorrect time")
            continue
        }

        val (h, m, s) = convertToHMS(seconds)
        printTime(h, m, s)
        break
    }
}

fun readSeconds(): Int? {
    print("Введите количество секунд: ")
    val input = readLine()
    return input?.toIntOrNull()
}

fun convertToHMS(totalSeconds: Int): Triple<Int, Int, Int> {
    val hours = totalSeconds / 3600
    val minutes = (totalSeconds % 3600) / 60
    val seconds = totalSeconds % 60
    return Triple(hours, minutes, seconds)
}

fun printTime(hours: Int, minutes: Int, seconds: Int) {
    println("%02d:%02d:%02d".format(hours, minutes, seconds))
}
