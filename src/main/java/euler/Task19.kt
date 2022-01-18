package euler

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.math.BigInteger
import java.util.*
import kotlin.math.sin

class Task19 : ITask {

    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()
        keyboard.nextLine()

        for (i in 0 until count) {
            var (year1, month1, day1) = keyboard.nextLine().split(" ").filter { it.isNotBlank() }.map { it.toLong() }
            var (year2, month2, day2) = keyboard.nextLine().split(" ").filter { it.isNotBlank() }.map { it.toLong() }

            var startYear = 1900L
            var sundayCount = 0L

            // stupid check whether test is broken
            if (year2 < year1
                || year1 == year2 && month2 < month1
                || year1 == year2 && month1 == month2 && day2 < day1) {
                year1 = year2.also { year2 = year1 }
                month1 = month2.also { month2 = month1 }
                day1 = day2.also { day2 = day1 }
            }

            // counting the same years in order to optimize 10^16
            startYear += ((year1 - startYear) / 2800L) * 2800L

            // counting week day offset by year with high years until start year
            for (k in startYear until year1) {
                sundayCount += if (getIsHigh(k)) 366L else 365L
                sundayCount %= 7
            }

            // counting week day offset by month until start month
            for (k in 1 until month1.toInt()) {
                sundayCount += getDaysForMonth(k, year1)
                sundayCount %= 7
            }

            // counting days offset until start month
            sundayCount += day1 - 1
            sundayCount %= 7

            var answer = 0
            // making answer
            // check if the first day of start month is sunday
            if (day1 == 1L && sundayCount == 6L) {
                answer++
            }
            // count days to the first of next month?????
            sundayCount += getDaysForMonth(month1.toInt(), year1) - day1 + 1

            // check every month from start to end from start year to end
            fun makeCount(startMonth: Long, endMonth: Long, startYear: Long, endYear: Long) {
                for (y in startYear..endYear) {
                    for (m in startMonth..endMonth) {
                        sundayCount %= 7
                        if (sundayCount == 6L) {
                            answer++
                        }
                        sundayCount += getDaysForMonth(m.toInt(), y)
                    }
                }
            }

            if (year1 == year2) {
                makeCount(month1 + 1, month2, year1, year1)
            } else {
                makeCount(month1 + 1, 12, year1, year1)

                makeCount(1, 12, year1 + 1, year2 - 1)

                makeCount(1, month2, year2, year2)
            }

            output.println(answer)
        }
    }

    // good
    private fun getDaysForMonth(month: Int, year: Long): Int {
        return when (month) {
            4, 6, 9, 11 -> 30
            1, 3, 5, 7, 8, 10, 12 -> 31
            else -> if (getIsHigh(year)) 29 else 28
        }
    }

    // good
    private fun getIsHigh(year: Long): Boolean {
        var isHigh = year % 4L == 0L
        if (year % 100 == 0L) {
            isHigh = year % 400 == 0L
        }
        return isHigh
    }
}

