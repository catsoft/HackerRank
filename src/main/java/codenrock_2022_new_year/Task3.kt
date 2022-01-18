package codenrock_2022_new_year

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.util.*

class Task3: ITask {

    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val array = keyboard.nextLine().split(",").filter { it.isNotBlank() }.map { it.toInt() }
        val barriers = array.dropLast(1).sorted().toList()
        val size = array.last()

        val s = (1..size).map { "0" }.joinToString("").toCharArray()

        for (barier in barriers) {
            s[barier - 1] = 'X'
        }
        s[s.size - 1] = 'X'

        for (i in 1..3) {
            output.println(s.joinToString(""))
        }

        output.println((1..size).map { "X" }.joinToString(""))
    }
}