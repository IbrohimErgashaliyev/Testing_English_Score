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
        categories.add(CategoryData("Present tenses", Color.parseColor("#465acd")))
        categories.add(CategoryData("Past tenses", Color.parseColor("#761495")))
        categories.add(CategoryData("Future tenses", Color.parseColor("#a46c10")))
        categories.add(CategoryData("Prepositions", Color.parseColor("#9ad80d")))
        categories.add(CategoryData("Continuous tenses", Color.parseColor("#ada5ca")))
        categories.add(CategoryData("For/Since", Color.parseColor("#ddd222")))
        categories.add(CategoryData("Passive voice", Color.parseColor("#1199cc")))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = MainAdapter(categories)

        list.adapter = adapter
        list.setDivider(R.drawable.recycler_view_divider)
        list.layoutManager = LinearLayoutManager(context)
        buttonBack.setOnClickListener {
            fragmentManager?.popBackStack()
        }
    }
}