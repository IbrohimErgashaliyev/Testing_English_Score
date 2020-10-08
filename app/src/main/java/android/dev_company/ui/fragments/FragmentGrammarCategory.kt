package android.dev_company.ui.fragments

import android.dev_company.R
import android.dev_company.data.models.CategoryData
import android.dev_company.ui.adapters.MainAdapter
import android.dev_company.utils.GrammarCategories.ADJECTIVES
import android.dev_company.utils.GrammarCategories.ADVERBIALS
import android.dev_company.utils.GrammarCategories.Determiners_and_Quantifiers
import android.dev_company.utils.GrammarCategories.NOUNS
import android.dev_company.utils.GrammarCategories.POSSESSIVES
import android.dev_company.utils.GrammarCategories.PRONOUNS
import android.dev_company.utils.GrammarCategories.VERBS
import android.dev_company.utils.extensions.setDivider
import android.os.Bundle
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
        categories.add(CategoryData(PRONOUNS))
        categories.add(CategoryData(Determiners_and_Quantifiers))
        categories.add(CategoryData(POSSESSIVES))
        categories.add(CategoryData(ADJECTIVES))
        categories.add(CategoryData(ADVERBIALS))
        categories.add(CategoryData(NOUNS))
        categories.add(CategoryData(VERBS))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = MainAdapter(categories)

        list.adapter = adapter
        list.setDivider(R.drawable.recycler_view_divider)
        list.layoutManager = LinearLayoutManager(context)
        buttonBack.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        adapter.setOnClickGrammarCategory { it, adapterPosition ->
            val fr = SubCategoryGrammarFragment()
            val bundle = arguments ?: Bundle()
            bundle.putString("MESSAGE", it.title)
            fr.arguments = bundle
            fragmentManager?.beginTransaction()
                ?.replace(R.id.containerLayer, fr)
                ?.addToBackStack("sub_categ_page")
                ?.commit()
        }
    }
}