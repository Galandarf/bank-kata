package com.galandarf.bank

import com.galandarf.bank.transaction.TransactionRepository

fun main() {

    val console = Console()
    val statementPrinter = StatementPrinter(console)
    val calendar = Calendar()
    val transactionRepository = TransactionRepository(calendar)
    val account = Account(transactionRepository, statementPrinter)

    account.deposit(1000)
    account.withdraw(100)
    account.deposit(2000)
    account.withdraw(1033)

    account.printStatement()
}
