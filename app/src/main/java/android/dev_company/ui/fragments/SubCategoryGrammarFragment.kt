package android.dev_company.ui.fragments

import android.dev_company.R
import android.dev_company.data.models.CategoryData
import android.dev_company.ui.adapters.SubCategAdapter
import android.dev_company.utils.GrammarCategories
import android.dev_company.utils.extensions.changeStatusBarColor
import android.dev_company.utils.extensions.setDivider
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.sub_categ_grammar_fragment.*

/**
 * Created by Ibrohim Ergashaliyev on 08.10.2020.
 */

class SubCategoryGrammarFragment: Fragment(R.layout.sub_categ_grammar_fragment){

    val data = ArrayList<CategoryData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("AAA", "onviewcreated")
        changeStatusBarColor(Color.parseColor("#F024263B"))

        val category = arguments?.getString("MESSAGE", "")
        when(category){
            GrammarCategories.PRONOUNS -> loadPronouns()
            GrammarCategories.Determiners_and_Quantifiers -> loadDeterminesAndQuantifiers()
            GrammarCategories.POSSESSIVES -> loadPossessives()
            GrammarCategories.ADJECTIVES -> loadAdjectives()
            GrammarCategories.ADVERBIALS -> loadAdverbials()
            else -> {
                // todo other data to load ...
            }
        }
        arguments?.putString("MESSAGE", category?.toLowerCase())
        textTitle.text = category
        val adapter = SubCategAdapter(data)
        list.adapter = adapter
        list.setDivider(R.drawable.recycler_view_divider)
        list.layoutManager = LinearLayoutManager(context)
        adapter.setOnClickListener {
            var url = it.title.replace(" ", "_").toLowerCase().trim()
            val fr = WebViewFragment("$url.html")
            val bundle = arguments ?: Bundle()
            bundle.putString("TITLE", it.title)
            fr.arguments = bundle
            fragmentManager?.beginTransaction()
                ?.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit)
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

    private fun loadDeterminesAndQuantifiers(){
        data.add(CategoryData("Specific and general determiners"))
        data.add(CategoryData("The indefinite article"))
        data.add(CategoryData("The indefinite article 2"))
        data.add(CategoryData("Interrogative determiners"))
        data.add(CategoryData("Quantifiers"))
    }

    private fun loadPossessives(){
        data.add(CategoryData("Possessive nouns"))
        data.add(CategoryData("Possessive adjectives"))
        data.add(CategoryData("Possessive pronouns"))
        data.add(CategoryData("Possessive questions"))
        data.add(CategoryData("Possessive reciprocal pronouns"))
    }

    private fun loadAdjectives(){
        data.add(CategoryData("Where adjectives go in a sentence"))
        data.add(CategoryData("Adjectives with ing and ed"))
        data.add(CategoryData("Adjective order"))
        data.add(CategoryData("Comparative and superlative adverbs"))
        data.add(CategoryData("Intensifiers"))
        data.add(CategoryData("Mitigators"))
        data.add(CategoryData("Noun modifiers"))
    }

    private fun loadAdverbials(){
        data.add(CategoryData("How we make adverbials"))
        data.add(CategoryData("Where adverbials go in a sentence"))
        data.add(CategoryData("Adverbials of manner"))
        data.add(CategoryData("Intensifiers and mitigators"))
        data.add(CategoryData("Adverbials of place"))
        data.add(CategoryData("Adverbials of location"))
        data.add(CategoryData("Adverbials of direction"))
        data.add(CategoryData("Adverbials of distance"))
        data.add(CategoryData("Adverbials of time"))
        data.add(CategoryData("Adverbials of time(when)"))
        data.add(CategoryData("Adverbials of time(how long)"))
        data.add(CategoryData("Adverbials of time(how often)"))
        data.add(CategoryData("Still and no longer Already and yet"))
        data.add(CategoryData("Adverbials of probability"))
        data.add(CategoryData("Comparative and superlative adverbs"))
    }
}