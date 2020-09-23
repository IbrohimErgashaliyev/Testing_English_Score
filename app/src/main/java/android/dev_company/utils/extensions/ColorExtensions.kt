package android.dev_company.utils.extensions

import android.graphics.Color

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/18/2020. Time: 19:08
 */

fun Int.toDarkerColor(): Int{
    val hsv = FloatArray(3)
    Color.colorToHSV(this, hsv)
    hsv[2] *= 0.6f
    return Color.HSVToColor(hsv)
}