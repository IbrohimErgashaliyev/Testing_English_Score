package android.dev_company.ui.adapters

import android.dev_company.R
import android.dev_company.data.models.EntryData
import android.dev_company.utils.extensions.inflate
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view_entry.view.*

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/18/2020. Time: 23:27
 */

class EntryAdapter(val data: List<EntryData>): RecyclerView.Adapter<EntryAdapter.ViewHolder>(){

    private var itemClicked: ((EntryData) -> Unit)? = null
    fun setItemClicked(f: (EntryData) -> Unit){
        itemClicked = f
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_view_entry)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()

    override fun getItemCount() = data.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        init {
            itemView.apply {
                setOnClickListener { itemClicked?.invoke(data[adapterPosition]) }
            }
        }
        fun bind(){
            val d = data[adapterPosition]
            itemView.apply {
                image.setImageResource(d.icon)
                textName.text = d.name
                //textName.setTextColor(d.textColor)
                imageStar.setImageResource(if(d.hasLiked) R.drawable.ic_baseline_star_24 else R.drawable.ic_baseline_star_border_24)
            }
        }
    }
}