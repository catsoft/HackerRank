package codeforce_10_01

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task2Test {

    @Test
    fun solve() {
        kotlin.test.assertEquals(
            """YES
YES
YES
YES
NO
YES
NO
YES
YES
NO
YES""".trimMargin(), TestUtil.getAnswer(
                """11
10 5 30
30 5 10
1 2 3
1 6 3
2 6 3
1 1 1
1 1 2
1 1 3
1 100000000 1
2 1 1
1 2 2
""".trimMargin(), Task2()
            )
        )

    }
}