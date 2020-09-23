package android.dev_company.data.models

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/21/2020. Time: 16:46
 */

data class CategoryData(
    val title: String,
    val desc: String,
    val img: Int,
    val backColor: Int,
    var liked: Boolean,
    var numberContent: Int,
    var beingTime: Int,
    var score: Int
)