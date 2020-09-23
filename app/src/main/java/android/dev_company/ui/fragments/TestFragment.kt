package android.dev_company.ui.fragments

import android.dev_company.R
import android.dev_company.contracts.TestContract
import android.dev_company.data.local.room.entities.TestData
import android.dev_company.repositories.TestRepository
import android.dev_company.ui.dialogs.DialogBack
import android.dev_company.ui.dialogs.DialogResult
import android.dev_company.ui.presenters.TestPresenter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.get
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_test.view.*

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/19/2020. Time: 10:31
 */

class TestFragment(category: String) : Fragment(), TestContract.View {

    private lateinit var category: String
    private val presenter by lazy { TestPresenter(this, TestRepository(), category) }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_test, container, false)
        view.apply {
            val bundle = arguments
            val name = bundle?.getString("NAME")!!
            category = name
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.loadDataToView()
        view.apply {
            for (i in 0 until 4) {
                val view = (buttonAnswers[i] as CardView)[0] as ViewGroup
                view.setOnClickListener {
                    presenter.clickVariant(i)
                }
            }
            buttonNext.setOnClickListener { presenter.clickNext() }
            buttonPrevious.setOnClickListener { presenter.clickPrevious() }
            buttonBack.setOnClickListener {
                presenter.clickBack()
            }
            buttonHome.setOnClickListener { presenter.clickHome() }
        }
    }

    override fun putData(testData: TestData) {
        view?.apply {
            textQuestion.text = testData.question

            (((buttonAnswers[0] as CardView)[0] as ViewGroup)[2] as TextView).text =
                testData.variant1
            (((buttonAnswers[1] as CardView)[0] as ViewGroup)[2] as TextView).text =
                testData.variant2
            (((buttonAnswers[2] as CardView)[0] as ViewGroup)[2] as TextView).text =
                testData.variant3
            (((buttonAnswers[3] as CardView)[0] as ViewGroup)[2] as TextView).text =
                testData.variant4

            for (i in 0 until 4) {
                (((buttonAnswers[i] as CardView)[0] as ViewGroup)[0] as ImageView).setImageResource(
                    R.drawable.ic_baseline_radio_button_unchecked_24
                )
            }
        }
    }

    override fun changeChecked(position: Int, t: Boolean) {
        view?.apply {
            val imageView =
                (((buttonAnswers[position] as CardView)[0] as ViewGroup)[0] as ImageView)
            imageView.setImageResource(
                if (t) R.drawable.ic_baseline_radio_button_checked_24 else R.drawable.ic_baseline_radio_button_unchecked_24
            )
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun setChecked(position: Int) {
        view?.apply {
            (((buttonAnswers[position] as CardView)[0] as ViewGroup)[0] as ImageView).setImageResource(
                R.drawable.ic_baseline_radio_button_checked_24
            )
        }
    }

    override fun back() {
        val dialog = DialogBack(context!!)
        dialog.setDialogDetails("Warning!!!", "Are you sure to leave us ?")
        dialog.show()
        dialog.setOnClickConfirm { presenter.closeFragment() }
    }

    override fun checkResult() {
        val dialog = DialogBack(context!!)
        dialog.setDialogDetails("Warning", "Are you sure to check your current test result ?")
        dialog.show()
        dialog.setOnClickConfirm {
            presenter.showResultWindow()
        }
    }

    override fun showResult(allTests: Int, solvedTests: Int, correctTests: Int) {
        val dialog = DialogResult(context!!)
        dialog.setResults(correctTests, solvedTests, allTests)
        dialog.setOnClickRepeatButton { presenter.loadDataToViewsFromBeginning() }
        dialog.setOnClickHomeButton { presenter.closeFragment() }
        dialog.show()
    }

    override fun closeFragment() {
        fragmentManager?.popBackStack()
    }
}
