package android.dev_company.repositories

import android.dev_company.app.App
import android.dev_company.contracts.TestContract
import android.dev_company.data.local.room.AppDataBase
import android.dev_company.data.local.room.entities.TestData
import java.util.concurrent.Executors

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/20/2020. Time: 09:54
 */

class TestRepository: TestContract.Model{

    private val executors = Executors.newSingleThreadExecutor()

    private val testDao = AppDataBase.getDataBase(App.instance).testDao()

    override fun getAllByCategory(category: String): List<TestData> {
        return testDao.getAllByCategory(category)
    }

    override fun add(testData: TestData) {
        testDao.add(testData)
    }

    override fun addAll(data: List<TestData>) {
        testDao.addAll(data)
    }
}