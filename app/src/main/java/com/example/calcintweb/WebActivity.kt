package com.example.calcintweb

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi

class WebActivity : AppCompatActivity() {
    lateinit var web:WebView
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        web=findViewById(R.id.webb)
        webview()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webview(){
        web.webViewClient= WebViewClient()
        web.apply {
            loadUrl("https://www.google.com/")
            settings.javaScriptEnabled=true
            settings.safeBrowsingEnabled=true
        }
    }

    override fun onBackPressed() {
        if (web.canGoBack())web.goBack()else
        super.onBackPressed()
    }
}