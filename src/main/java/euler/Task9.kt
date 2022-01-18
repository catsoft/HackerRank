package euler

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.math.BigInteger
import java.util.*

class Task9 : ITask {
    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()

        for (z in 0 until count) {
            val n = keyboard.nextInt()
            var max = -1

            for (i in 1 until n) {
                val c = i * i - (i - n) * (i - n)
                val b = 2 * (i - n)

                if(c % b == 0) {
                    val bb = c / b
                    val cc = n - bb - i

                    if (bb > 0 && cc > 0) {
                        max = Math.max(max, i * bb * cc)
                    }
                }
            }

            output.println(max)
        }
    }
}

