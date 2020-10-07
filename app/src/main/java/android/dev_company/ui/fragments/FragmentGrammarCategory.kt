package android.dev_company.ui.fragments

import android.dev_company.R
import android.dev_company.data.models.CategoryData
import android.dev_company.ui.adapters.MainAdapter
import android.dev_company.utils.extensions.setDivider
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/21/2020. Time: 13:18
 */

class FragmentGrammarCategory(): Fragment(R.layout.fragment_main){

    private val categories = ArrayList<CategoryData>()

    init {
        categories.add(CategoryData("Present tenses", R.drawable.back1))
        categories.add(CategoryData("Past tenses", R.drawable.back2))
        categories.add(CategoryData("Future tenses", R.drawable.back1))
        categories.add(CategoryData("Prepositions", R.drawable.back2))
        categories.add(CategoryData("Continuous tenses", R.drawable.back1))
        categories.add(CategoryData("For/Since", R.drawable.back2))
        categories.add(CategoryData("Passive voice", R.drawable.back1))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = MainAdapter(categories)

        list.adapter = adapter
        list.setDivider(R.drawable.recycler_view_divider)
        list.layoutManager = LinearLayoutManager(context)
        buttonBack.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        adapter.setOnClickGrammarCategory {
//            val fr =
        }
    }
}