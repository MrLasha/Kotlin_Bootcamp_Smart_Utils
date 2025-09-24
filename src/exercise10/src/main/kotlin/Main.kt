data class User(val name: String, val age: Int )

fun main() {
    print("Enter the number of users: ")
    val size = readLine()?.toIntOrNull()
    if (size == null || size <= 0) {
        println("Input error. Size <= 0")
        return
    }

    val users = mutableListOf<User>()
    var i = 1
    while (i <= size) {
        print("User name #$i: ")
        val name = readLine()?.trim()
        if (name.isNullOrEmpty()) {
            println("Couldn't parse a name. Please, try again")
            continue
        }

        print("Age user #$i: ")
        val ageInput = readLine()?.trim()
        val age = ageInput?.toIntOrNull()
        if (age == null) {
            println("Couldn't parse a number. Please, try again")
            continue
        }

        if (age <= 0) {
            println("Incorrect input. Age <= 0")
            i++
            continue
        }

        users.add(User(name, age))
        i++
    }

    val adults = users.asSequence()
        .filter { it.age >= 18 }
        .map { it.name }
        .toList()

    println(adults.joinToString(", "))
}
