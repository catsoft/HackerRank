package euler

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.util.*
import kotlin.math.sqrt

class Task5 : ITask {
    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()
        val inputs = (0 until count).map { keyboard.nextLong() }
        val primeNumbers = getPrimeNumbers(inputs.maxOrNull()!!)

        mainFor@for(i in inputs) {
            val primeSet = mutableMapOf<Long, Int>()

            for (j in 2..i) {
                var long = j
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

                val currentPrimeSet = currentPrimes.groupBy { it }.map { Pair(it.key, it.value.size) }.toMap()
                for (set in currentPrimeSet) {
                    primeSet[set.key] = Math.max(set.value, primeSet.getOrDefault(set.key, 0))
                }
            }

            var answer = 1L
            for (set in primeSet) {
                answer *= Math.pow(set.key.toDouble(), set.value.toDouble()).toLong()
            }

            output.println(answer)
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
                array[j] = true
            }
        }

        return primeList
    }
}

