package euler

import TestUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


internal class Task1Test {

    @Test
    fun solve() {
        assertEquals("23\n2318", TestUtil.getAnswer("""2
10
100""", Task1()))

        // euler task
        print(TestUtil.getAnswer("1\n1000", Task1()))
    }
}

