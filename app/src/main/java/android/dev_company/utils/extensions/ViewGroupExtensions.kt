package android.dev_company.utils.extensions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/18/2020. Time: 16:43
 */

fun ViewGroup.inflate(@LayoutRes resId: Int) = LayoutInflater.from(context).inflate(resId, this, false)