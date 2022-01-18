package euler

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.math.BigInteger
import java.util.*

class Task16 : ITask {

    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()

        val inputs = (0 until count).map { keyboard.nextInt() }
        val max = inputs.maxOrNull()!!
        val answers = Array<BigInteger>(max + 2) { BigInteger.ZERO }

        var currentValue = BigInteger.valueOf(1)
        val two = BigInteger.valueOf(2)
        for (j in 1..max) {
            currentValue *= two
            answers[j] = currentValue
        }

        for (i in inputs) {
            output.println(answers[i].toString().toCharArray().map { it.toString().toInt() })
        }
    }
}

