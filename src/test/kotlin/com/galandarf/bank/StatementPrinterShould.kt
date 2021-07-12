package com.galandarf.bank

import com.galandarf.bank.transaction.Transaction
import com.galandarf.bank.Console
import com.galandarf.bank.StatementPrinter
import kotlin.test.BeforeTest
import kotlin.test.Test
import org.mockito.Mockito.inOrder
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

internal class StatementPrinterShould {

    private val noTransactions: List<Transaction> = emptyList()
    private val console = mock(Console::class.java)
    private lateinit var statementPrinter: StatementPrinter

    @BeforeTest
    fun initialize() {
        statementPrinter = StatementPrinter(console)
    }

    @Test
    fun `always print the header`() {
        statementPrinter.print(noTransactions)

        verify(console).printLine("\t  DATE | AMOUNT | BALANCE")
    }

    @Test
    fun `print transactions in reverse chronological order`() {
        val transactions = listOfTransactionsContaining(
            deposit("01/06/2021", 1000),
            withdrawal("02/06/2021", 100),
            deposit("10/06/2021", 500)
        )

        statementPrinter.print(transactions)

        val inOrder = inOrder(console)
        inOrder.verify(console).printLine("\t  DATE | AMOUNT | BALANCE")
        inOrder.verify(console).printLine("10/06/2021 | 500.00 | 1400.00")
        inOrder.verify(console).printLine("02/06/2021 | -100.00 | 900.00")
        inOrder.verify(console).printLine("01/06/2021 | 1000.00 | 1000.00")
    }

    private fun listOfTransactionsContaining(vararg transactions: Transaction) = transactions.toList()

    private fun withdrawal(date: String, amount: Int) = Transaction(date, -amount)

    private fun deposit(date: String, amount: Int) = Transaction(date, amount)
}
