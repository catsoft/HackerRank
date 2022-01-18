package euler

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task2Test {

    @Test
    fun solve() {
        kotlin.test.assertEquals(
            "10\n44", TestUtil.getAnswer(
                """2
10
100""", Task2()
            )
        )

        // euler task
        print(TestUtil.getAnswer("1\n4000000", Task2()))
    }
}