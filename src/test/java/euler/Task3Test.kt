package euler

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task3Test {

    @Test
    fun solve() {
        kotlin.test.assertEquals(
            "5\n17\n29", TestUtil.getAnswer(
                """3
10
17
13195""", Task3()
            )
        )

        println(TestUtil.getAnswer("1\n1000000000001", Task3()))

        // euler task
        println(TestUtil.getAnswer("1\n600851475143", Task3()))
    }
}