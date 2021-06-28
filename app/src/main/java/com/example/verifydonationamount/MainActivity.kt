package com.example.verifydonationamount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.verifydonationamount.db.MainDB
import com.example.verifydonationamount.models.Donation
import com.example.verifydonationamount.repository.DonationRepository
import com.example.verifydonationamount.viewModel.DonationViewModel
import com.example.verifydonationamount.viewModel.DonationViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: DonationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsRepository = DonationRepository(MainDB(this))
        val viewModelProviderFactory = DonationViewModelProviderFactory(application, newsRepository)
        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(DonationViewModel::class.java)

        button.setOnClickListener{
            viewModel.insert(Donation(editTextTextPersonName.text.toString(), ediTextAmount.text.toString().toInt(), editTextTextEmailAddress.text.toString(), 1,1))
            Toast.makeText(this, viewModel.getDonationByCycle().toString(), Toast.LENGTH_SHORT).show()
        }
    }
}