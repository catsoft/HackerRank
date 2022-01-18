package euler

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.math.BigInteger
import java.util.*
import kotlin.math.sin

class Task20 : ITask {

    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()

        val answers = Array(1001) { 1 }
        var currentValue = BigInteger.ONE

        for (i in 1..1000) {
            currentValue *= BigInteger.valueOf(i.toLong())
            answers[i] = currentValue.toString().map { it.toString().toInt() }.sum()
        }

        for (i in 0 until count) {
            val inputValue = keyboard.nextInt()
            output.println(answers[inputValue])
        }
    }
}

