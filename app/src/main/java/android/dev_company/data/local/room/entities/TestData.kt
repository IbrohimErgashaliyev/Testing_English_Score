package android.dev_company.data.local.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/20/2020. Time: 09:34
 */

@Entity
data class TestData(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var question: String,
    var variant1: String,
    var variant2: String,
    var variant3: String,
    var variant4: String,
    var answer: String,
    var category: String,
    var checked: Int = -1
)