package codenrock_2022_new_year

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task2Test {

    @Test
    fun solve() {
        kotlin.test.assertEquals(
            """25""".trimMargin(), TestUtil.getAnswer(
                """9""".trimMargin(), Task2()
            )
        )

        kotlin.test.assertEquals(
            """400""".trimMargin(), TestUtil.getAnswer(
                """39""".trimMargin(), Task2()
            )
        )

        kotlin.test.assertEquals(
            """420""".trimMargin(), TestUtil.getAnswer(
                """40""".trimMargin(), Task2()
            )
        )
    }
}