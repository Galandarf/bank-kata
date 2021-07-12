package com.galandarf.bank

import com.galandarf.bank.transaction.Transaction
import java.text.DecimalFormat
import java.util.concurrent.atomic.AtomicInteger

class StatementPrinter(private val console: Console) {

    private val statementHeader = "\t  DATE | AMOUNT | BALANCE"
    private val decimalFormatter = DecimalFormat("#.00")

    fun print(transactions: List<Transaction>) {
        console.printLine(statementHeader)
        printStatementLines(transactions)
    }

    private fun printStatementLines(transactions: List<Transaction>) {
        val runningBalance = AtomicInteger(0)
        transactions.map { transaction -> statementLine(transaction, runningBalance)
        }.reversed().forEach { statementLine -> printStatement(statementLine) }
    }

    private fun statementLine(transaction: Transaction, runningBalance: AtomicInteger): String {
        return transaction.date!! +
                " | ${decimalFormatter.format(transaction.amount)}" +
                " | ${decimalFormatter.format(runningBalance.addAndGet(transaction.amount))}"
    }

    private fun printStatement(statementLine: String){
        console.printLine(statementLine)
    }
}
