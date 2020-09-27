package android.dev_company.ui.screens

import android.dev_company.R
import android.dev_company.ui.fragments.ChooseTestGrammarFragment
import android.dev_company.ui.fragments.IntoFragment
import android.dev_company.utils.extensions.changeNavigationBarColor
import android.dev_company.utils.extensions.changeStatusBarColor
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //hideStatusBar()
        val firstFragment = IntoFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.containerLayer, ChooseTestGrammarFragment())
        //transaction.addToBackStack("first_fragment")
        transaction.commit()

        changeNavigationBarColor(Color.parseColor("#AD000000"))
        changeStatusBarColor(Color.parseColor("#AD000000"))
    }

    fun hideStatusBar(){
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

    fun showStatusBar(){
        window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

    override fun onBackPressed() {
        // TODO: 9/27/2020
        super.onBackPressed()
    }
}