package euler

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task19Test {

    @Test
    fun solve() {

        println(TestUtil.getAnswer("1\n1924 6 6\n" + "1925 6 16", Task19()))

        kotlin.test.assertEquals(
            """18
35""".trimMargin(), TestUtil.getAnswer(
                """2
1900 1 1
1910 1 1
2000 1 1
2020 1 1""", Task19()
            )
        )

        kotlin.test.assertEquals(
            """18""".trimMargin(), TestUtil.getAnswer(
                """1
4699 12 12
4710 1 1""", Task19()
            )
        )


        kotlin.test.assertEquals(
            """2
2
1720
2
1""".trimMargin(), TestUtil.getAnswer(
                """5
1988 3 25
1989 7 13
1924 6 6
1925 6 16
1000000000000 2 2
1000000001000 3 2
1925 6 16
1924 6 6
1905 1 1
1905 1 1""", Task19()
            )
        )

        // euler task
        println(TestUtil.getAnswer("1\n1901 1 1\n2000 12 31", Task19()))
    }
}