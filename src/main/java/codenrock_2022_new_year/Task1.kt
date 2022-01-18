package codenrock_2022_new_year

import ITask
import java.io.InputStream
import java.io.PrintStream

class Task1: ITask {

    override fun solve(input: InputStream, output: PrintStream) {
        val input = generateSequence(::readLine).joinToString("\n")
        val count = input.toUpperCase().replace(" ", "")
        output.println(count.map { it.code.toInt() - 64 }.joinToString(","))
    }
}