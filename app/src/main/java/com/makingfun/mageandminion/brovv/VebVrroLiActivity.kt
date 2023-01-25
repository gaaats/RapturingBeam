package com.makingfun.mageandminion.brovv

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.*
import android.provider.MediaStore
import android.util.Log
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.makingfun.mageandminion.R
import com.makingfun.mageandminion.apapap.SupermanClass
import com.makingfun.mageandminion.databinding.ActivityVebVrroLiBinding
import com.onesignal.OneSignal
import org.json.JSONException
import org.json.JSONObject
import java.io.File
import java.io.IOException

class VebVrroLiActivity : AppCompatActivity() {

    private val bnbnbn = 1

    private fun bobik() {
        val lolik = jgidhgjdk.settings
        lolik.javaScriptEnabled = true

        lolik.useWideViewPort = true

        lolik.loadWithOverviewMode = true
        lolik.allowFileAccess = true
        lolik.domStorageEnabled = true
        lolik.userAgentString = lolik.userAgentString.replace("; wv", "")

        lolik.javaScriptCanOpenWindowsAutomatically = true
        lolik.setSupportMultipleWindows(false)

        lolik.displayZoomControls = false
        lolik.builtInZoomControls = true
        lolik.setSupportZoom(true)

        lolik.pluginState = WebSettings.PluginState.ON
        lolik.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        lolik.setAppCacheEnabled(true)

        lolik.allowContentAccess = true
    }

    var bggbggb: ValueCallback<Array<Uri>>? = null
    lateinit var jgidhgjdk: WebView

