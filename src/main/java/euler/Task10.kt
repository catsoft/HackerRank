package euler

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.math.BigInteger
import java.util.*

class Task10 : ITask {
    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()
        val inputs = (0 until count).map { keyboard.nextLong() }
        val primeNumbers = getPrimeNumbers(inputs.maxOrNull()!!)
        val answers = mutableListOf<BigInteger>()
        answers.add(primeNumbers.first().toBigInteger())
        for (i in 1 until primeNumbers.size) {
            answers.add(answers.last() + primeNumbers[i].toBigInteger())
        }

        mainFor@for(i in inputs) {
            var index = primeNumbers.indexOfFirst { it > i }
            if (index == -1) {
                index = answers.size
            }
            output.println(answers[index - 1])
        }
    }

    private fun getPrimeNumbers(top: Long) : List<Int> {
        val array = arrayListOf<Boolean>()
        for (i in 0..top.toInt()) {
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

