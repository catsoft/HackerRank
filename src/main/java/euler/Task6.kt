package euler

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

class Task6 : ITask {
    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()
        val inputs = (0 until count).map { keyboard.nextInt() }

        mainFor@for(i in inputs) {
            val sum1 = Math.pow(getSum(i, 1).toDouble(), 2.0).toLong()
            val sum2 = getSumOfSqrt(i)

            output.println(sum1 - sum2)
        }
    }

    private fun getSumOfSqrt(max: Int) : Long {
        return (max + 1).toLong() * max * (2 * max + 1) / 6
    }

    private fun getSum(max: Int, divider: Int) : Long {
        val count = (max) / divider.toLong()
        return divider * (count + 1) * count / 2
    }
}

