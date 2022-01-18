package euler

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.math.BigInteger
import java.util.*
import kotlin.math.sin

class Task17 : ITask {
    private val thousand = 1_000
    private val million = 1_000_000L
    private val billion = 1_000_000_000L
    private val trillion = 1_000_000_000_000L

    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()

        val inputs = (0 until count).map { keyboard.nextLong() }

        for (i in inputs) {
            output.println(getAnswer(i))
        }
    }

    fun solveEuler() {
        val strBuilder = StringBuilder()
        for (i in 1..1000) {
            strBuilder.append(getAnswer(i.toLong()))
        }
        println(strBuilder.toString().replace(" ", "").length)
    }

    private fun getAnswer(i: Long) : String {
        var answer = ""

        if (i >= trillion) {
            answer += formatAnswer(getNumbers(((i / trillion).toInt())), " Trillion ")
        }

        if (i >= billion) {
            answer += formatAnswer(getNumbers((((i % trillion) / billion).toInt())), " Billion ")
        }

        if (i >= million) {
            answer += formatAnswer(getNumbers(((i % billion) / million).toInt()), " Million ")
        }

        if (i >= thousand) {
            answer += formatAnswer(getNumbers(((i % million) / thousand).toInt()), " Thousand ")
        }

        answer += formatAnswer(getNumbers((i % thousand).toInt()), "")

        return answer.trim()
    }

    private fun formatAnswer(answerStr : String, add: String): String =
        if (answerStr.trim().isNotEmpty()) answerStr.trim() + add else ""

    private fun getNumbers(number: Int) : String {
        val hundreds = (number % 1000) / 100

        var hundredsStr = ""

        if (hundreds != 0) {
            hundredsStr += getSingle(hundreds) + " Hundred"
        }

        var dozensStr = ""
        val dozens = getDozens(number).trim()
        if (dozens.isNotEmpty()) {
            dozensStr += " " + getDozens(number)
        }

        val dosens = (number % 100) / 10
        if (dosens != 1) {
            val singleStr = getSingle(number).trim()

            if (singleStr.isNotEmpty()) {
                dozensStr += " $singleStr"
            }
        }

        // for euler task
//        val answer = hundredsStr + (if(hundredsStr.isNotEmpty() && dozensStr.isNotEmpty()) " and" else "") + dozensStr
        // for hackerRank
        val answer = hundredsStr + dozensStr

        return answer
    }

    private fun getDozens(number: Int) : String {
        val dosens = (number % 100)
        if (dosens < 20) {
            return when(dosens) {
                19 -> "Nineteen"
                18 -> "Eighteen"
                17 -> "Seventeen"
                16 -> "Sixteen"
                15 -> "Fifteen"
                14 -> "Fourteen"
                13 -> "Thirteen"
                12 -> "Twelve"
                11 -> "Eleven"
                10 -> "Ten"
                else -> ""
            }
        } else {
            return when(dosens / 10) {
                2 -> "Twenty"
                3 -> "Thirty"
                4 -> "Forty"
                5 -> "Fifty"
                6 -> "Sixty"
                7 -> "Seventy"
                8 -> "Eighty"
                9 -> "Ninety"
                else -> ""
            }
        }

    }

    private fun getSingle(number: Int) : String = when(number % 10) {
        1 -> "One"
        2 -> "Two"
        3 -> "Three"
        4 -> "Four"
        5 -> "Five"
        6 -> "Six"
        7 -> "Seven"
        8 -> "Eight"
        9 -> "Nine"
        else -> ""
    }
}

