package com.example.verifydonationamount.repository

import com.example.verifydonationamount.db.DonationDB
import com.example.verifydonationamount.models.Donation

class DonationRepository(val db: DonationDB){

    suspend fun upsert(donation: Donation) = db.getDonationDao().upsert(donation)

    fun getDonationByCycle(cycleNumber: Int) = db.getDonationDao().getDonationsByCycle(cycleNumber)

//    suspend fun deleteArticle(donation: Donation) = db.getDonationDao().deleteArticle(article)
}