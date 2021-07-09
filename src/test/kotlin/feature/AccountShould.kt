package feature

import kotlin.test.BeforeTest
import kotlin.test.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class AccountShould {

    private var statementPrinter = mock(StatementPrinter::class.java)
    private var transactionRepository = mock(TransactionRepository::class.java)

    private lateinit var account: Account

    @BeforeTest
    fun begin() {
        account = Account(transactionRepository)
    }

    @Test
    fun `store a deposit transaction`() {
        val amount = 100

        account.deposit(amount)

        verify(transactionRepository).addDeposit(100)
    }

    @Test
    fun `store a withdraw transaction`() {
        val amount = 100

        account.withdraw(amount)

        verify(transactionRepository).addWithdrawal(100)
    }

    @Test
    fun `print a statement`() {
        val transactions = listOf(Transaction())
        `when`(transactionRepository.allTransactions()).thenAnswer { transactions }

        account.printStatement()

        verify(statementPrinter).print(transactions)
    }
}
