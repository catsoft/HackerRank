package euler

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.math.BigInteger
import java.util.*
import kotlin.math.sign
import kotlin.math.sin
import kotlin.math.sqrt

class Task24 : ITask {
    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()
        val inputs = (0 until count).map { keyboard.nextLong() }
        val basicString = "abcdefghijklm"

        for (inputNumber in inputs) {
            currentPermutation = 0
            permutation = ""

            output.println(getPermutation2(basicString.toMutableList(), inputNumber))
        }
    }

    fun solveEuler() {
        val basicString = "0123456789"
        getNPermutation(basicString.toHashSet(), 1000000)
        println(permutation.reversed())
    }

    private var currentPermutation = 0L
    private var permutation = ""

    private fun getPermutation2(charList: MutableList<Char>, neededNumber: Long) : String {
        var answer = ""
        var localNumber = neededNumber.toBigInteger()
        for (i in 0 until charList.size) {
            val allCount = getFact(charList.size - i - 1)
            val divider = localNumber / allCount
            localNumber -= divider * allCount
            answer += charList[divider.toInt()]
            charList.removeAt(divider.toInt())
        }
        return answer
    }

    private fun getFact(number: Int): BigInteger {
        var factorial = BigInteger.ONE
        for (i in 1L..number) {
            factorial = factorial.multiply(BigInteger.valueOf(i))
        }
        return factorial
    }

    // naive solution
    private fun getNPermutation(charList: MutableSet<Char>, neededNumber: Long) : Boolean {
        if (charList.isEmpty()) {
            currentPermutation++
            return currentPermutation == neededNumber
        }

        for (char in charList) {
            val newCharList = charList.toMutableSet()
            newCharList.remove(char)
            if (getNPermutation(newCharList, neededNumber)) {
                permutation += char
                return true
            }
        }
        return false
    }
}

