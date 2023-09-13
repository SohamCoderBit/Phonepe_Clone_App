package com.example.phonepeclone.Data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.phonepeclone.R

data class BottomnavItem(
    val label: String,
    val icon: Int,
    var isSelected: MutableState<Boolean>
)

class MainScreenRepository {

    private var bottomNavBarItemList = arrayListOf<BottomnavItem>()

    fun getBottomAppBarItemList(): List<BottomnavItem> {

        bottomNavBarItemList.add(
            BottomnavItem(
                label = "Home",
                icon = R.drawable.house_solid,
                isSelected = mutableStateOf(true)

            )
        )
        bottomNavBarItemList.add(
            BottomnavItem(
                label = "Store",
                icon = R.drawable.bag_shopping_solid,
                isSelected = mutableStateOf(false)

            )
        )
        bottomNavBarItemList.add(
            BottomnavItem(
                label = "Insurance",
                icon = R.drawable.reshot_icon_shield_checkmark_qezhvp8s34,
                isSelected = mutableStateOf(false)

            )
        )
        bottomNavBarItemList.add(
            BottomnavItem(
                label = "Wealth",
                icon = R.drawable.indian_rupee_sign_solid,
                isSelected = mutableStateOf(false)

            )
        )
        bottomNavBarItemList.add(
            BottomnavItem(
                label = "History",
                icon = R.drawable.folder_solid,
                isSelected = mutableStateOf(false)
            )
        )

        return bottomNavBarItemList
    }

}