package com.example.phonepeclone.Data

import com.example.phonepeclone.BottomNav
import com.example.phonepeclone.R

data class BottomnavItem(
    val label: String,
    val icon: Int,
    val route : String
)

class MainScreenRepository {

    private var bottomNavBarItemList = arrayListOf<BottomnavItem>()

    fun getBottomAppBarItemList(): List<BottomnavItem> {

        bottomNavBarItemList.add(
            BottomnavItem(
                label = "Home",
                icon = R.drawable.house_solid,
                route = BottomNav.HOME

            )
        )
        bottomNavBarItemList.add(
            BottomnavItem(
                label = "Store",
                icon = R.drawable.bag_shopping_solid,
                route = BottomNav.STORE

            )
        )
        bottomNavBarItemList.add(
            BottomnavItem(
                label = "Insurance",
                icon = R.drawable.reshot_icon_shield_checkmark_qezhvp8s34,
                route = BottomNav.INSURANCE

            )
        )
        bottomNavBarItemList.add(
            BottomnavItem(
                label = "Wealth",
                icon = R.drawable.indian_rupee_sign_solid,
                route = BottomNav.WEALTH

            )
        )
        bottomNavBarItemList.add(
            BottomnavItem(
                label = "History",
                icon = R.drawable.folder_solid,
                route = BottomNav.HISTORY
            )
        )

        return bottomNavBarItemList
    }

}