    var urlfififif = ""
    fun vvovol(lurlurlurlurlur: String?) {
        if (!lurlurlurlurlur!!.contains("t.me")) {

            if (urlfififif == "") {
                urlfififif = getSharedPreferences(
                    "SP_WEBVIEW_PREFS",
                    AppCompatActivity.MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    lurlurlurlurlur
                ).toString()

                val cccvfc =
                    getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)
                val ededededededed = cccvfc.edit()
                ededededededed.putString("SAVED_URL", lurlurlurlurlur)
                ededededededed.apply()
            }
        }
    }

    lateinit var dededef: ActivityVebVrroLiBinding
    var kgjfhdkxf: String? = null


    private fun bbnbnko(): String {
        val ftgttg = getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)

        val hylphlyplhly = SupermanClass.link
        pussshi(SupermanClass.id)

        Log.d("lolo", "link in VebActivity is ${hylphlyplhly}")
        Log.d("lolo", "id in VebActivity is ${SupermanClass.id}")
        Log.d("lolo", "typeOfPromotion in VebActivity is ${SupermanClass.typeOfPromotion}")

        return ftgttg.getString("SAVED_URL", hylphlyplhly).toString()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dededef = ActivityVebVrroLiBinding.inflate(layoutInflater)
        setContentView(dededef.root)

        jgidhgjdk = dededef.vvvvveeevvv

        Snackbar.make(
            dededef.root, "Loading...",
            Snackbar.LENGTH_LONG
        ).show()


        val gttgththy = CookieManager.getInstance()
        gttgththy.setAcceptCookie(true)
        gttgththy.setAcceptThirdPartyCookies(jgidhgjdk, true)
        bobik()
        val ghghgh: Activity = this
        jgidhgjdk.webViewClient = object : WebViewClient() {


            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                try {
                    if (URLUtil.isNetworkUrl(url)) {
                        return false
                    }
                    if (bgbggbffff(url)) {

                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(url)
                        startActivity(intent)
                    } else {

                        Toast.makeText(
                            applicationContext,
                            "Application is not installed",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=org.telegram.messenger")
                            )
                        )
                    }
                    return true
                } catch (e: Exception) {
                    return false
                }
                view.loadUrl(url)
            }


            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                vvovol(url)
            }

            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                Toast.makeText(ghghgh, description, Toast.LENGTH_SHORT).show()
            }


        }
        jgidhgjdk.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                webView: WebView, filePathCallback: ValueCallback<Array<Uri>>,
                fileChooserParams: FileChooserParams
            ): Boolean {
                bggbggb?.onReceiveValue(null)
                bggbggb = filePathCallback
                var totya: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (totya!!.resolveActivity(packageManager) != null) {

                    var bhnhnhnhhn: File? = null
                    try {
                        bhnhnhnhhn = noka()
                        totya.putExtra("PhotoPath", kgjfhdkxf)
                    } catch (ex: IOException) {
                    }

                    if (bhnhnhnhhn != null) {
                        kgjfhdkxf = "file:" + bhnhnhnhhn.absolutePath
                        totya.putExtra(
                            MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(bhnhnhnhhn)
                        )
                    } else {
                        totya = null
                    }
                }
                val boka = Intent(Intent.ACTION_GET_CONTENT)
                boka.addCategory(Intent.CATEGORY_OPENABLE)
                boka.type = "image/*"
                val gtgtgtt: Array<Intent?> =
                    totya?.let { arrayOf(it) } ?: arrayOfNulls(0)
                val opopopop = Intent(Intent.ACTION_CHOOSER)
                opopopop.putExtra(Intent.EXTRA_INTENT, boka)
                opopopop.putExtra(Intent.EXTRA_TITLE, getString(R.string.take_imagefgtgt))
                opopopop.putExtra(Intent.EXTRA_INITIAL_INTENTS, gtgtgtt)
                startActivityForResult(
                    opopopop, bnbnbn
                )
                return true
            }

            @Throws(IOException::class)
            private fun noka(): File {
                var frfrrfr = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                    "DirectoryNameHere"
                )
                if (!frfrrfr.exists()) {
                    frfrrfr.mkdirs()
                }

                frfrrfr =
                    File(frfrrfr.toString() + File.separator + "IMG_" + System.currentTimeMillis() + ".jpg")
                return frfrrfr
            }

        }

        jgidhgjdk.loadUrl(bbnbnko())
    }


    private fun pussshi(string: String) {
        OneSignal.setExternalUserId(
            string,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(results: JSONObject) {
                    try {
                        if (results.has("push") && results.getJSONObject("push").has("success")) {
                            val frrfrfrrf = results.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $frrfrfrrf"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("email") && results.getJSONObject("email").has("success")) {
                            val vccxddddddddd =
                                results.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $vccxddddddddd"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("sms") && results.getJSONObject("sms").has("success")) {
                            val frfrfr = results.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $frfrfr"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(error: OneSignal.ExternalIdError) {
                    OneSignal.onesignalLog(
                        OneSignal.LOG_LEVEL.VERBOSE,
                        "Set external user id done with error: $error"
                    )
                }
            })
    }


    private fun bgbggbffff(uri: String): Boolean {

        val goolka = packageManager
        try {

            goolka.getPackageInfo("org.telegram.messenger", PackageManager.GET_ACTIVITIES)

            return true
        } catch (e: PackageManager.NameNotFoundException) {

        }
        return false
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode != bnbnbn || bggbggb == null) {
            super.onActivityResult(requestCode, resultCode, data)
            return
        }
        var fnrnfnrf: Array<Uri>? = null

        if (resultCode == AppCompatActivity.RESULT_OK) {
            if (data == null || data.data == null) {
                fnrnfnrf = arrayOf(Uri.parse(kgjfhdkxf))
            } else {
                val vfvddsser = data.dataString
                if (vfvddsser != null) {
                    fnrnfnrf = arrayOf(Uri.parse(vfvddsser))
                }
            }
        }
        bggbggb?.onReceiveValue(fnrnfnrf)
        bggbggb = null
    }


    private var jkikiiik = false
    override fun onBackPressed() {


        if (jgidhgjdk.canGoBack()) {
            if (jkikiiik) {
                jgidhgjdk.stopLoading()
                jgidhgjdk.loadUrl(urlfififif)
            }
            this.jkikiiik = true
            jgidhgjdk.goBack()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                jkikiiik = false
            }, 2000)

        } else {
            super.onBackPressed()
        }
    }


}