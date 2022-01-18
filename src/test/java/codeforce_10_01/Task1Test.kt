package codeforce_10_01

import euler.Task21
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task1Test {

    @Test
    fun solve() {
        kotlin.test.assertEquals(
            """3
4
1""".trimMargin(), TestUtil.getAnswer(
                """3
6
3 4 2 4 1 2
3
1000 1002 998
2
12 11
""".trimMargin(), Task1()
            )
        )

    }
}