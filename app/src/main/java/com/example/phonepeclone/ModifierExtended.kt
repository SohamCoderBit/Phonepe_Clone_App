package com.example.phonepeclone

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier

@Stable
fun Modifier.addClickable(doRipple : Boolean, onClickAction : () -> Unit) : Modifier {
    return if(doRipple){
        this.then(
            this.clickable {
                onClickAction()
            }
        )
    }
    else
    {
        this.then(
            this.clickable(indication = null , interactionSource = MutableInteractionSource()) {
                onClickAction()
            }
        )
    }
}

