package codenrock_2022_new_year

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.util.*

class Task2: ITask {

    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()
        //S = ½(2a1 + d(n-1))n
        val a1 = if (count % 2 == 0) 2 else 1
        val n = (count - a1) / 2
        val answer = ((2 * a1 + 2 * (n)) * (n + 1)) / 2
        output.println(answer)
    }
}