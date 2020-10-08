package android.dev_company.utils.extensions

import androidx.annotation.ColorRes
import androidx.fragment.app.Fragment

/**
 * Created by Ibrohim Ergashaliyev on 08.10.2020.
 */

fun Fragment.changeStatusBarColor(color: Int){
    activity?.window?.statusBarColor = color
}

fun Fragment.changeNavigationBarColor(color: Int){
    activity?.window?.navigationBarColor = color
}