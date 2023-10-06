package com.example.phonepeclone

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.phonepeclone.Data.BottomnavItem
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme

@Composable
fun MainBottomAppBar(
    navController: NavHostController,
    bottomNavItemList: List<BottomnavItem>,
    showBottomAppbar: Boolean,
    currentRoute: String
) {

    AnimatedVisibility(
        visible = showBottomAppbar,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Box {
            BottomAppBar(
                modifier = Modifier
                    .height(70.dp),
                containerColor = colorResource(id = R.color.bottom_nav)
            ) {

                bottomNavItemList.forEach { menuitem ->
                    val isSelected = currentRoute == menuitem.route

                    val toggleColor: @Composable (Color, Int) -> Color =
                        { firstColor, secondColorID ->
                            if (isSelected) firstColor else colorResource(id = secondColorID)
                        }

                    val iconColor = toggleColor(Color.Black, R.color.bottom_nav_icon_color)
                    val iconBoxColor = toggleColor(Color.White, R.color.bottom_nav_icon_box_color)
                    val textColor = toggleColor(Color.White, R.color.bottom_nav_text_color)

                    BottomNavigationItem(
                        modifier = Modifier
                            .padding(start = 2.dp, end = 2.dp)
                            .width(20.dp),
                        selected = isSelected,
                        onClick = {
                            navController.navigate(route = menuitem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }

                        },
                        icon = {
                            BottomAppBarIcon(
                                iconBoxColor = iconBoxColor,
                                iconColor = iconColor,
                                iconLabel = menuitem.label,
                                iconID = menuitem.icon
                            )
                        },
                        label = {

                            Text(
                                text = menuitem.label,
                                color = textColor,
                                softWrap = false,
                                fontSize = 11.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Medium
                            )
                        },
                    )
                }

            }
        }
    }

}


@Composable
fun BottomAppBarIcon(iconBoxColor: Color, iconColor: Color, iconLabel: String, iconID: Int) {
    Box(
        modifier = Modifier.size(40.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(26.dp)
                .clip(RoundedCornerShape(50))
                .background(iconBoxColor),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                    .height(14.dp),
                imageVector = ImageVector.vectorResource(id = iconID),
                contentDescription = iconLabel,
                tint = iconColor
            )
        }
    }
}


@Composable
fun MainTopAppBar(showTopAppbar: Boolean) {


    AnimatedVisibility(
        visible = showTopAppbar,
        enter = fadeIn(),
        exit = fadeOut()
    )
    {
        Box {
            val boxModifier = Modifier.fillMaxHeight()
            TopAppBar(
                backgroundColor = colorResource(id = R.color.top_nav),
                modifier = Modifier.height(70.dp)
            ) {

                //Profile
                Box(
                    modifier = boxModifier
                        .weight(0.5f)
                        .addClickable(doRipple = false) {
                            mainNavController.navigateTo(Route = Home.PROFILE_SCREEN)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(45.dp)
                            .clip(RoundedCornerShape(35))
                            .background(Color.White), contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(30.dp),
                            painter = painterResource(id = R.drawable.user_icon),
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .align(Alignment.BottomEnd),
                        contentAlignment = Alignment.TopCenter
                    ) {

                        //Here the Country Icon Will be displayed
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .clip(RoundedCornerShape(30)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier.height(20.dp),
                                painter = painterResource(id = R.drawable.ic_launcher_background),
                                contentDescription = null,
                                tint = Color(0, 179, 60)
                            )
                        }
                    }

                }

                //Address
                Box(modifier = boxModifier.weight(1f), contentAlignment = Alignment.CenterStart) {

                    Column {

                        Row(verticalAlignment = Alignment.CenterVertically) {

                            Text(
                                text = "Add Address",
                                color = Color.White,
                                fontWeight = FontWeight.Medium,
                                fontSize = 18.sp
                            )

                            Icon(
                                modifier = Modifier
                                    .padding(start = 5.dp)
                                    .size(16.dp),
                                painter = painterResource(id = R.drawable.caret_down_solid),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }

                        Text(text = "Ahmedabad", color = Color.White, fontSize = 14.sp)
                    }
                }

                //Icons
                Box(modifier = boxModifier.weight(1f), contentAlignment = Alignment.Center) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        //QR Button
                        DrawIcon(IconID = R.drawable.qrcode_solid)

                        //Bell Icon
                        DrawIcon(IconID = R.drawable.bell_regular)

                        //Question Mark
                        DrawIcon(IconID = R.drawable.circle_question_regular)
                    }
                }
            }
        }
    }


}


@Preview
@Composable
fun PreviewTopAppBar() {
    PhonepeCloneTheme {
        MainTopAppBar(true)
    }
}




