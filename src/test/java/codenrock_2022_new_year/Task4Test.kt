package codenrock_2022_new_year

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task4Test {

    @Test
    fun solve() {
        kotlin.test.assertEquals(
            """4D,4F,4H,1k""".trimMargin(), TestUtil.getAnswer(
                """DDDDFFFFHHHHk""".trimMargin(), Task4()
            )
        )
    }
}