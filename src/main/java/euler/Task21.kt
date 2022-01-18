package euler

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.math.BigInteger
import java.util.*
import kotlin.math.sign
import kotlin.math.sin
import kotlin.math.sqrt

class Task21 : ITask {
    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()
        val inputs = (0 until count).map { keyboard.nextInt() }
        val maxInput = inputs.maxOrNull()!!

        val primeNumbers = getPrimeNumbers((maxInput.toLong() + 1) / 2)

        val sumOfDividers = IntArray(400001) { -1 }
        for (i in 1 until Math.max(maxInput * 2, 100001)) {
            val primeSet = getPrimeSet(i.toLong(), primeNumbers).toList().toTypedArray()

            val allDividers = mutableSetOf<Long>()
            getAllDividers(primeSet, 1, 0, allDividers)
            allDividers.remove(i.toLong())

            sumOfDividers[i] = allDividers.sum().toInt()
        }

        val friendlyNumbers = mutableSetOf<Int>()

        for (i in 1..100000) {
            val k = sumOfDividers[i]
            if (k != i && sumOfDividers[k] == i) {
                friendlyNumbers.add(k)
                friendlyNumbers.add(i)
            }
        }

        val friendlyNum = friendlyNumbers.toList().sorted()

        for (i in inputs) {
            output.println(friendlyNum.filter { it < i }.sum())
        }
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

