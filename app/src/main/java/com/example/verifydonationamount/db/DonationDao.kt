package com.example.verifydonationamount.db

import androidx.room.*
import com.example.verifydonationamount.models.Donation


@Dao
interface DonationDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(donation: Donation)

    @Query("SELECT * FROM donation WHERE cycleNumber = 1")
    fun getDonationsByCycle() : List<Donation>

//    @Update
//    suspend fun update(donation: Donation): Donation
}