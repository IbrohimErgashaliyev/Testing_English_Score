package android.dev_company.data.models

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/18/2020. Time: 23:26
 */

data class EntryData(
    val name: String,
    val icon: Int,
    val backColor: Int,
    val hasLiked: Boolean = false
)