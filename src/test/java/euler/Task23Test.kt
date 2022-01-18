package euler

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task23Test {

    @Test
    fun solve() {
        kotlin.test.assertEquals(
            """YES
NO""".trimMargin(), TestUtil.getAnswer(
                """2
24
49""".trimMargin(), Task23())
        )

        // euler task
        Task23().solveEuler()
    }
}