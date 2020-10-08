package android.dev_company.ui.adapters

import android.dev_company.R
import android.dev_company.data.models.GrammarTestData
import android.dev_company.utils.extensions.inflate
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_first_fragment.view.*

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/24/2020. Time: 20:43
 */

class CategoryAdapter(private val categories: ArrayList<GrammarTestData>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private var onClickListener: ((Int) -> Unit)? = null
    fun setOnClickListener(f: (Int) -> Unit) {
        onClickListener = f
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_first_fragment)
        //val view = parent.inflate(if (viewType == 0) R.layout.item_category_rightimage else R.layout.item_category_leftimage)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()

    override fun getItemCount() = categories.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            itemView.setOnClickListener { onClickListener?.invoke(adapterPosition) }
        }

        fun bind() {
            val d = categories[adapterPosition]
            itemView.apply {
                backColor.setBackgroundColor(d.backColor)
                imageCategory.setImageResource(d.imageURL)
                textCategory.text = d.title
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position % 2
    }
}