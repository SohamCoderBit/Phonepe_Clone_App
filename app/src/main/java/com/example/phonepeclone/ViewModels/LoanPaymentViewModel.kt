package com.example.phonepeclone.ViewModels

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.phonepeclone.Data.CategoryItem
import com.example.phonepeclone.Data.LoanBiller
import com.example.phonepeclone.Data.LoanPaymentRepository


class LoanPaymentViewModel : ViewModel() {

    private val loanPaymentRepository: LoanPaymentRepository = LoanPaymentRepository()

    private var loanBillersList: List<LoanBiller>? = null
    private var categoryItemList:List<CategoryItem>? = null

    //Storing the CurrentlySelected category item so after we can compare and change the color of the Radio Button
    var currentlySelectedCategory by mutableStateOf("")

    fun getLoanBillersList(context: Context):List<LoanBiller> {
        if (loanBillersList == null) {
            loanBillersList = loanPaymentRepository.parseJson(context = context)
        }
        return loanBillersList as List<LoanBiller>
    }

    fun getCategoryItemList():List<CategoryItem>
    {
        if(categoryItemList == null)
        {
            categoryItemList = loanPaymentRepository.getCategoryItemList()
        }
        return categoryItemList as List<CategoryItem>
    }

    fun onSelectChange(categoryItem:CategoryItem)
    {
        currentlySelectedCategory = categoryItem.Content
    }



}
