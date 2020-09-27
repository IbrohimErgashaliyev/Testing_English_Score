package android.dev_company.ui.fragments

import android.dev_company.R
import android.dev_company.data.models.CategoryData
import android.dev_company.data.models.GrammarTestData
import android.dev_company.ui.adapters.CategoryAdapter
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
                "you can find some grammar details from this section.",
                R.drawable.grammar,
                Color.parseColor("#45a123")
            )
        )
        categories.add(
            GrammarTestData(
                "Test",
                "Test your english in order to know your current result.",
                R.drawable.test,
                Color.parseColor("#ac1ac8")
            )
        )
        categories.add(
            GrammarTestData(
                "Instruction",
                "Here you can find guideline how to use this application directly.",
                R.drawable.grammar,
                Color.parseColor("#2ad618")
            )
        )
        categories.add(
            GrammarTestData(
                "About",
                "About window",
                R.drawable.test,
                Color.parseColor("#ac8ac1")
            )
        )
        categories.add(
            GrammarTestData(
                "Instruction",
                "Here you can find guideline how to use this application directly.",
                R.drawable.grammar,
                Color.parseColor("#2ad618")
            )
        )
        categories.add(
            GrammarTestData(
                "About",
                "About window",
                R.drawable.test,
                Color.parseColor("#ac8ac1")
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = CategoryAdapter(categories)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(context)
        adapter.setOnClickListener {
            Toast.makeText(context, "$it", Toast.LENGTH_SHORT).show()
            when(it){
                0 -> {
                    fragmentManager?.beginTransaction()
                        ?.addToBackStack("choose window")
                        ?.replace(R.id.containerLayer, FragmentGrammarCategory())
                        ?.commit()
                }
                1 -> {
                    fragmentManager?.beginTransaction()
                        ?.replace(R.id.containerLayer, FragmentTestCategory())
                        ?.addToBackStack("choose window")
                        ?.commit()
                }
            }
        }
    }
}