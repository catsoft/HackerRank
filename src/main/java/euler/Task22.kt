package euler

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.math.BigInteger
import java.util.*

class Task22 : ITask {
    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val lineCount = keyboard.nextInt()
        keyboard.nextLine()
        val inputs = (0 until lineCount).map { keyboard.nextLine().uppercase() }.sorted()
        val hashMap = hashMapOf<String, Long>()
        for ((index, inputLine) in inputs.withIndex()) {
            hashMap[inputLine] = (index + 1) * inputLine.map { it.code.toLong() - 64 }.sum()
        }

        val queryCount = keyboard.nextInt()
        keyboard.nextLine()
        for (i in 0 until queryCount) {
            output.println(hashMap[keyboard.nextLine()])
        }
    }

    fun solveEuler(input: String) {
        val inputs = input.split("\"", ",", " ").filter { it.isNotBlank() }.map { it.uppercase() }.sorted()
        var answer = BigInteger.ZERO
        for ((index, inputLine) in inputs.withIndex()) {
            answer += (index + 1).toBigInteger() * inputLine.map { it.code.toLong() - 64 }.sum().toBigInteger()
        }
        println(answer.toString())
    }
}

