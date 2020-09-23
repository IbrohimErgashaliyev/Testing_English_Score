package android.dev_company.ui.dialogs

import android.content.Context
import android.dev_company.R
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.dialog_result.view.*

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/20/2020. Time: 22:50
 */

class DialogResult(context: Context){

    private var onClickHomeButton: (() -> Unit)? = null
    fun setOnClickHomeButton(f: () -> Unit){
        onClickHomeButton = f
    }

    private var onClickRepeatButton: (() -> Unit)? = null
    fun setOnClickRepeatButton(f: () -> Unit){
        onClickRepeatButton = f
    }

    private var view: View =
        LayoutInflater.from(context).inflate(R.layout.dialog_result, null, false)

    private val dialog = AlertDialog.Builder(context)
        .setView(view)
        .setCancelable(false)
        .create()

    init {

        view.apply {
            buttonHome.setOnClickListener { onClickHomeButton?.invoke(); dismiss() }
            buttonRepeat.setOnClickListener { onClickRepeatButton?.invoke(); dismiss() }
        }
    }

    fun setResults(corrects: Int, solved: Int, all: Int){
        view.apply {
            textCorrects.text = "$corrects"
            textSolved.text = "$solved"
            textAll.text = "$all"
        }
    }

    fun show(){
        dialog.show()
    }

    fun dismiss(){
        dialog.dismiss()
    }
}