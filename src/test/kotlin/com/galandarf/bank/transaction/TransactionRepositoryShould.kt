package com.galandarf.bank.transaction

import com.galandarf.bank.Calendar
import com.galandarf.bank.transaction.Transaction
import com.galandarf.bank.transaction.TransactionRepository
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class TransactionRepositoryShould{

    private val calendar=  mock(Calendar::class.java)
    private lateinit var transactionRepository: TransactionRepository

    private val currentDay = "09/07/2021"

    @BeforeTest
    fun initialize(){
        transactionRepository = TransactionRepository(calendar)
        `when`(calendar.currentDayAsString()).thenAnswer { currentDay }
    }

    @Test
    fun `should create and store a deposit transaction`(){
        transactionRepository.addDeposit(100)

        val transactions = transactionRepository.allTransactions()

        assertEquals(1, transactions.size)
        assertEquals(Transaction(currentDay, 100), transactions[0])
    }

    @Test
    fun `should create and store a withdraw transaction`(){
        transactionRepository.addWithdrawal(100)

        val transactions = transactionRepository.allTransactions()

        assertEquals(1, transactions.size)
        assertEquals(Transaction(currentDay, -100), transactions[0])
    }
}
