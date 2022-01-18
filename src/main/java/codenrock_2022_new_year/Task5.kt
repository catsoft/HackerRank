package codenrock_2022_new_year

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.util.*

class Task5 : ITask {

    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val line = keyboard.nextLine().split(" ").filter { it.isNotBlank() }.toTypedArray()
        val alfabet = "абвгдеёжзийклмнопрстуфхцчышщьъэюя"
        var answer = ""

        for ((index, _) in line.withIndex()) {
            if (index == line.size - 1) continue

            val first = line[index]
            val second = line[index + 1]
            if (first.first().isUpperCase() && second.first().isUpperCase()
                && first.length > 1 && second.length > 1
                && first.drop(1).toLowerCase().all { alfabet.contains(it) }
            ) {
                val firstStr = first.filter { alfabet.contains(it.toLowerCase()) }
                val secondStr = second.filter { alfabet.contains(it.toLowerCase()) }

                answer += " $firstStr $secondStr,"
            }
        }

        output.println(answer.substring(1, answer.length - 1))
    }
}