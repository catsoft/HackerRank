package euler

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.math.BigInteger
import java.util.*
import kotlin.math.sin

class Task18 : ITask {

    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()

        for (i in 0 until count) {
            val lines = keyboard.nextInt()
            keyboard.nextLine()
            val arrays = Array(lines) { IntArray(0) { 0 } }
            for (j in 0 until lines) {
                arrays[j] = keyboard.nextLine().split(" ").filter { it.isNotBlank() }.map { it.toInt() }.toIntArray()
            }

            for (j in lines - 2 downTo 0) {
                for (k in 0..j) {
                    arrays[j][k] += Math.max(arrays[j + 1][k], arrays[j + 1][k + 1])
                }
            }
            output.println(arrays[0][0])
        }
    }
}

