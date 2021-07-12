package feature

import java.text.DecimalFormat
import java.util.Collections
import java.util.concurrent.atomic.AtomicInteger
import javax.swing.text.NumberFormatter

class StatementPrinter(private val console: Console) {

    private val statementHeader = "DATE | AMOUNT | BALANCE"
    private val decimalFormatter = DecimalFormat("#.00")

    fun print(transactions: List<Transaction>) {
        console.printLine(statementHeader)
        printStatementLines(transactions)
    }

    private fun printStatementLines(transactions: List<Transaction>) {
        val runningBalance = AtomicInteger(0)
        transactions.map { transaction -> statementLine(transaction, runningBalance)
        }.sortedDescending().forEach { statementLine -> printStatement(statementLine) }
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
