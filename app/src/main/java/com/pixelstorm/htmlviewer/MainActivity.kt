package com.pixelstorm.htmlviewer

import android.app.Activity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val webView = WebView(this)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.allowFileAccess = false
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()
        setContentView(webView)
        if (savedInstanceState == null) {
            webView.loadUrl("file:///android_asset/index.html")
        } else {
            webView.restoreState(savedInstanceState)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        (window.decorView.findViewById<WebView>(android.R.id.content))?.saveState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onBackPressed() {
        val webView = (window.decorView.findViewById<WebView>(android.R.id.content))
        if (webView != null && webView.canGoBack()) webView.goBack() else super.onBackPressed()
    }
}
