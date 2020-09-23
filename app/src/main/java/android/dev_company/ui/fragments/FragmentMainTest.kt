package android.dev_company.ui.fragments

import android.dev_company.R
import android.dev_company.data.models.EntryData
import android.dev_company.ui.adapters.EntryAdapter
import android.dev_company.utils.*
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_main_test.view.*

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/18/2020. Time: 23:14
 */

class FragmentMainTest: Fragment(){

    private val data = ArrayList<EntryData>()
    private val adapter = EntryAdapter(data)
    init {
        data.add(EntryData(BEGINNER, R.drawable.ic_baseline_school_24, Color.parseColor("#67da12"), true))
        data.add(EntryData(ELEMENTARY, R.drawable.ic_baseline_school_24, Color.parseColor("#67da12"), true))
        data.add(EntryData(PRE_INTERMEDIATE, R.drawable.ic_baseline_school_24, Color.parseColor("#67da12")))
        data.add(EntryData(INTERMEDIATE, R.drawable.ic_baseline_school_24, Color.parseColor("#67da12")))
        data.add(EntryData(UPPER_INTERMEDIATE, R.drawable.ic_baseline_school_24, Color.parseColor("#67da12")))
        data.add(EntryData(ADVANCED, R.drawable.ic_baseline_school_24, Color.parseColor("#67da12"), true))
        data.add(EntryData(IELTS_FOUNDATION, R.drawable.ic_baseline_school_24, Color.parseColor("#67da12"), true))
        data.add(EntryData(IELTS_GRADUATION, R.drawable.ic_baseline_school_24, Color.parseColor("#67da12"), true))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_test, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.apply {
            list.adapter = adapter
            list.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        }

        adapter.setItemClicked {
            val fr = TestFragment(it.name)
            val f = FragmentMain()
            val b = Bundle()
            b.putString("NAME", it.name)
            fr.arguments = b
            fragmentManager?.beginTransaction()
                ?.replace(R.id.containerLayer, f)
                ?.addToBackStack("test fragment")
                ?.commit()
        }
    }
}