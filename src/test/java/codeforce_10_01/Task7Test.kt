package codeforce_10_01

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task7Test {

    @Test
    fun solve() {
        kotlin.test.assertEquals(
            """2
10
3""".trimMargin(), TestUtil.getAnswer(
                """3

3 3
1 2 1
2 3 2
1 3 2

5 7
4 2 7
2 5 8
3 4 2
3 2 1
2 4 2
4 1 2
1 2 2

3 4
1 2 1
2 3 2
1 3 3
3 1 4
2""".trimMargin(), Task7()
            )
        )

    }
}