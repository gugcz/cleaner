
import com.github.salomonbrys.kotson.fromJson
import com.github.salomonbrys.kotson.registerTypeAdapter
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import org.joda.time.DateTime
import java.io.File
import java.io.FileReader

/**
 * Main entry point.
 *
 * @author David Vávra (david@vavra.me)
 */
fun main(args: Array<String>) {
    println("Cleaner is getting started")
    val gson = GsonBuilder()
            .registerTypeAdapter<DateTime> {
                deserialize {
                    DateTime(it.json.asString)
                }
            }
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
    val list = gson.fromJson<List<Guger>>(FileReader(File("input.json")))
    println(list)
}