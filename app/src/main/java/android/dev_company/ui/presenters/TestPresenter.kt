package android.dev_company.ui.presenters

import android.dev_company.app.App
import android.dev_company.contracts.TestContract
import android.dev_company.data.local.room.AppDataBase
import android.dev_company.data.local.room.entities.TestData
import android.dev_company.ui.dialogs.DialogBack
import android.util.Log
import kotlin.random.Random

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/20/2020. Time: 09:06
 */

class TestPresenter(
    private val view: TestContract.View,
    private val model: TestContract.Model,
    private val category: String
) : TestContract.Presenter {

    private var checked = -1
    private var questions = model.getAllByCategory(category)
    private var currentQuestion = -1
    private var countCorrect = 0

    override fun clickVariant(position: Int) {
        if (checked == position)
            return
        if (checked != -1) {
            view.changeChecked(checked, false)
        }
        checked = position
        view.changeChecked(checked, true)
    }

    override fun clickBack() {
        view.back()
    }

    override fun clickHome() {
        view.checkResult()
    }

    override fun clickNext() {
        if (checked == -1) {
            view.showMessage("You must choose one answer")
        } else {
            if (currentQuestion + 1 < questions.size) {
                questions[currentQuestion].checked = checked
                val correctAns = questions[currentQuestion].answer
                val selectedAns = when (checked) {
                    0 -> questions[currentQuestion].variant1
                    1 -> questions[currentQuestion].variant2
                    2 -> questions[currentQuestion].variant3
                    else -> questions[currentQuestion].variant4
                }
                if (correctAns == selectedAns) {
                    countCorrect++
                    view.showMessage("Correct")
                } else {
                    view.showMessage("Incorrect")
                }
                loadDataToView()
            } else {
                view.showMessage("Tugadi)")
            }
        }
    }

    override fun clickPrevious() {
        if (currentQuestion > 0) {
            loadDataToViewDown()
            checked = questions[currentQuestion].checked
        } else {
            view.showMessage("You are at the first question !!!")
        }
    }

    override fun showResultWindow() {
        if (checked != -1) {
            questions[currentQuestion].checked = checked
            val correctAns = questions[currentQuestion].answer
            val selectedAns = when (checked) {
                0 -> questions[currentQuestion].variant1
                1 -> questions[currentQuestion].variant2
                2 -> questions[currentQuestion].variant3
                else -> questions[currentQuestion].variant4
            }
            if (correctAns == selectedAns) {
                countCorrect++
            }
        }
        val corrects = countCorrect
        var solved = 0
        for (i in questions.indices) {
            if (questions[i].checked != -1) {
                solved++
            }
        }
        val all = questions.size
        view.showResult(all, solved, corrects)
    }

    override fun closeFragment() {
        view.closeFragment()
    }

    fun loadDataToView() {
        currentQuestion++
        val test = questions[currentQuestion]
        view.putData(test)
        checked = test.checked
        if (checked != -1) {
            view.setChecked(checked)
        }
    }

    fun loadDataToViewsFromBeginning() {
        currentQuestion = 0
        countCorrect = 0
        val test = questions[currentQuestion]
        view.putData(test)
        checked = -1
        questions.forEach { it.checked = -1 }
    }

    private fun loadDataToViewDown() {
        currentQuestion--
        val test = questions[currentQuestion]
        view.putData(test)
        view.setChecked(test.checked)
    }
}