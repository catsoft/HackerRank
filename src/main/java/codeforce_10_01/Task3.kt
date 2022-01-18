package codeforce_10_01

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.util.*

class Task3: ITask {
    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()
        keyboard.nextLine()
        mainfor@for (i in 0 until count) {
            keyboard.nextLine()
            val array = keyboard.nextLine().split(" ").filter { it.isNotBlank() }.map { it.toInt() }.toIntArray().sortedArrayDescending()

            val used = BooleanArray(array.size + 1)

            for (j in array.indices) {
                var x = array[j]
                while (x > array.size || used[x]) {
                    x /= 2
                }

                if (x == 0) {
                    output.println("NO")
                    continue@mainfor
                } else {
                    used[x] = true
                }
            }

            output.println("YES")
        }
    }
}