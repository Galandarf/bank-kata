package feature

class Account(private val transactionRepository: TransactionRepository) {

    fun deposit(amount: Int) {
        transactionRepository.addDeposit(amount)
    }

    fun withdraw(amount: Int) {
        transactionRepository.addWithdrawal(amount)
    }

    fun printStatement() {

    }

}
