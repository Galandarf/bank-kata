package feature

import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import kotlin.test.BeforeTest
import kotlin.test.Test

internal class AccountShould {

    private lateinit var account: Account
    private val transactionRepository: TransactionRepository = mockk()

    @BeforeTest
    fun begin() {
        account = Account(transactionRepository)
    }

    @Test
    fun `store a deposit transaction`() {
        val amount = 100
        justRun { transactionRepository.addDeposit(amount) }

        account.deposit(amount)

        verify { transactionRepository.addDeposit(100) }
    }

    @Test
    fun `store a withdrawal transaction`() {
        val amount = 100
        justRun { transactionRepository.addWithdrawal(amount) }

        account.withdraw(amount)

        verify { transactionRepository.addWithdrawal(100) }
    }

    @Test
    fun `print a statement`() {

    }
}