package android.dev_company.ui.fragments

import android.dev_company.R
import android.dev_company.data.models.EntryData
import android.dev_company.ui.adapters.EntryAdapter
import android.dev_company.ui.screens.MainActivity
import android.dev_company.utils.*
import android.dev_company.utils.extensions.changeNavigationBarColor
import android.dev_company.utils.extensions.changeStatusBarColor
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_main_test.view.*

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/18/2020. Time: 23:14
 */

class FragmentTestCategory : Fragment() {

    private val data = ArrayList<EntryData>()
    private val adapter = EntryAdapter(data)

    init {
        data.add(
            EntryData(
                BEGINNER,
                R.drawable.ic_beginner,
                Color.parseColor("#19C74B"),
                R.drawable.bg_color_beginner,
                "#29A1F4",
                true
            )
        )
        data.add(
            EntryData(
                ELEMENTARY,
                R.drawable.ic_elementary,
                Color.parseColor("#67da12"),
                R.drawable.bg_color_elementary,
                "#7C51FD",
                true
            )
        )
        data.add(
            EntryData(
                PRE_INTERMEDIATE,
                R.drawable.ic_pre_intermediate,
                Color.parseColor("#67da12"),
                R.drawable.bg_color_pre_inter,
                "#FF58E3"
            )
        )
        data.add(
            EntryData(
                INTERMEDIATE,
                R.drawable.ic_intermediate,
                Color.parseColor("#67da12"),
                R.drawable.bg_color_intermediate,
                "#FF8E47"
            )
        )
        data.add(
            EntryData(
                UPPER_INTERMEDIATE,
                R.drawable.ic_upper_indermediate,
                Color.parseColor("#67da12"),
                R.drawable.bg_color_upper_inter,
                "#4C76FB"
            )
        )
        data.add(
            EntryData(
                ADVANCED,
                R.drawable.ic_advanced,
                Color.parseColor("#67da12"),
                R.drawable.bg_color_advanced,
                "#19C74B",
                true
            )
        )
        data.add(
            EntryData(
                IELTS_FOUNDATION,
                R.drawable.ic_ielts_foundation,
                Color.parseColor("#67da12"),
                R.drawable.bg_color_beginner,
                "#29A1F4",
                true
            )
        )
        data.add(
            EntryData(
                IELTS_GRADUATION,
                R.drawable.ic_ielts_graduation,
                Color.parseColor("#67da12"),
                R.drawable.bg_color_elementary,
                "#7C51FD",
                true
            )
        )
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
        changeStatusBarColor(Color.parseColor("#F024263B"))

        view.apply {
            list.adapter = adapter
            list.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        }

        adapter.setItemClicked {
            val fr = TestFragment(it.name)
            val b = Bundle()
            b.putString("NAME", it.name)
            fr.arguments = b
            fragmentManager?.beginTransaction()
                ?.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit)
                ?.replace(R.id.containerLayer, fr)
                ?.addToBackStack("test fragment")
                ?.commit()
        }
    }

}