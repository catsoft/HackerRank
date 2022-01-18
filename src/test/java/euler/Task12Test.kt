package euler

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task12Test {

    @Test
    fun solve() {
        kotlin.test.assertEquals(
            "3\n" +
                    "6\n" +
                    "6\n" +
                    "28", TestUtil.getAnswer(
                """4
1
2
3
4""", Task12()
            )
        )

        // corner test
        println(TestUtil.getAnswer("1\n1000", Task12()))

        // euler task
        println(TestUtil.getAnswer("1\n500", Task12()))
    }
}