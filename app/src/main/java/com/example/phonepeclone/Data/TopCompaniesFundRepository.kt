package com.example.phonepeclone.Data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


data class FundBillers(
    val FundProviderName: String,
    val Last3Year: String,
    val MinInvest: String,
    val FundSize: String
)

class TopCompaniesFundRepository {
    fun parseJson(context: Context, FilePath: String): List<FundBillers> {
        return try {
            val jsonFile = context.assets.open(FilePath)
            val size = jsonFile.available()
            val buffer = ByteArray(size)
            jsonFile.read(buffer)
            jsonFile.close()
            val jsonString = String(buffer, Charsets.UTF_8)
            val gson = Gson()
            gson.fromJson(jsonString, object : TypeToken<List<FundBillers>>() {}.type)
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}