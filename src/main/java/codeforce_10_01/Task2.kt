package codeforce_10_01

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.util.*

class Task2: ITask {
    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()
        keyboard.nextLine()
        for (i in 0 until count) {
            val (a, b, c) = keyboard.nextLine().split(" ").filter { it.isNotBlank() }.map { it.toInt() }

            if ((b + b - a) % c == 0 && isProgression(a, b, b + (b - a))) {
                output.println("YES")
                continue
            }


            if ((b - (c - b)) % a == 0 && isProgression(b - (c - b), b, c)){
                output.println("YES")
                continue
            }

            val bb = c - a
            if (bb % 2 == 0 && (a + bb / 2) % b == 0 && isProgression(a, (a + bb / 2), c)) {
                output.println("YES")
                continue
            }

            output.println("NO")
        }
    }

    private fun isProgression(a: Int, b: Int, c: Int) : Boolean {
        return a > 0 && b > 0 && c > 0 && b - a == c - b
    }
}