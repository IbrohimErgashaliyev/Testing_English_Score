package android.dev_company.data.local.room.daos

import android.dev_company.data.local.room.entities.TestData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/20/2020. Time: 09:43
 */

@Dao
interface TestDao{

    @Query("SELECT * FROM TestData")
    fun getAll(): List<TestData>

    @Query("SELECT * FROM TestData WHERE category=:c")
    fun getAllByCategory(c: String): List<TestData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(testData: TestData): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(data: List<TestData>): List<Long>
}