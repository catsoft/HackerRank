package euler

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task17Test {

    @Test
    fun solve() {
        Task17().solveEuler()
        println(TestUtil.getAnswer("1\n1001001001101", Task17()))
        println(TestUtil.getAnswer("1\n1000000001", Task17()))
        println(TestUtil.getAnswer("1\n1000001", Task17()))
        println(TestUtil.getAnswer("1\n1001", Task17()))
        println(TestUtil.getAnswer("1\n1", Task17()))

        kotlin.test.assertEquals(
            """Ten
Seventeen
One Hundred Four Billion Three Hundred Eighty Two Million Four Hundred Twenty Six Thousand One Hundred Twelve""".trimMargin(), TestUtil.getAnswer(
                """3
10
17
104382426112""", Task17()
            )
        )
    }
}