package com.example.phonepeclone.Data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


inline fun <reified T> parseJson(context: Context, FilePath: String): List<T> {
    return try {
        val jsonFile = context.assets.open(FilePath)
        val size = jsonFile.available()
        val buffer = ByteArray(size)
        jsonFile.read(buffer)
        jsonFile.close()
        val jsonString = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        gson.fromJson(jsonString, object : TypeToken<List<T>>() {}.type)
    } catch (e: Exception) {
        e.printStackTrace()
        emptyList()
    }
}


class LoanPaymentRepository {
    private var loanBillerList: List<LoanBiller>? = null
    private var categoryItemList = arrayListOf<CategoryItem>()
    fun parseJson(context: Context): List<LoanBiller> {
        loanBillerList = parseJson(context = context, "LoanBillersList.json")
        return loanBillerList as List<LoanBiller>
    }

    fun getCategoryItemList():List<CategoryItem>
    {
        categoryItemList.add(CategoryItem(Content = "Microfianance Institutions (MFI)"))
        categoryItemList.add(CategoryItem(Content = "Vehicle Loan"))
        categoryItemList.add(CategoryItem(Content = "Gold Loan"))
        categoryItemList.add(CategoryItem(Content = "Small Finance Bank"))
        categoryItemList.add(CategoryItem(Content = "Consumer Loan"))
        categoryItemList.add(CategoryItem(Content = "Bank"))
        categoryItemList.add(CategoryItem(Content = "Home Loan"))
        categoryItemList.add(CategoryItem(Content = "Others"))

        return categoryItemList
    }
}

enum class LoanCategory(val Index: Int) {
    MFI(0),
    VehicleLoan(1),
    GoldLoan(2),
    SmallFinanceBank(3),
    ConsumerLoan(4),
    Bank(5),
    HomeLoan(6),
    Others(7)
}

data class LoanBiller(val BillerName: String, val BillerType: LoanCategory)

data class CategoryItem(val Content: String)