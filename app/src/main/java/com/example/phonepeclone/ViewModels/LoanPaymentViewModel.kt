package com.example.phonepeclone.ViewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.phonepeclone.Data.LoanBiller
import com.example.phonepeclone.Data.LoanPaymentRepository


class LoanPaymentViewModel : ViewModel() {

    private val loanPaymentRepository: LoanPaymentRepository = LoanPaymentRepository()

    private var loanBillersList: List<LoanBiller>? = null

    fun getParsedJson(context: Context):List<LoanBiller> {
        if (loanBillersList == null) {
            loanBillersList = loanPaymentRepository.parseJson(context = context , FilePath = "LoanBillersList.json")
        }
        return loanBillersList as List<LoanBiller>
    }

}
