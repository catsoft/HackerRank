package euler

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.math.BigInteger
import java.util.*

class Task13 : ITask {
    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()
        keyboard.nextLine()
        val answerValue = (0 until count).map { keyboard.nextLine() }.map { BigInteger(it) }
            .reduce { acc, bigInteger -> acc + bigInteger }

        output.println(answerValue.toString().take(10).toList().joinToString(""))
    }
}

