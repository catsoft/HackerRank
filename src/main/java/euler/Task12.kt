package euler

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.math.BigInteger
import java.util.*
import kotlin.math.sqrt

class Task12 : ITask {
    override fun solve(inputStream: InputStream, output: PrintStream) {
        val keyboard = Scanner(inputStream)
        val count = keyboard.nextInt()
        val inputs = (0 until count).map { keyboard.nextLong() }
        val primeNumbers = getPrimeNumbers(Math.sqrt(842161320.0).toLong())
        val trianglesNumbers = mutableListOf<Long>()
        val trianglesMap = mutableListOf<Map<Long, Int>>()
        val counts = mutableListOf<Int>()
        trianglesNumbers.add(1)
        trianglesMap.add(hashMapOf())
        counts.add(1)
        var i = 2

        for (input in inputs) {
            val index = counts.indexOfFirst { it > input }
            if (index != -1) {
                output.println(trianglesNumbers[index])
            } else {
                while (counts.last() <= input) {
                    trianglesNumbers.add(trianglesNumbers.last() + i)
                    val lastPrimeSet = getPrimeSet(trianglesNumbers.last(), primeNumbers)
                    trianglesMap.add(lastPrimeSet)
                    val dividersCount = lastPrimeSet.map { it.value + 1 }.reduce { acc, num -> acc * num }

                    counts.add(dividersCount)
                    i++
                }
                output.println(trianglesNumbers.last())
            }
        }
    }

    private fun getFact(number: Int): BigInteger {
        var factorial = BigInteger.ONE
        for (i in 1L..number) {
            factorial = factorial.multiply(BigInteger.valueOf(i))
        }
        return factorial
    }

    private fun getPrimeSet(number: Long, primeNumbers: List<Int>): Map<Long, Int> {
        var long = number
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

        return currentPrimes.groupBy { it }.map { Pair(it.key, it.value.size) }.toMap()
    }

    private fun getPrimeNumbers(top: Long): List<Int> {
        val array = arrayListOf<Boolean>()
        for (i in 0..top.toInt()) {
            array.add(false)
        }

        val primeList = mutableListOf<Int>()
        for (i in 2 until array.size) {
            if (array[i]) continue
            primeList.add(i)
            for (j in i until array.size step i) {
                array[j] = true
            }
        }

        return primeList
    }
}

