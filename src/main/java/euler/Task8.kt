package euler

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.math.BigInteger
import java.util.*

class Task8 : ITask {
    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()

        for (i in 0 until count) {
            val n = keyboard.nextInt()
            val k = keyboard.nextInt()
            val bigNumber = keyboard.next()

            val chunkedList = mutableListOf<Long>()
            for (j in k..bigNumber.length) {
                chunkedList.add(bigNumber.substring(j - k, j).map { it.toString().toLong() }.reduce { acc, next -> acc * next})
            }
            output.println(chunkedList.maxOrNull()!!)
        }
    }
}

