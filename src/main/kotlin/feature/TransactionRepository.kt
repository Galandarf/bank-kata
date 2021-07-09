package feature

import java.util.Collections.unmodifiableList

class TransactionRepository(private val calendar: Calendar) {
    private var transactions: MutableList<Transaction> = mutableListOf()

    fun addDeposit(amount: Int) {
        val deposit = Transaction(calendar.currentDayAsString(), amount)
        transactions.add(deposit)
    }

    fun addWithdrawal(amount: Int) {
        val withdrawal = Transaction(calendar.currentDayAsString(), -amount)
        transactions.add(withdrawal)
    }

    fun allTransactions(): List<Transaction> {
        return unmodifiableList(transactions)
    }

}
