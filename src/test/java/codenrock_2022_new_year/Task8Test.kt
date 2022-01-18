package codenrock_2022_new_year

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task8Test {

    @Test
    fun solve() {
        kotlin.test.assertEquals(
            """Гзя тэб бапювбк гкюэб""".trimMargin(), TestUtil.getAnswer(
                """Мир это опасное место""".trimMargin(), Task8()
            )
        )
    }
}