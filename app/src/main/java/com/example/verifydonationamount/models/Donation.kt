package com.example.verifydonationamount.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "donation")
data class Donation(
    val name:String,
    val amount: Int, val email:String,

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val cycleNumber: Int) : Serializable
