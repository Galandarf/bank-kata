package com.galandarf.bank

import java.time.LocalDate
import java.time.format.DateTimeFormatter

open class Calendar {

    private val dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    fun currentDayAsString(): String = today().format(dateFormat)

    protected open fun today(): LocalDate = LocalDate.now()
}
