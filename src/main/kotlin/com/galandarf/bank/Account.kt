package com.galandarf.bank

import com.galandarf.bank.transaction.TransactionRepository

class Account(
    private val transactionRepository: TransactionRepository,
    private val statementPrinter: StatementPrinter
) {

    fun deposit(amount: Int) {
        transactionRepository.addDeposit(amount)
    }

    fun withdraw(amount: Int) {
        transactionRepository.addWithdrawal(amount)
    }

    fun printStatement() {
        statementPrinter.print(transactionRepository.allTransactions())
    }
}
