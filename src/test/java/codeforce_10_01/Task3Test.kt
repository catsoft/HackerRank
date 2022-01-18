package codeforce_10_01

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task3Test {

    @Test
    fun solve() {
        kotlin.test.assertEquals(
            """YES
NO
YES
NO
NO
YES""".trimMargin(), TestUtil.getAnswer(
                """6
4
1 8 25 2
2
1 1
9
9 8 3 4 2 7 1 5 6
3
8 2 1
4
24 7 16 7
5
22 6 22 4 22""".trimMargin(), Task3()
            )
        )

    }
}