package android.dev_company.ui.fragments

import android.dev_company.R
import android.dev_company.data.models.GrammarTestData
import android.dev_company.ui.adapters.CategoryAdapter
import android.dev_company.utils.extensions.changeStatusBarColor
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_choose.*

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/24/2020. Time: 20:01
 */

class ChooseTestGrammarFragment : Fragment(R.layout.fragment_choose) {

    private val categories = ArrayList<GrammarTestData>()
    init {
        categories.add(
            GrammarTestData(
                "Grammar",
                "you can find some grammar1 details from this section.",
                R.drawable.grammar1,
                Color.parseColor("#03A9F4")
            )
        )
        categories.add(
            GrammarTestData(
                "Test",
                "Test your english in order to know your current result.",
                R.drawable.test,
                Color.parseColor("#26C6DA")
            )
        )
        categories.add(
            GrammarTestData(
                "Instruction",
                "Here you can find guideline how to use this application directly.",
                R.drawable.guideline,
                Color.parseColor("#00E5FF")
            )
        )
        categories.add(
            GrammarTestData(
                "About",
                "About window",
                R.drawable.about,
                Color.parseColor("#00E676")
            )
        )
        categories.add(
            GrammarTestData(
                "Settings",
                "Here you can proper some details to make them to be convenient for you.",
                R.drawable.settings,
                Color.parseColor("#a5619d")
            )
        )
        categories.add(
            GrammarTestData(
                "Exit",
                "Here you can find guideline how to use this application directly.",
                R.drawable.ic_exit,
                Color.parseColor("#E65100")
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        changeStatusBarColor(Color.parseColor("#318BCF"))
        val adapter = CategoryAdapter(categories)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(context)
        adapter.setOnClickListener {
            when(it){
                0 -> {
                    startFragment(FragmentGrammarCategory())
                }
                1 -> {
                    startFragment(FragmentTestCategory())
                }
                5 -> {
                    activity?.finish()
                }
            }
        }
    }

    private fun startFragment(fr: Fragment){
        fragmentManager?.beginTransaction()
            ?.addToBackStack("choose test or grammar")
            ?.replace(R.id.containerLayer, fr)
            ?.commit()
    }
}