package codenrock_2022_new_year

import org.junit.jupiter.api.Test

internal class Task3Test {

    @Test
    fun solve() {
        kotlin.test.assertEquals(
            """X0X00X0X
X0X00X0X
X0X00X0X
XXXXXXXX""".trimMargin(), TestUtil.getAnswer(
                """1,3,6,8""".trimMargin(), Task3()
            )
        )
    }
}