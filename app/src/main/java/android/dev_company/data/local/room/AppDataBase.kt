package android.dev_company.data.local.room

import android.content.Context
import android.dev_company.data.local.room.daos.TestDao
import android.dev_company.data.local.room.entities.TestData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/20/2020. Time: 09:49
 */

@Database(entities = [TestData::class], version = 1)
abstract class AppDataBase: RoomDatabase(){

    abstract fun testDao(): TestDao

    companion object{
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDataBase(context: Context): AppDataBase{
            val temp = INSTANCE
            if ( temp != null ){
                return temp
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "app_database"
                )
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}