package android.dev_company.data.models

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/18/2020. Time: 23:26
 */

data class EntryData(
    val name: String,
    val icon: Int,
    val backColor: Int,
    @DrawableRes val background: Int,
    val textColor: String,
    val hasLiked: Boolean = false
)