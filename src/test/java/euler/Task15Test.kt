package euler

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task15Test {

    @Test
    fun solve() {
        kotlin.test.assertEquals(
            """6
10""", TestUtil.getAnswer(
                """2
2 2
3 2""", Task15()
            )
        )

        // corner test
        println(TestUtil.getAnswer("1\n500 500", Task15()))

        // euler task
        println(TestUtil.getAnswer("1\n20 20", Task15()))
    }
}