package euler

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.math.BigInteger
import java.util.*

class Task15 : ITask {
    private var answer = BigInteger.ZERO

    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()

        for (i in 0 until count) {
            val n = keyboard.nextInt()
            val m = keyboard.nextInt()

            val answer = getFact(n + m) / getFact(n) / getFact(m)

            output.println(answer.mod(BigInteger.valueOf(1000000007)))
        }
    }

    private fun getFact(number: Int): BigInteger {
        var factorial = BigInteger.ONE
        for (i in 1L..number) {
            factorial = factorial.multiply(BigInteger.valueOf(i))
        }
        return factorial
    }

    //recursive for tests
    private fun getCount(currentN : Int, currentM: Int, n: Int, m: Int) {
        if (currentN == n || currentM == m) {
            answer++
            return
        }

        getCount(currentN + 1, currentM, n, m)
        getCount(currentN, currentM + 1, n, m)
    }
}

