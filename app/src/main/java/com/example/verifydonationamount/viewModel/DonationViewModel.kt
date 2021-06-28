package com.example.verifydonationamount.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.verifydonationamount.models.Donation
import com.example.verifydonationamount.repository.DonationRepository
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DonationViewModel(app: Application, val donationRepository: DonationRepository): AndroidViewModel(app) {
    fun insert(donation: Donation) = viewModelScope.launch {
        donationRepository.upsert(donation);
    }

    fun getDonationByCycle() = donationRepository.getDonationByCycle()
}