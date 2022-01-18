import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

object TestUtil {
    fun getAnswer(input: String, task: ITask): String {
        val inStream = ByteArrayInputStream(input.toByteArray())
        val outStream = ByteArrayOutputStream()
        val printStream = PrintStream(outStream)
        task.solve(inStream, printStream)

        return String(outStream.toByteArray()).replace("\r", "").trim()
    }
}