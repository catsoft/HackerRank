package euler

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.util.*
import kotlin.math.sqrt

class Task4 : ITask {
    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()
        val inputs = (0 until count).map { keyboard.nextLong() }

        var palindroms = mutableListOf<Int>()

        for (i in 999 downTo 100) {
            for(j in 999 downTo 100) {
                val value = i * j
                val strValue = value.toString()
                if (strValue.length != 6) continue

                if (strValue[0] == strValue[5] &&
                        strValue[1] == strValue[4] &&
                        strValue[2] == strValue[3]) {
                    palindroms.add(value)
                }
            }
        }
        palindroms.sort()
        palindroms = palindroms.distinct().toMutableList()

        mainFor@for(i in inputs) {
            val first = palindroms.firstOrNull { it > i }
            val index = if (first == null) palindroms.size else palindroms.indexOf(first)
            output.println(palindroms[index - 1])
        }
    }
}