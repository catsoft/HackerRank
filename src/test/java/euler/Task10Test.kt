package euler

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task10Test {

    @Test
    fun solve() {
        kotlin.test.assertEquals(
            "10\n17", TestUtil.getAnswer(
                """2
5
10""", Task10()
            )
        )

        // euler task
        println(TestUtil.getAnswer("1\n2000000", Task10()))
    }
}