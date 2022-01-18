package euler

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task7Test {

    @Test
    fun solve() {
        kotlin.test.assertEquals(
            "5\n13", TestUtil.getAnswer(
                """2
3
6""", Task7()
            )
        )

        // euler task
        println(TestUtil.getAnswer("1\n10001", Task7()))
    }
}