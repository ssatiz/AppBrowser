package satiz.browser

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView

class AppBrowser: AppCompatActivity(), AppBrowserView {

    private var browserView: WebView? = null

    companion object {
        const val KEY_URL_TO_LOAD = "url_to_load"
        const val KEY_ENABLE_JAVA_SCRIPT = "enable_java_script"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_satiz_browser)

        browserView = findViewById(R.id.browserView)
        setupBrowser()
        parseIntentData()
    }

    override fun parseIntentData() {

        intent ?: return
        intent.extras ?: return

        val urlToLoad = if (intent.extras.containsKey(KEY_URL_TO_LOAD)) intent.extras.getString(KEY_URL_TO_LOAD) else ""
        browserView?.loadUrl(urlToLoad)
        val canJavaScriptEnable =  if (intent.extras.containsKey(KEY_ENABLE_JAVA_SCRIPT)) intent.extras.getBoolean(KEY_ENABLE_JAVA_SCRIPT) else false
        browserView?.settings?.javaScriptEnabled = canJavaScriptEnable
    }

    override fun setupBrowser() {
        browserView?.settings?.loadWithOverviewMode = true
        browserView?.settings?.setSupportZoom(true)
        browserView?.settings?.useWideViewPort = true
    }

}