package android.dev_company.utils.extensions

import android.os.Build
import androidx.appcompat.app.AppCompatActivity

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/18/2020. Time: 19:13
 */

fun AppCompatActivity.changeStatusBarColor(color: Int){
    if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ){
        window.statusBarColor = color
    }
}

fun AppCompatActivity.changeNavigationBarColor(color: Int){
    if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ){
        window.navigationBarColor = color
    }
}