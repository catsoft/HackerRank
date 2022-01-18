package euler

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.math.BigInteger
import java.util.*

class Task14 : ITask {
    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()

        val inputs = (0 until count).map { keyboard.nextInt() }
        val countsMap = IntArray(5_000_001)

        for (number in inputs.maxOrNull()!! downTo 2) {
            getDeep(countsMap, number, 0)
        }

        val answers = Array(countsMap.size) { Pair(0, 0) }
        answers[0] = Pair(0, countsMap[0])
        for (i in 1 until countsMap.size) {
            val max = answers[i - 1]
            val current = Pair(i, countsMap[i])
            if (current.second == max.second) {
                answers[i] = if (current.first > max.first) current else max
            } else {
                answers[i] = if (current.second > max.second) current else max
            }
        }

        for (i in inputs) {
            output.println(answers[i].first)
        }
    }

    private fun getDeep(oldChain: IntArray, number: Int, currentDeep: Int) : Int {
        if (number == 1) {
            return currentDeep
        }

        if (number < 5_000_001 && oldChain[number] != 0) {
            return currentDeep + oldChain[number]
        }

        var deepAdd = 0
        var newNumber = BigInteger.valueOf(number.toLong())
        do {
            if (newNumber % BigInteger.valueOf(2) == BigInteger.ZERO) {
                newNumber /= BigInteger.valueOf(2)
            } else {
                newNumber = BigInteger.valueOf(3) * newNumber + BigInteger.ONE
            }
            deepAdd++
        } while (newNumber > BigInteger.valueOf(5_000_000))

        val deep = getDeep(oldChain, newNumber.toInt(), currentDeep + deepAdd)
        if (number < 5_000_001) {
            oldChain[number] = deep - currentDeep
        }
        return deep
    }
}

