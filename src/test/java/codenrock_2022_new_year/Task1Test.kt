package codenrock_2022_new_year

import org.junit.jupiter.api.Test

internal class Task1Test {

    @Test
    fun solve() {
        kotlin.test.assertEquals(
            """13,18,18,15,2,15,20""".trimMargin(), TestUtil.getAnswer(
                """MR Robot""".trimMargin(), Task1()
            )
        )

    }
}