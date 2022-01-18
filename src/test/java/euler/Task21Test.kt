package euler

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task21Test {

    @Test
    fun solve() {
        kotlin.test.assertEquals(
            """504""".trimMargin(), TestUtil.getAnswer(
                """1
300""".trimMargin(), Task21())
        )

        // euler task
        println(TestUtil.getAnswer("1\n10000", Task21()))
    }
}