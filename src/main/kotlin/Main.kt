import java.io.File

/**
 * @author David Vávra (david@vavra.me)
 */
fun main(args: Array<String>) {
    println("Cleaner is getting started")
    val text = File("input.json").readText()
    println(text)
}