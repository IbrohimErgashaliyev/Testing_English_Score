package android.dev_company.ui.adapters

import android.dev_company.R
import android.dev_company.data.models.CategoryData
import android.dev_company.utils.extensions.inflate
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_grammar_data.view.*

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/21/2020. Time: 16:44
 */

class MainAdapter(private val ls: List<CategoryData>): RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    private var onClickGrammarCategory: ((CategoryData) -> Unit)? = null
    fun setOnClickGrammarCategory(f: (CategoryData) -> Unit){
        onClickGrammarCategory = f
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_grammar_data)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()

    override fun getItemCount() = ls.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        init {
            itemView.apply {
                setOnClickListener {
                    onClickGrammarCategory?.invoke(ls[adapterPosition])
                    // TODO: 9/27/2020 make listener here ...
                }
            }
        }

        fun bind(){
            val d = ls[adapterPosition]
            itemView.apply {
                textName.text = d.title
                backColor.setBackgroundColor(d.backColor)
            }
        }
    }
}