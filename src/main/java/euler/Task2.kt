package euler

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.util.*

class Task2 : ITask {
    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()

        val inputs = (0 until count).map { keyboard.nextLong() }

        val max = inputs.maxOrNull()!!

        val numbers = mutableListOf<Pair<Long, Long>>()
        var number1 = Pair(1L, 0L)
        var number2 = Pair(2L, 2L)
        numbers.add(number1)
        numbers.add(number2)

        while (true) {
            val next = number1.first + number2.first
            val number3 = Pair(next, if (next % 2 == 0L) next + number2.second else number2.second)
            number1 = number2
            number2 = number3
            numbers.add(number3)
            if (next >= max) break
        }

        for(inputNumber in inputs) {
            output.println(numbers[numbers.indexOfFirst { it.first >= inputNumber } - 1].second)
        }
    }
}

