package euler

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.util.*

class Task1 : ITask {
    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()

        for(i in 0 until count) {
            val t = keyboard.nextInt()
            val sum5 = getSum(t, 5)
            val sum3 = getSum(t, 3)
            val sum15 = getSum(t, 15)

            output.println(sum5 + sum3 - sum15)
        }
    }

    private fun getSum(max: Int, divider: Int) : Long {
        val count = (max - 1) / divider.toLong()
        return divider * (count + 1) * count / 2
    }
}

