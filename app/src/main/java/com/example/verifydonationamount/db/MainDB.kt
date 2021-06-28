package com.example.verifydonationamount.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.verifydonationamount.models.Donation

@Database(
    entities = [Donation::class],
    version = 1,
    exportSchema = false
)

abstract class MainDB : RoomDatabase(){

    abstract fun getDonationDao() : DonationDao

    companion object {
        @Volatile
        private var instance: MainDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                MainDB::class.java,
                "donationDB.db"
            ).build()
    }
}