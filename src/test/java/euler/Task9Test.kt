package euler

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task9Test {

    @Test
    fun solve() {
        kotlin.test.assertEquals(
            "60\n-1", TestUtil.getAnswer(
                """2
12
4""", Task9()
            )
        )

        println(TestUtil.getAnswer("1\n3000", Task9()))

        // euler task
        println(TestUtil.getAnswer("1\n1000", Task9()))
    }
}