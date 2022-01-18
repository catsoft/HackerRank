package codenrock_2022_new_year

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.util.*

class Task4: ITask {

    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val line = keyboard.nextLine().toCharArray()

        var currentChar = '-'
        var counter = 0
        var answer = ""
        for (i in line) {
            if (currentChar == i) {
                counter++
            } else {
                if (counter != 0) {
                    answer += counter
                    answer += currentChar
                    answer += ","
                }
                counter = 1
                currentChar = i
            }
        }

        answer += counter
        answer += currentChar

        output.println(answer)
    }
}