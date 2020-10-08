package android.dev_company.ui.fragments

import android.dev_company.R
import android.dev_company.data.models.CategoryData
import android.dev_company.ui.adapters.SubCategAdapter
import android.dev_company.utils.GrammarCategories.PRONOUNS
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.sub_categ_grammar_fragment.*

/**
 * Created by Ibrohim Ergashaliyev on 08.10.2020.
 */

class SubCategoryGrammarFragment: Fragment(R.layout.sub_categ_grammar_fragment){

    val data = ArrayList<CategoryData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("AAA", "onViewCreated")

        val category = arguments?.getString("MESSAGE", "")
        when(category){
            PRONOUNS -> { loadPronouns(); arguments?.putString("MESSAGE", "Pronouns") }
            else -> {
                // todo other data to load ...
            }
        }
        textTitle.text = category
        val adapter = SubCategAdapter(data)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(context)
        adapter.setOnClickListener {
            var url = it.title.replace(" ", "_").toLowerCase().trim()
            val fr = WebViewFragment("$url.html")
            val bundle = arguments ?: Bundle()
            fr.arguments = bundle
            fragmentManager?.beginTransaction()
                ?.replace(R.id.containerLayer, fr)
                ?.addToBackStack("web_view_page")
                ?.commit()
        }

        buttonBack.setOnClickListener { fragmentManager?.popBackStack() }
    }

    private fun loadPronouns(){
        data.clear()
        data.add(CategoryData("Personal Pronouns"))
        data.add(CategoryData("It and There"))
        data.add(CategoryData("Demonstratives"))
        data.add(CategoryData("One and Ones"))
        data.add(CategoryData("Pronouns in Questions"))
        data.add(CategoryData("Reflexive Pronouns"))
        data.add(CategoryData("Reciprocal Pronouns"))
        data.add(CategoryData("Indefinite Pronouns"))
        data.add(CategoryData("Relative pronouns and Relative clauses"))
    }
}