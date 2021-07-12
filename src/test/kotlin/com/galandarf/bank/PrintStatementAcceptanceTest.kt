package com.galandarf.bank

import com.galandarf.bank.transaction.TransactionRepository
import com.galandarf.bank.Account
import com.galandarf.bank.Calendar
import com.galandarf.bank.Console
import com.galandarf.bank.StatementPrinter
import kotlin.test.BeforeTest
import kotlin.test.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class PrintStatementFunctionalTest {

    private val calendar: Calendar = mock(Calendar::class.java)
    private var console: Console = mock(Console::class.java)

    private lateinit var account: Account

    @BeforeTest
    fun initialize() {
        account = Account(
            TransactionRepository(calendar),
            StatementPrinter(console),
        )
    }

    @Test
    fun `print statement containing all transactions`() {
        `when`(calendar.currentDayAsString()).thenReturn("01/06/2021", "02/06/2021", "10/06/2021")

        account.deposit(1000)
        account.withdraw(100)
        account.deposit(500)

        account.printStatement()

        val inOrder = Mockito.inOrder(console)
        inOrder.verify(console).printLine("\t  DATE | AMOUNT | BALANCE")
        inOrder.verify(console).printLine("10/06/2021 | 500.00 | 1400.00")
        inOrder.verify(console).printLine("02/06/2021 | -100.00 | 900.00")
        inOrder.verify(console).printLine("01/06/2021 | 1000.00 | 1000.00")
    }
}
