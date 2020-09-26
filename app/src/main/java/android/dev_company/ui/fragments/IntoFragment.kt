package android.dev_company.ui.fragments

import android.dev_company.R
import android.dev_company.data.local.SharedPreference
import android.dev_company.data.models.ViewDataInto
import android.dev_company.ui.adapters.IntoViewAdapter
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/18/2020. Time: 16:42
 */

class IntoFragment : Fragment() {

    private val views = ArrayList<ViewDataInto>()
    private val instance = SharedPreference.instance

    init {
        views.add(
            ViewDataInto(
                R.drawable.ic_baseline_school_24,
                Color.parseColor("#46723a"),
                "Abror",
                "Abrorni yoshligi u juda ham yosh edi."
            )
        )
        views.add(
            ViewDataInto(
                R.drawable.ic_baseline_school_24,
                Color.parseColor("#adc423"),
                "Nodir",
                "Abrorni yoshligi u juda ham yosh edi."
            )
        )
        views.add(
            ViewDataInto(
                R.drawable.ic_baseline_school_24,
                Color.parseColor("#c456a1"),
                "Malika",
                "Abrorni yoshligi u juda ham yosh edi."
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (instance.isOpenedIntoBefore){
            fragmentManager?.beginTransaction()
                ?.add(R.id.containerLayer, FragmentTestCategory())
                ?.commit()
        }
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = IntoViewAdapter(views)
        pager.adapter = adapter
        pager.registerOnPageChangeCallback(pagerCallbackListener)
        buttonNext.setOnClickListener {
            Log.d("AAA", "${pager.currentItem}")
            if ( pager.currentItem != 2 ){
                pager.setCurrentItem(pager.currentItem+1, true)
            }else{
                instance.isOpenedIntoBefore = true
                fragmentManager?.beginTransaction()
                    ?.add(R.id.containerLayer, FragmentTestCategory())
                    ?.commit()
            }
        }
    }

    private val pagerCallbackListener = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {

        }
    }
}