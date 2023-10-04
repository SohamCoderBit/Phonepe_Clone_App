package com.example.phonepeclone.ViewModels

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.phonepeclone.ui.Screens.WealthScreens.CategoryElements
import com.example.phonepeclone.ui.Screens.WealthScreens.ExploreAllFundsBottomSheetScreens
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.io.path.fileVisitor


class AllFundsViewModel : ViewModel() {

    private val _categoryMap =
        MutableLiveData<LinkedHashMap<String, MutableList<CategoryElements>>>(
            linkedMapOf()
        )
    private val _filterMap = MutableLiveData<LinkedHashMap<String, MutableList<CategoryElements>>>(
        linkedMapOf()
    )

    var categoryCount = mutableIntStateOf(0)
    var categoryList = mutableListOf<String>()

    var filterCount = mutableIntStateOf(0)
    var filterList = mutableListOf<String>()


    val categoryMap: LiveData<LinkedHashMap<String, MutableList<CategoryElements>>>
        get() = _categoryMap

    val filterMap: LiveData<LinkedHashMap<String, MutableList<CategoryElements>>>
        get() = _filterMap


    /**
     * Creating new Map and list Every time ,
     * Find a New Solution
     */

    fun toggleCheckCategory(category: String, index: Int, onCheckValue: CategoryElements) {
        val updatedMap = _categoryMap.value?.toMutableMap()!!
        val newList = updatedMap[category]?.toMutableList()!!
        newList[index] = onCheckValue
        updatedMap[category] = newList
        _categoryMap.value = LinkedHashMap(updatedMap)
    }

    fun clearAllCategory()
    {
        categoryCount.value = 0
        val newMap = _categoryMap.value!!.toMutableMap()
        for ((key) in newMap) {
            val newList = newMap[key]?.toMutableList()!!
            newMap[key]?.forEachIndexed { index, _ ->
                newList[index] = CategoryElements(
                    CategoryName = newList[index].CategoryName,
                    isSelected = false
                )
            }
            newMap[key] = newList
        }
        _categoryMap.value = LinkedHashMap(newMap)
    }





    private fun clearAllCheckBox(internalMap: LinkedHashMap<String, MutableList<CategoryElements>>) {

        for ((key) in internalMap) {
            val newList = internalMap[key]?.toMutableList()!!
            internalMap[key]?.forEachIndexed { index, _ ->
                newList[index] = CategoryElements(
                    CategoryName = newList[index].CategoryName,
                    isSelected = false
                )
            }
            internalMap[key] = newList
        }
    }


    private fun getJson(
        context: Context,
        filePath: String
    ): LinkedHashMap<String, MutableList<CategoryElements>> {
        var newMap: LinkedHashMap<String, MutableList<CategoryElements>> = linkedMapOf()
        return try {
            val jsonFile = context.assets.open(filePath)
            val size = jsonFile.available()
            val buffer = ByteArray(size)
            jsonFile.read(buffer)
            jsonFile.close()
            val jsonString = String(buffer, Charsets.UTF_8)
            val gson = Gson()
            newMap = gson.fromJson(
                jsonString,
                object : TypeToken<LinkedHashMap<String, List<CategoryElements>>>() {}.type
            )
            newMap
        } catch (e: Exception) {
            e.printStackTrace()
            linkedMapOf()
        }
    }

    fun setCategoryMap(context: Context) {
        if (_categoryMap.value?.isEmpty() == true) {
            _categoryMap.value = getJson(context = context, filePath = "CategoryBottomSheet.json")

            for ((key) in _categoryMap.value!!) {
                categoryList.add(key)
            }
        }
    }

    fun setFilterMap(context: Context) {
        if (_filterMap.value?.isEmpty() == true) {
            _filterMap.value = getJson(context = context, filePath = "FilterBottomSheet.json")

            for ((key) in _filterMap.value!!) {
                filterList.add(key)
            }
        }
    }


}