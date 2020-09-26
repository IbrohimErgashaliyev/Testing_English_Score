package android.dev_company.ui.screens

import android.dev_company.R
import android.dev_company.ui.fragments.ChooseTestGrammarFragment
import android.dev_company.ui.fragments.IntoFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = IntoFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.containerLayer, ChooseTestGrammarFragment())
        //transaction.addToBackStack("first_fragment")
        transaction.commit()

    }
}