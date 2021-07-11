package feature

import java.time.LocalDate
import java.time.format.DateTimeFormatter

open class Calendar {

    fun currentDayAsString(): String {
        val currentDay = today()
        return currentDay.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    }

    protected open fun today(): LocalDate = LocalDate.now()
}
