package android.dev_company.contracts

import android.dev_company.data.local.room.entities.TestData

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/20/2020. Time: 09:07
 */

interface TestContract{
    interface Model{
        fun getAllByCategory(category: String): List<TestData>
        fun add(testData: TestData)
        fun addAll(data: List<TestData>)
    }
    interface View{
        fun putData(testData: TestData)
        fun changeChecked(position: Int, t: Boolean)
        fun showMessage(message: String)
        fun setChecked(position: Int)
        fun back()
        fun checkResult()
        fun showResult(allTests: Int, solvedTests: Int, correctTests: Int)
        fun closeFragment()
    }
    interface Presenter{
        fun clickVariant(position: Int)
        fun clickBack()
        fun clickHome()
        fun clickNext()
        fun clickPrevious()
        fun showResultWindow()
        fun closeFragment()
    }
}