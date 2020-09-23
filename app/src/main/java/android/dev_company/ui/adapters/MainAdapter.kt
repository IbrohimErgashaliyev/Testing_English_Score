package android.dev_company.ui.adapters

import android.dev_company.R
import android.dev_company.data.models.CategoryData
import android.dev_company.utils.extensions.inflate
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_fragment_main.view.*

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/21/2020. Time: 16:44
 */

class MainAdapter(private val ls: List<CategoryData>): RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_fragment_main)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()

    override fun getItemCount() = ls.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        init {
            itemView.apply {
                buttonLiked.setOnClickListener {
                    if ( ls[adapterPosition].liked ) {
                        buttonLiked.setImageResource(R.drawable.ic_star_uncheck)
                        ls[adapterPosition].liked = false
                    } else {
                        buttonLiked.setImageResource(R.drawable.ic_stars_check)
                        ls[adapterPosition].liked = true
                    }
                }
            }
        }

        fun bind(){
            val d = ls[adapterPosition]
            itemView.apply {
                imageCategory.setImageResource(d.img)
                textTitle.text = d.title
                textDesc.text = d.desc
                colorBackground.setBackgroundColor(d.backColor)
                textBeingTime.text = "${d.beingTime}"
                textScore.text = "${d.score}"
                textContent.text = "${d.numberContent}"
                buttonLiked.setImageResource(
                    if ( d.liked ) R.drawable.ic_stars_check else R.drawable.ic_star_uncheck
                )
            }
        }
    }
}