package euler

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.math.BigInteger
import java.util.*
import kotlin.math.sign
import kotlin.math.sin
import kotlin.math.sqrt

class Task23 : ITask {
    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()
        val inputs = (0 until count).map { keyboard.nextInt() }
        val maxInput = inputs.maxOrNull()!!

        val primeNumbers = getPrimeNumbers((maxInput.toLong() + 1) / 2)

        val abundantNumbers = mutableListOf<Int>()
        for (i in 1 until 28125) {
            val primeSet = getPrimeSet(i.toLong(), primeNumbers).toList().toTypedArray()

            val allDividers = mutableSetOf<Long>()
            getAllDividers(primeSet, 1, 0, allDividers)
            allDividers.remove(i.toLong())

            if (i < allDividers.sum().toInt()) {
                abundantNumbers.add(i)
            }
        }

        val sumsOfAbundantNumbers = hashSetOf<Int>()
        mainFor@for (k in abundantNumbers) {
            for (q in abundantNumbers) {
                val sum = k + q
                if (sum < 28125) {
                    sumsOfAbundantNumbers.add(k + q)
                } else {
                    continue@mainFor
                }
            }
        }

        for (i in inputs) {
            if (i > 28123 || sumsOfAbundantNumbers.contains(i)) {
                output.println("YES")
            } else {
                output.println("NO")
            }
        }
    }

    fun solveEuler() {
        val primeNumbers = getPrimeNumbers((28125.toLong() + 1) / 2)

        val abundantNumbers = mutableListOf<Int>()
        for (i in 1 until 28125) {
            val primeSet = getPrimeSet(i.toLong(), primeNumbers).toList().toTypedArray()

            val allDividers = mutableSetOf<Long>()
            getAllDividers(primeSet, 1, 0, allDividers)
            allDividers.remove(i.toLong())

            if (i < allDividers.sum().toInt()) {
                abundantNumbers.add(i)
            }
        }

        val sumsOfAbundantNumbers = hashSetOf<Int>()
        mainFor@for (k in abundantNumbers) {
            for (q in abundantNumbers) {
                val sum = k + q
                if (sum < 28125) {
                    sumsOfAbundantNumbers.add(k + q)
                } else {
                    continue@mainFor
                }
            }
        }

        var sum = 0
        for (i in 1..28123) {
            if (!sumsOfAbundantNumbers.contains(i)) {
                sum += i
            }
        }

        println(sum)
    }

    private fun getAllDividers(
        primeSet: Array<Pair<Long, Int>>,
        currentNumber: Long,
        currentIndex: Int,
        answerList: MutableSet<Long>
    ) {
        if (currentIndex >= primeSet.size) {
            return
        }

        answerList.add(currentNumber)
        getAllDividers(primeSet, currentNumber, currentIndex + 1, answerList)
        var temporaryNumber = currentNumber

        for (i in 1..primeSet[currentIndex].second) {
            temporaryNumber *= primeSet[currentIndex].first
            answerList.add(temporaryNumber)
            getAllDividers(primeSet, temporaryNumber, currentIndex + 1, answerList)
        }
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

