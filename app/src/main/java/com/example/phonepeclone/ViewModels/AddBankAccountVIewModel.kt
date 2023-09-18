package com.example.phonepeclone.ViewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.phonepeclone.Data.parseJson

data class Banks(val BankName:String)
class AddBankAccountVIewModel : ViewModel() {
    private var banksList:List<Banks>? = null
    fun getBanksList(context: Context) : List<Banks>
    {
        if (banksList == null)
        {
            banksList = parseJson(context = context , "AllBankList.json")
        }
        return banksList as List<Banks>
    }

}