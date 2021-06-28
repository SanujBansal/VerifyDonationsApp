package com.example.verifydonationamount.repository

import com.example.verifydonationamount.db.MainDB
import com.example.verifydonationamount.models.Donation

class DonationRepository(val db: MainDB){

    suspend fun upsert(donation: Donation) = db.getDonationDao().upsert(donation)

    fun getDonationByCycle() = db.getDonationDao().getDonationsByCycle()

//    suspend fun deleteArticle(donation: Donation) = db.getDonationDao().deleteArticle(article)
}