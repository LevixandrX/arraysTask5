fun main() {
    println("Эта программа группирует слова по признаку 'состоят из одинаковых букв'.")
    println("Введите массив слов через запятую (например: eat, tea, tan, ate, nat, bat):")

    var input: String
    while (true) {
        input = readln().trim()

        if (input.isBlank()) {
            println("Ошибка: ввод не должен быть пустым. Попробуйте снова:")
            continue
        }

        val words = input.split(",").map { it.trim() }
        if (words.any { it.isBlank() || !it.all { char -> char.isLetter() } }) {
            println("Ошибка: введите только слова, состоящие из букв через запятую (например: eat, tea, tan, ate, nat, bat):")
            continue
        }

        break
    }

    val groupedWords = mutableMapOf<String, MutableList<String>>()

    for (word in input.split(",").map { it.trim() }) {
        val key = word.toCharArray().sorted().joinToString("")
        groupedWords.computeIfAbsent(key) { mutableListOf() }.add(word)
    }

    for (group in groupedWords.values) {
        println("\"${group.joinToString("\", \"")}\"")
    }
}