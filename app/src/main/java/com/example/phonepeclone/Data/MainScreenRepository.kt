package com.example.phonepeclone.Data

import com.example.phonepeclone.History
import com.example.phonepeclone.Home
import com.example.phonepeclone.Insurance
import com.example.phonepeclone.R
import com.example.phonepeclone.Store
import com.example.phonepeclone.Wealth

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
                route = Home.ROUTE

            )
        )
        bottomNavBarItemList.add(
            BottomnavItem(
                label = "Store",
                icon = R.drawable.bag_shopping_solid,
                route = Store.ROUTE

            )
        )
        bottomNavBarItemList.add(
            BottomnavItem(
                label = "Insurance",
                icon = R.drawable.reshot_icon_shield_checkmark_qezhvp8s34,
                route = Insurance.ROUTE

            )
        )
        bottomNavBarItemList.add(
            BottomnavItem(
                label = "Wealth",
                icon = R.drawable.indian_rupee_sign_solid,
                route = Wealth.ROUTE

            )
        )
        bottomNavBarItemList.add(
            BottomnavItem(
                label = "History",
                icon = R.drawable.folder_solid,
                route = History.ROUTE
            )
        )

        return bottomNavBarItemList
    }

}
