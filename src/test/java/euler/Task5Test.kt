package euler

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task5Test {

    @Test
    fun solve() {
        kotlin.test.assertEquals(
            "6\n2520", TestUtil.getAnswer(
                """2
3
10""", Task5()
            )
        )

        // euler task
        println(TestUtil.getAnswer("1\n20", Task5()))
    }
}