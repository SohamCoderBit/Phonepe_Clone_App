package com.example.phonepeclone.ViewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.phonepeclone.ui.Screens.WealthScreens.CategoryElements
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class AllFundsViewModel : ViewModel() {
    private var mainCategoryMap: LinkedHashMap<String, List<CategoryElements>> = linkedMapOf()


    fun getAllTheCategoryList(context: Context): LinkedHashMap<String, List<CategoryElements>> {
        if (mainCategoryMap.isEmpty()) {
            try {
                val jsonFile = context.assets.open("FundCategory.json")
                val size = jsonFile.available()
                val buffer = ByteArray(size)
                jsonFile.read(buffer)
                jsonFile.close()
                val jsonString = String(buffer, Charsets.UTF_8)
                val gson = Gson()
                mainCategoryMap = gson.fromJson(
                    jsonString,
                    object : TypeToken<LinkedHashMap<String, List<CategoryElements>>>() {}.type
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return mainCategoryMap
    }


}