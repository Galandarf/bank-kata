package com.galandarf.bank

import java.time.LocalDate
import com.galandarf.bank.Calendar
import kotlin.test.Test
import kotlin.test.assertEquals

internal open class CalendarShould{

    private val testableCalendar = TestableCalendar()

    @Test
    fun `return the date in a dd MM yyyy format`(){

        val date = testableCalendar.currentDayAsString()
        assertEquals("08/07/2021", date)
    }

    protected class TestableCalendar : Calendar() {
        public override fun today(): LocalDate{
            return LocalDate.of(2021, 7, 8)
        }
    }
}
