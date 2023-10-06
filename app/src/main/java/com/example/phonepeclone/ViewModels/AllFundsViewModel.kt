package com.example.phonepeclone.ViewModels

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.phonepeclone.ui.Screens.WealthScreens.CategoryElements
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class AllFundsViewModel : ViewModel() {

    private val _categoryMap =
        MutableLiveData<LinkedHashMap<String, MutableList<CategoryElements>>>(
            linkedMapOf()
        )
    private val _filterMap = MutableLiveData<LinkedHashMap<String, MutableList<CategoryElements>>>(
        linkedMapOf()
    )

    var categoryCount = mutableIntStateOf(0)
    var categoryTypeList = mutableListOf<String>()

    private var checkedCategoryList = mutableListOf<String>()

    var filterCount = mutableIntStateOf(0)
    var filterTypeList = mutableListOf<String>()

    private var checkedFilterList = mutableListOf<String>()

    val categoryMap: LiveData<LinkedHashMap<String, MutableList<CategoryElements>>>
        get() = _categoryMap

    val filterMap: LiveData<LinkedHashMap<String, MutableList<CategoryElements>>>
        get() = _filterMap

    var categoryMapping = mutableStateOf<LinkedHashMap<String , MutableList<CategoryElements>>>(
        linkedMapOf()
    )

    /**
     * Creating new Map and list Every time ,
     * Find a New Solution
     */

    //when the updateMap and the innerlist cast to Mutable Then and only then it works , why ?
    fun toggleCheckCategory(category: String, index: Int, onCheckValue: CategoryElements) {
        val updatedMap = _categoryMap.value?.toMutableMap()!!
        toggleChecked(
            updatedMap = updatedMap,
            category = category,
            index = index,
            onCheckValue = onCheckValue
        )
        _categoryMap.value = LinkedHashMap(updatedMap)
    }

    fun setCheckedCategoryList() {
        val internalMap = _categoryMap.value!!
        val categoryList: MutableList<String> = mutableListOf()
        for( (key) in internalMap){
            internalMap[key]?.forEach { item ->
                if(item.isSelected) {
                    categoryList.add(item.CategoryName)
                }
            }
        }

        checkedCategoryList = categoryList
        Log.d("Checked Filter List" , "$checkedCategoryList")
    }

    fun setCheckedFilterList()
    {
        val internalMap = _filterMap.value!!
        val filterList : MutableList<String> = mutableListOf()
        for((key) in internalMap){
            internalMap[key]?.forEach { item ->
                if(item.isSelected){
                    filterList.add(item.CategoryName)
                }
            }
        }

        checkedFilterList = filterList
        Log.d("Checked Filter List" , "$checkedFilterList")
    }


    fun toggleCheckFilter(category: String, index: Int, onCheckValue: CategoryElements) {
        val updatedMap = _filterMap.value?.toMutableMap()!!
        toggleChecked(
            updatedMap = updatedMap,
            category = category,
            index = index,
            onCheckValue = onCheckValue
        )
        _filterMap.value = LinkedHashMap(updatedMap)
    }


    private fun toggleChecked(
        updatedMap: MutableMap<String, MutableList<CategoryElements>>,
        category: String,
        index: Int,
        onCheckValue: CategoryElements
    ) {
        val newList = updatedMap[category]?.toMutableList()!!
        newList[index] = onCheckValue
        updatedMap[category] = newList
    }




    fun clearAllCategoryCheckBoxes() {
        categoryCount.value = 0
        val newMap = _categoryMap.value!!.toMutableMap()
        clearAllCheckBox(newMap)
        _categoryMap.value = LinkedHashMap(newMap)
    }

    fun clearAllFilterCheckBoxes() {
        filterCount.value = 0
        val newMap = _filterMap.value!!.toMutableMap()
        clearAllCheckBox(newMap)
        _filterMap.value = LinkedHashMap(newMap)
    }

    private fun clearAllCheckBox(internalMap: MutableMap<String, MutableList<CategoryElements>>) {

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
        var newMap: LinkedHashMap<String, MutableList<CategoryElements>>
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
            categoryMapping.value = _categoryMap.value!!
            for ((key) in _categoryMap.value!!) {
                categoryTypeList.add(key)
            }
        }
    }

    fun setFilterMap(context: Context) {
        if (_filterMap.value?.isEmpty() == true) {
            _filterMap.value = getJson(context = context, filePath = "FilterBottomSheet.json")

            for ((key) in _filterMap.value!!) {
                filterTypeList.add(key)
            }
        }
    }


}