package com.example.phonepeclone.ViewModels

import android.content.Context
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import com.example.phonepeclone.ui.Screens.WealthScreens.CategoryElements
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class AllFundsViewModel : ViewModel() {
    private var mainCategoryMap: LinkedHashMap<String, MutableList<CategoryElements>> =
        linkedMapOf()

    private val _newCategoryMap =
        MutableStateFlow<LinkedHashMap<String, MutableList<CategoryElements>>>(
            linkedMapOf()
        )

    var categoryCount = mutableIntStateOf(0)

    val newCategoryMap: StateFlow<LinkedHashMap<String, MutableList<CategoryElements>>>
        get() = _newCategoryMap


    fun toggleChecked(category: String, index: Int, onCheckValue: CategoryElements) {
        val updatedMap = _newCategoryMap.value.toMutableMap()
        val newList = updatedMap[category]?.toMutableList()
        newList?.set(index, onCheckValue)
        if (newList != null) {
            updatedMap[category] = newList
        }
        _newCategoryMap.value = LinkedHashMap(updatedMap)

        val currentIsSelected = newList?.get(index)?.isSelected
        if (currentIsSelected == true) {
            categoryCount.value++
        } else {
            categoryCount.value--
        }
    }




    fun getAllTheCategoryList(context: Context): LinkedHashMap<String, MutableList<CategoryElements>> {
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
            _newCategoryMap.value = mainCategoryMap
        }
        return mainCategoryMap
    }


}