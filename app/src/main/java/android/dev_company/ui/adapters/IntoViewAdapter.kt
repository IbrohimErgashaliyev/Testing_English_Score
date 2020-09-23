package android.dev_company.ui.adapters

import android.dev_company.R
import android.dev_company.data.models.ViewDataInto
import android.dev_company.utils.extensions.inflate
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_into_view.view.*

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/18/2020. Time: 17:09
 */

class IntoViewAdapter(private val ls: ArrayList<ViewDataInto>): RecyclerView.Adapter<IntoViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_into_view)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()

    override fun getItemCount() = ls.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bind(){
            val d = ls[adapterPosition]
            itemView.apply {
                imageInto.setImageResource(d.imageUrl)
                colorBackground.setBackgroundColor(d.background)
                textTitle.text = d.title
                textDesc.text = d.description
            }
        }
    }
}