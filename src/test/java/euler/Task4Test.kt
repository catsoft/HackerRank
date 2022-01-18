package euler

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task4Test {

    @Test
    fun solve() {
        kotlin.test.assertEquals(
            "101101\n793397\n101101", TestUtil.getAnswer(
                """3
101110
800000
101102""", Task4()
            )
        )

        // euler task
        println(TestUtil.getAnswer("1\n1000000", Task4()))
    }
}