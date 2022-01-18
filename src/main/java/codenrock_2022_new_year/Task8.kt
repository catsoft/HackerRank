package codenrock_2022_new_year

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.util.*

class Task8 : ITask {

    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val line = keyboard.nextLine().replace("ё", "е").replace("Ё", "Е")

        val pairList = listOf(
            Pair('а', 'п'),
            Pair('б', 'о'),
            Pair('в', 'н'),
            Pair('г', 'м'),
            Pair('д', 'л'),
            Pair('е', 'к'),
            Pair('ж', 'й'),
            Pair('з', 'и'),
            Pair('р', 'я'),
            Pair('с', 'ю'),
            Pair('т', 'э'),
            Pair('у', 'ь'),
            Pair('ф', 'ы'),
            Pair('х', 'ъ'),
            Pair('ц', 'щ'),
            Pair('ч', 'ш')
        )

        var answer = ""

        for (i in line) {
            val newChar = pairList.firstOrNull { it.first == i.toLowerCase() || it.second == i.toLowerCase() }
            if (newChar != null) {
                val nextChar = if (newChar.first == i.toLowerCase()) newChar.second else newChar.first
                answer += if (i.isUpperCase()) nextChar.toUpperCase() else nextChar
            } else {
                answer += i
            }
        }

        output.println(answer)
    }
}