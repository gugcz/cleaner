
import com.github.debop.kodatimes.lastYear
import com.github.salomonbrys.kotson.fromJson
import com.github.salomonbrys.kotson.registerTypeAdapter
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import org.joda.time.DateTime
import org.supercsv.io.CsvBeanWriter
import org.supercsv.prefs.CsvPreference
import java.io.File
import java.io.FileReader
import java.io.FileWriter

/**
 * Main entry point.
 *
 * @author David Vávra (david@vavra.me)
 */
fun main(args: Array<String>) {
    println("-- Cleaner is getting started --")
    val gugers = loadInput()
    println("${gugers.size} GUGers loaded")
    val lastYear = calculateLastYear(gugers)
    outputToCsv(lastYear)
    println("Results written to output.csv file")
    println("-- Cleaner has completed this job --")
}

private fun loadInput(): List<Guger> {
    val gson = GsonBuilder()
            .registerTypeAdapter<DateTime> {
                deserialize {
                    DateTime(it.json.asString)
                }
            }
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
    return gson.fromJson<List<Guger>>(FileReader(File("input.json")))
}

fun calculateLastYear(gugers: List<Guger>): List<Result> {
    return gugers.map {
        val support = it.eventOccurences.filter { it.dateFrom.isAfter(lastYear()) }.size
        val garant = it.garantOfEventOccurences.filter { it.dateFrom.isAfter(lastYear()) }.size
        Result(it.firstName + " " + it.lastName, it.email, support, garant, support + garant, it.groups.joinToString { it.name })
    }.sortedBy { it.total }
}

fun outputToCsv(lastYear: List<Result>) {
    val writer = CsvBeanWriter(FileWriter("output.csv"), CsvPreference.STANDARD_PREFERENCE)
    writer.writeHeader("Name", "Email", "# events last year as support", "# events last year as garant", "# events last year", "Chapters")
    lastYear.forEach {
        writer.write(it, "name", "email", "support", "garant", "total", "groups")
    }
    writer.close()
}
