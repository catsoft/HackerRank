package euler

import org.junit.jupiter.api.Test

internal class Task16Test {

    @Test
    fun solve() {
        println(TestUtil.getAnswer("1\n1000", Task16()))

        kotlin.test.assertEquals(
            """26
8""".trimMargin(), TestUtil.getAnswer(
                """2
15
9""", Task16()
            )
        )

        // corner test
        println(TestUtil.getAnswer("1\n10000", Task16()))

        // euler task
        println(TestUtil.getAnswer("1\n1000", Task16()))
    }
}