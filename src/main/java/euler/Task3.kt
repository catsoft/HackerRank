package euler

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.util.*
import kotlin.math.sqrt

class Task3 : ITask {
    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()
        val inputs = (0 until count).map { keyboard.nextLong() }
        val primeNumbers = getPrimeNumbers(inputs.maxOrNull()!!)

        mainFor@for(i in inputs) {
            var long = i
            val sqrtLong = sqrt(long.toDouble()).toLong()

            val currentPrimes = mutableListOf<Long>()

            for (prime in primeNumbers.filter { it <= sqrtLong }) {
                while (long % prime == 0L) {
                    currentPrimes.add(prime.toLong())
                    long /= prime
                }
            }

            if (long != 1L) {
                currentPrimes.add(long)
            }

            output.println(currentPrimes.maxOrNull()!!)
        }
    }

    private fun getPrimeNumbers(top: Long) : List<Int> {
        val array = arrayListOf<Boolean>()
        for (i in 0..(sqrt(top.toDouble())).toInt()) {
            array.add(false)
        }

        val primeList = mutableListOf<Int>()
        for(i in 2 until array.size) {
            if (array[i]) continue
            primeList.add(i)
            for (j in i until array.size step i) {
                array[i] = true
            }
        }

        return primeList
    }
}

