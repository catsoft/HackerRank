package euler

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.util.*

class Task7 : ITask {
    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()
        val inputs = (0 until count).map { keyboard.nextInt() }
        val maxSize = inputs.maxOrNull()!!

        val primeNumbers = mutableListOf<Long>()
        var currentNumber = 2L
        primeNumbers.add(currentNumber)
        while (primeNumbers.size < maxSize) {
            val newNumber = currentNumber + 1L
            if (primeNumbers.all { newNumber.mod(it) != 0L }) {
                primeNumbers.add(newNumber)
            }
            currentNumber = newNumber
        }

        for(i in inputs) {
            output.println(primeNumbers[i - 1])
        }
    }
}

