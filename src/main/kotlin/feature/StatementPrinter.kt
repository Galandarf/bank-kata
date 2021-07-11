package feature

class StatementPrinter(val console: Console) {
    private val statementHeader = "DATE | AMOUNT | BALANCE"

    fun print(transactions: List<Transaction>) {
        console.printLine(statementHeader)
    }

}
