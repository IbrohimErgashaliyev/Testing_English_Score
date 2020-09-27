package android.dev_company.data.models

import androidx.annotation.DrawableRes

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/24/2020. Time: 20:42
 */

data class GrammarTestData(
    val title: String,
    val description: String,
    @DrawableRes val imageURL: Int,
    val backColor: Int
)