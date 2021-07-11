package feature

import kotlin.test.BeforeTest
import kotlin.test.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

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
        account.deposit(1000)
        account.withdraw(100)
        account.deposit(500)

        account.printStatement()

        verify(console).printLine("Date | Amount | Balance")
        verify(console).printLine("10/06/2021 | 500.00 | 1400.00")
        verify(console).printLine("02/06/2021 | -100.00 | 900.00")
        verify(console).printLine("01/06/2021 | 1000.00 | 1000.00")
    }
}
