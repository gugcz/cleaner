import org.joda.time.DateTime

/**
 * Model of one GUGer from JSON.
 *
 * @author David Vávra (david@vavra.me)
 */
data class Guger(val email: String, val firstName: String, val lastName: String, val groups: List<Chapter>, val eventOccurences: List<Event>, val garantOfEventOccurences: List<Event>)

data class Chapter(val name: String)

data class Event(val dateFrom: DateTime)

data class Result(val name: String, val email: String, val support: Int, val garant: Int, val total: Int, val groups: String)