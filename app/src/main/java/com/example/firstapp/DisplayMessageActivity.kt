package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView

class DisplayMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val myWebView: WebView = findViewById(R.id.webView)
        myWebView.webViewClient = WebViewClient()
        val url = intent.getStringExtra(EXTRA_MESSAGE)
        val fullUrl = "https://www.$url"
        myWebView.loadUrl(fullUrl)
    }
}
