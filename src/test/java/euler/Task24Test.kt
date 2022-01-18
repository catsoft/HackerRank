package euler

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task24Test {

    @Test
    fun solve() {
        kotlin.test.assertEquals(
            """abcdefghijklm
abcdefghijkml""".trimMargin(), TestUtil.getAnswer(
                """2
1
2""".trimMargin(), Task24())
        )

        //corner case
        println(TestUtil.getAnswer("1\n6227020800", Task24()))

        // euler task
        Task24().solveEuler()
    }
}