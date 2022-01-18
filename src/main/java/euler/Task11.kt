package euler

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.math.BigInteger
import java.util.*

class Task11 : ITask {
    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val n = 20
        val k = 4
        val arrays = Array(n) { Array(n) { 0L } }
        for (i in 0 until n) {
            arrays[i] = keyboard.nextLine().split(" ").filter { it.isNotEmpty() }.map { it.toLong() }.toTypedArray()
        }

        var max = 0L

        for (i in 0 until n) {
            for (j in 0 until n - k + 1) {
                val hor = arrays[i].drop(j).take(k)
                val vert = arrays.drop(j).take(k).map { it[i] }

                max = Math.max(max, hor.reduce { acc, number -> acc * number })
                max = Math.max(max, vert.reduce { acc, number -> acc * number })
            }
        }

        for (i in 0 until n - k + 1) {
            for (j in 0 until n - k + 1) {
                var currentSum = 1L
                for (p in 0 until k) {
                    currentSum *= arrays[i + p][j + p]
                }
                max = Math.max(max, currentSum)

                currentSum = 1L
                for (p in 0 until k) {
                    currentSum *= arrays[i + k - p - 1][j + p]
                }
                max = Math.max(max, currentSum)
            }
        }

        output.println(max)
    }
}

