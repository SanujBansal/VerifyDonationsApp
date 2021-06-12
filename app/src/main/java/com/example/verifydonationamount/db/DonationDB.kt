package com.example.verifydonationamount.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.verifydonationamount.models.Donation

@Database(
        entities = [Donation::class],
        version = 1
)

abstract class DonationDB : RoomDatabase() {

    abstract fun getDonationDao(): DonationDao

    companion object {
        @Volatile
        private var instance: DonationDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
                Room.databaseBuilder(
                        context.applicationContext,
                        DonationDB::class.java,
                        "donation.db"
                ).build()
    }
}