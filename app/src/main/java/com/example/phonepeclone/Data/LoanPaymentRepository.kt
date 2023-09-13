package com.example.phonepeclone.Data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LoanPaymentRepository {
    fun parseJson(context: Context, FilePath: String): List<LoanBiller> {
        return try {
            val jsonFile = context.assets.open(FilePath)
            val size = jsonFile.available()
            val buffer = ByteArray(size)
            jsonFile.read(buffer)
            jsonFile.close()
            val jsonString = String(buffer, Charsets.UTF_8)
            val gson = Gson()
            gson.fromJson(jsonString, object : TypeToken<List<LoanBiller>>() {}.type)
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
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