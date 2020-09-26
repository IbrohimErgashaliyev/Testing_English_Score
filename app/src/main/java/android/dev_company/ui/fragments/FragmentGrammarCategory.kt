package android.dev_company.ui.fragments

import android.dev_company.R
import android.dev_company.data.models.CategoryData
import android.dev_company.ui.adapters.MainAdapter
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
        for ( i in 1 until 10 ){
            val c = CategoryData(
                "Grammar $i",
                "This is just a desc",
                R.drawable.image_profile,
                Color.parseColor("#4671ae"),
                i%2 == 0,
                10*i,
                20,
                100
            )
            categories.add(c)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = MainAdapter(categories)

        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(context)
        Log.d("AAA", "onViewCreated of MainFr")
    }
}