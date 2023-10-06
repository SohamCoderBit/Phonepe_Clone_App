package com.example.phonepeclone.ui.theme.Screens.TransferMoneyScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.phonepeclone.BlueTopAppBar
import com.example.phonepeclone.DrawIconInRow
import com.example.phonepeclone.HeadingText
import com.example.phonepeclone.Home
import com.example.phonepeclone.R
import com.example.phonepeclone.RowWithDividerElements
import com.example.phonepeclone.SearchBar
import com.example.phonepeclone.SurfaceInView
import com.example.phonepeclone.ViewModels.AddBankAccountVIewModel
import com.example.phonepeclone.WriteLabelInRow
import com.example.phonepeclone.mainNavController
import com.example.phonepeclone.ui.theme.PhonepeCloneTheme

@Composable
fun SelfAccountScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White
    ) {
        BlueTopAppBar(Heading = "Self Account Transfer")

        Box {
            BottomAppBar(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .height(60.dp)
                    .clickable {
                        mainNavController.navigateTo(Route = Home.ADD_BANK_SCREEN)
                    },
                containerColor = colorResource(id = R.color.bottom_nav)
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "ADD BANK ACCOUNT",
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }

            }
        }
    }
}


@Composable
fun AddBankAccount(addBankAccountViewModel: AddBankAccountVIewModel) {

    var searchtextfromuser by remember {
        mutableStateOf("")
    }
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {

        val iconboxmodifier: Modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(Color.White)

        Column(
            modifier = Modifier
                .padding(top = 70.dp)
                .verticalScroll(rememberScrollState())
        ) {
            searchtextfromuser = SearchBar(PlaceHolder = "Search any bank name")

            SurfaceInView(Height = 370) {

                Column {
                    HeadingText(HeadingText = "Popular banks")

                    //Icons of SBI , BOB , HDFC
                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        val surfacemodifier: Modifier = Modifier.weight(1f)
                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            IconSize = 45,
                            IconTint = Color.Unspecified,
                            IconResource = R.drawable.sbi_logo,
                            IconBoxModifier = iconboxmodifier
                        )

                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            IconSize = 40,
                            IconTint = Color.Unspecified,
                            IconResource = R.drawable.bob_icon,
                            IconBoxModifier = iconboxmodifier
                        )

                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            IconSize = 35,
                            IconTint = Color.Unspecified,
                            IconResource = R.drawable.hdfc_icon,
                            IconBoxModifier = iconboxmodifier
                        )
                    }

                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        val surfacemodifier: Modifier = Modifier.weight(1f)
                        WriteLabelInRow(
                            modifier = surfacemodifier,
                            label = "State Bank Of India",
                            maxLine = 1,
                            textOverFlow = TextOverflow.Ellipsis
                        )

                        WriteLabelInRow(modifier = surfacemodifier, label = "Bank Baroda")

                        WriteLabelInRow(modifier = surfacemodifier, label = "HDFC Bank")
                    }


                    //Icons of AXIS , ICICI , BOI
                    Row(modifier = Modifier.padding(top = 30.dp)) {
                        val surfacemodifier: Modifier = Modifier.weight(1f)
                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            IconSize = 35,
                            IconTint = Color.Unspecified,
                            IconResource = R.drawable.axisbank,
                            IconBoxModifier = iconboxmodifier
                        )

                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            IconSize = 40,
                            IconTint = Color.Unspecified,
                            IconResource = R.drawable.icici_bank,
                            IconBoxModifier = iconboxmodifier
                        )

                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            IconSize = 35,
                            IconTint = Color.Unspecified,
                            IconResource = R.drawable.bank_of_india,
                            IconBoxModifier = iconboxmodifier
                        )
                    }

                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        val surfacemodifier: Modifier = Modifier.weight(1f)
                        WriteLabelInRow(modifier = surfacemodifier, label = "Axis bank")

                        WriteLabelInRow(modifier = surfacemodifier, label = "ICICI Bank")

                        WriteLabelInRow(modifier = surfacemodifier, label = "Bank of India")
                    }

                    //Icons of Paytm , Kotak , Union
                    Row(modifier = Modifier.padding(top = 30.dp)) {
                        val surfacemodifier: Modifier = Modifier.weight(1f)
                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            IconSize = 40,
                            IconTint = Color.Unspecified,
                            IconResource = R.drawable.paytm_ns_big,
                            IconBoxModifier = iconboxmodifier
                        )

                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            IconSize = 40,
                            IconTint = Color.Unspecified,
                            IconResource = R.drawable.kotak_bank,
                            IconBoxModifier = iconboxmodifier
                        )

                        DrawIconInRow(
                            SurfaceModifier = surfacemodifier,
                            IconSize = 35,
                            IconTint = Color.Unspecified,
                            IconResource = R.drawable.union_bank,
                            IconBoxModifier = iconboxmodifier
                        )
                    }

                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        val surfacemodifier: Modifier = Modifier.weight(1f)
                        WriteLabelInRow(
                            modifier = surfacemodifier,
                            label = "Paytm Payment",
                            maxLine = 1,
                            textOverFlow = TextOverflow.Ellipsis
                        )

                        WriteLabelInRow(
                            modifier = surfacemodifier, label = "Kotak Mahindra Bank",
                            maxLine = 1,
                            textOverFlow = TextOverflow.Ellipsis
                        )

                        WriteLabelInRow(
                            modifier = surfacemodifier, label = "Union Bank Of India",
                            maxLine = 1,
                            textOverFlow = TextOverflow.Ellipsis
                        )
                    }


                }

            }

            SurfaceInView(Height = 1000) {

                Column {
                    HeadingText(HeadingText = "Other Banks")

                    addBankAccountViewModel.getBanksList(LocalContext.current).forEach { banks ->
                        RowWithDividerElements(
                            Content = banks.BankName,
                            IconSource = R.drawable.building_columns_solid,
                            IconBoxModifier = iconboxmodifier,
                            IconTint = Color.LightGray
                        )
                    }

                }

            }

        }

        BlueTopAppBar(Heading = "Select Bank", BackArrowClick = {
            mainNavController.getNavigationController()?.navigate(Home.ROUTE) {
                mainNavController.getNavigationController()?.graph?.findStartDestination()
                    ?.let { popUpTo(it.id) }
            }
        })
    }
}

@Preview
@Composable
fun PreviewSelfScreen() {
    PhonepeCloneTheme {
        AddBankAccount(viewModel())
    }
}
