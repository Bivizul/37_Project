@file:Suppress("DEPRECATION")

package aaa.bivizul.a37project.android

import aaa.bivizul.a37project.domain.util.Howdoecon.HOWDOEDOR
import aaa.bivizul.a37project.domain.util.Howdoecon.HOWDOEKOR
import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.activity.ComponentActivity

class HowdoeActivity : ComponentActivity() {

    private lateinit var howdoewv: WebView
    var filePathCallback: ValueCallback<Array<Uri>>? = null
    private val REQUEST_CODE = 100

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_howdoe)

        howdoewv = findViewById(R.id.howdoewv)
        howdoewv.webViewClient = WebViewClient()

        howdoewv.webChromeClient = MyChromeClient()
        howdoewv.scrollBarStyle = WebView.SCROLLBARS_OUTSIDE_OVERLAY
        howdoewv.isScrollbarFadingEnabled = false

        setSettings()

        val howdoeurl = intent.getStringExtra(HOWDOEKOR) ?: HOWDOEDOR

        if (savedInstanceState == null) {
            howdoewv.post {
                kotlin.run { howdoewv.loadUrl(howdoeurl) }
            }
        }

        howdoewv.canGoBack()
        howdoewv.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK &&
                event.action == MotionEvent.ACTION_UP &&
                howdoewv.canGoBack()
            ) {
                howdoewv.goBack()
                return@OnKeyListener true
            }
            false
        })
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setSettings() {
        val howdoews = howdoewv.settings
        howdoews.javaScriptEnabled = true
        howdoews.loadWithOverviewMode = true
        howdoews.allowFileAccess = true
        howdoews.domStorageEnabled = true
        howdoews.builtInZoomControls = true
        howdoews.displayZoomControls = false
        howdoews.useWideViewPort = true
        howdoews.setSupportZoom(true)
        howdoews.userAgentString = howdoews.userAgentString.replace("; wv", "")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        howdoewv.saveState(outState)
    }

    inner class MyChromeClient : WebChromeClient() {

        override fun onShowFileChooser(
            view: WebView,
            filePath: ValueCallback<Array<Uri>>,
            fileChooserParams: FileChooserParams
        ): Boolean {
            filePathCallback = filePath
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.putExtra(Intent.EXTRA_TITLE, "Image Chooser")
            startActivityForResult(intent, REQUEST_CODE)
            return true
        }


        private var howdoeCustomView: View? = null
        private var howdoeCustomViewCallback: CustomViewCallback? = null
        private var howdoeOriginalOrientation = 0
        private var howdoeOriginalSystemUiVisibility = 0

        override fun getDefaultVideoPoster(): Bitmap? {
            return if (howdoeCustomView == null) {
                null
            } else BitmapFactory.decodeResource(
                this@HowdoeActivity.applicationContext.resources,
                2130837573
            )
        }

        override fun onHideCustomView() {
            (this@HowdoeActivity.window.decorView as FrameLayout).removeView(howdoeCustomView)
            howdoeCustomView = null
            this@HowdoeActivity.window.decorView.systemUiVisibility =
                howdoeOriginalSystemUiVisibility
            this@HowdoeActivity.requestedOrientation = howdoeOriginalOrientation
            howdoeCustomViewCallback!!.onCustomViewHidden()
            howdoeCustomViewCallback = null
        }

        override fun onShowCustomView(
            paramView: View?,
            paramCustomViewCallback: CustomViewCallback?
        ) {
            if (howdoeCustomView != null) {
                onHideCustomView()
                return
            }
            howdoeCustomView = paramView
            howdoeOriginalSystemUiVisibility =
                this@HowdoeActivity.window.decorView.systemUiVisibility
            howdoeOriginalOrientation = this@HowdoeActivity.requestedOrientation!!
            howdoeCustomViewCallback = paramCustomViewCallback
            (this@HowdoeActivity.window.decorView as FrameLayout).addView(
                howdoeCustomView,
                FrameLayout.LayoutParams(-1, -1)
            )
            this@HowdoeActivity.window.decorView.systemUiVisibility =
                3846 or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == REQUEST_CODE) {
            filePathCallback!!.onReceiveValue(
                WebChromeClient.FileChooserParams.parseResult(
                    resultCode,
                    intent
                )
            )
            filePathCallback = null
        }
    }
}