package android.dev_company.ui.dialogs

import android.content.Context
import android.dev_company.R
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/20/2020. Time: 19:15
 */

class DialogBack(context: Context) {

    private var onClickConfirm: (() -> Unit)? = null
    fun setOnClickConfirm(f: () -> Unit){
        onClickConfirm = f
    }

    private val builder = AlertDialog.Builder(context)
    private var dialog = builder.create()

    init {
        dialog = builder
            .setNegativeButton("No") { dialog, which ->
                dismiss()
            }
            .setPositiveButton("Yes"){dialog, which ->
                onClickConfirm?.invoke()
                dismiss()
            }.create()
    }

    fun setDialogDetails(t: String, m: String){
        dialog.apply {
            setTitle(t)
            setMessage(m)
        }
    }

    fun show(){
        dialog.show()
    }

    fun dismiss(){
        dialog.dismiss()
    }
}