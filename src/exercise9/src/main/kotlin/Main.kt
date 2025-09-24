fun main() {
    val size = readLine()?.toIntOrNull()
    if (size == null || size <= 0) {
        println("Input error. Size <= 0")
        return
    }

    val lines = mutableListOf<String>()
    for (i in 1..size) {
        val line = readLine()
        if (line != null) {
            lines.add(line)
        }
    }

    val substring = readLine() ?: ""

    val filtered = filterBySubstring(lines, substring)

    println(filtered.joinToString(", "))
}

fun filterBySubstring(list: List<String>, sub: String): List<String> {
    val result = mutableListOf<String>()
    for (str in list) {
        if (containsSubstring(str, sub)) {
            result.add(str)
        }
    }
    return result
}

fun containsSubstring(str: String, sub: String): Boolean {
    if (sub.isEmpty()) return true
    for (i in 0..str.length - sub.length) {
        var match = true
        for (j in sub.indices) {
            if (str[i + j] != sub[j]) {
                match = false
                break
            }
        }
        if (match) return true
    }
    return false
}
