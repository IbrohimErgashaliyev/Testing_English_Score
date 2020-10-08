package android.dev_company.ui.adapters

import android.dev_company.R
import android.dev_company.data.models.CategoryData
import android.dev_company.ui.fragments.SubCategoryGrammarFragment
import android.dev_company.ui.fragments.WebViewFragment
import android.dev_company.utils.extensions.inflate
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_sub_categ_data.view.*

/**
 * Created by Ibrohim Ergashaliyev on 08.10.2020.
 */

class SubCategAdapter(val data: List<CategoryData>): RecyclerView.Adapter<SubCategAdapter.ViewHolder>(){

    private var onClickListener: ((CategoryData) -> Unit)? = null
    fun setOnClickListener(f: (CategoryData) -> Unit){
        onClickListener = f
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_sub_categ_data)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()

    override fun getItemCount() = data.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        init {
            itemView.setOnClickListener {
                onClickListener?.invoke(data[adapterPosition])
            }
        }

        fun bind(){
            val d = data[adapterPosition]
            itemView.apply {
                textSubCateg.text = d.title
            }
        }
    }
}