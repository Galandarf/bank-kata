package feature

fun main() {

    val console = Console()
    val statementPrinter = StatementPrinter(console)
    val calendar = Calendar()
    val transactionRepository = TransactionRepository(calendar)
    val account = Account(transactionRepository, statementPrinter)

    account.deposit(1000)
    account.withdraw(100)
    account.deposit(2000)

    account.printStatement()
}