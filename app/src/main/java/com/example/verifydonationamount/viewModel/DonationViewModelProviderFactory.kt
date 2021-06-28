package com.example.verifydonationamount.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.verifydonationamount.repository.DonationRepository

class DonationViewModelProviderFactory(val app: Application, val donationRepository: DonationRepository)  : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DonationViewModel(app, donationRepository) as T
    }
}