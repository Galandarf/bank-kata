package feature

import kotlin.test.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


internal class StatementPrinterShould{

    private val noTransactions: List<Transaction> = emptyList()
    private val console = mock(Console::class.java)

    @Test
    fun `always print the header`(){

        val statementPrinter = StatementPrinter(console)
        statementPrinter.print(noTransactions)

        verify(console).printLine("DATE | AMOUNT | BALANCE")
    }

    @Test
    fun `print transactions in chronological order`(){

    }
}