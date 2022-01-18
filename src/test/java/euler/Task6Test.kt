package euler

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task6Test {

    @Test
    fun solve() {
        kotlin.test.assertEquals(
            "22\n2640", TestUtil.getAnswer(
                """2
3
10""", Task6()
            )
        )

        // euler task
        println(TestUtil.getAnswer("1\n100", Task6()))
    }
}