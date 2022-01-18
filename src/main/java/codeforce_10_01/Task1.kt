package codeforce_10_01

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.util.*

class Task1: ITask {
    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()
        for (i in 0 until count) {
            keyboard.nextInt()
            keyboard.nextLine()
            val array = keyboard.nextLine().split(" ").filter { it.isNotBlank() }.map { it.toInt() }
            output.println(array.maxOrNull()!! - array.minOrNull()!!)
        }
    }
}