package euler

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task20Test {

    @Test
    fun solve() {
        kotlin.test.assertEquals(
            """6
9
27
10539
1""".trimMargin(), TestUtil.getAnswer(
                """5
3
6
10
1000
0""".trimMargin(), Task20())
            )

        // euler task
        println(TestUtil.getAnswer("1\n100", Task20()))
    }
}