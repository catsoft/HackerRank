import java.io.InputStream
import java.io.PrintStream

interface ITask {
    fun solve(input: InputStream, output: PrintStream)
}