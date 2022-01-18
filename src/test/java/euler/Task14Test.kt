package euler

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task14Test {

    @Test
    fun solve() {
        kotlin.test.assertEquals(
            """9
9
19""", TestUtil.getAnswer(
                """3
10 
15
20""", Task14()
            )
        )

        // corner test
        println(TestUtil.getAnswer("1\n5000000", Task14()))

        // euler task
        println(TestUtil.getAnswer("1\n1000000", Task14()))
    }
}