package android.dev_company.ui.fragments

import android.dev_company.R
import android.dev_company.data.models.CategoryData
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.web_view_layout.*

class WebViewFragment(private val url: String): Fragment(R.layout.web_view_layout){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val message = arguments?.getString("MESSAGE", "NULL")
        textTitle.text = message
        var baseUrl = "file:///android_asset/${message?.toLowerCase()}/$url"
        //baseUrl = baseUrl.replace(" ", "")
        Log.d("AAA", "$baseUrl")
        Log.d("AAA", "$message")
        webView.loadUrl(baseUrl)
        buttonBack.setOnClickListener { fragmentManager?.popBackStack() }
    }
}