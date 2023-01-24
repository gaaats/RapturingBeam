package com.makingfun.mageandminion

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.facebook.applinks.AppLinkData
import com.google.android.material.snackbar.Snackbar
import com.makingfun.mageandminion.apiiiiaiai.DataStoreManager
import com.makingfun.mageandminion.apiiiiaiai.DataStoreManager.Companion.appsCheckerDataStoreKeygt2
import com.makingfun.mageandminion.apiiiiaiai.DataStoreManager.Companion.deepLinkDataStoreKey
import com.makingfun.mageandminion.apiiiiaiai.DataStoreManager.Companion.namingDataStoreKeygt2
import com.makingfun.mageandminion.databinding.FragmentF3Binding
import com.makingfun.mageandminion.otthter.Constance
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
@ActivityScoped
class F3Fragment : Fragment() {

    private lateinit var mContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentF3Binding = FragmentF3Binding.inflate(inflater, container, false)
        Log.d("lolo", "F3Fragment")
        return binding.root
    }

    override fun onAttach(context: Context) {
        mContext = context
        super.onAttach(context)
    }

    var temNaming2hy2hy = "loading"
    var tempDeep = "loading"

    @Inject
    lateinit var dataManager: DataStoreManager

    private var fragmentF3Binding: FragmentF3Binding? = null
    private val binding
        get() = fragmentF3Binding ?: throw RuntimeException("FragmentF3Binding = null")




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        try {
            lifecycleScope.launch {
                val isAppsLaunched =
                    dataManager.readStringFromDataStore6gt5tg5gt(key = appsCheckerDataStoreKeygt2)
                        ?: Constance.KEY_NO_DATA

                delay(500)

                when (isAppsLaunched) {
                    "1" -> {
                        Log.d("lolo", "launchAppsAndFb")
                        launchAppsAndFb()

                    }
                    "0" -> {
                        Log.d("lolo", "launchOnlyFb")
                        launchOnlyFb()

                    }
                    "2" -> {
                        Log.d("lolo", "заглушка сразу")
                        //заглушка сразу
                        tggtjtgigtjtgjtgi()
                    }

                }

            }


        } catch (e: Exception) {
            detdefdfe()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private suspend fun launchOnlyFb() {
        fbDeee(requireContext())

        val preDeep = dataManager.readStringFromDataStore6gt5tg5gt(deepLinkDataStoreKey)
        while (true) {
            if (tempDeep!="loading") {
                delay(500)
                if (preDeep == null) {
                    dataManager.saveStringToDataStoregtgttgt(key = deepLinkDataStoreKey, value = tempDeep)
                }
                delay(500)
                goNextScreen()
                break
            } else {
                delay(1000)
            }
        }

    }

    private fun tggtjtgigtjtgjtgi() {
        findNavController().navigate(R.id.action_f3Fragment_to_g1Fragment)
    }


    private suspend fun launchAppsAndFb() {
        fbDeee()
        initAppsFlyerLibeer(context = requireActivity())


        val preNaming = dataManager.readStringFromDataStore6gt5tg5gt(namingDataStoreKeygt2)
        val preDeep = dataManager.readStringFromDataStore6gt5tg5gt(deepLinkDataStoreKey)

        if (preDeep!=null){
            Log.d("lolo","change temptDeep to PreDeep")
            tempDeep = preDeep
        }



        while (true) {
            if (temNaming2hy2hy != "loading" && tempDeep!="loading") {
                delay(1000)
                if (preNaming == null) {
                    dataManager.saveStringToDataStoregtgttgt(key = namingDataStoreKeygt2, value = temNaming2hy2hy)
                }
                if (preDeep == null) {
                    dataManager.saveStringToDataStoregtgttgt(key = deepLinkDataStoreKey, value = tempDeep)
                }
                delay(500)
                goNextScreen()
                break
            } else {
                if (temNaming2hy2hy == "loading"){
                    Log.d("lolo", "temNaming  == NULL delay")
                }
                if (tempDeep=="loading"){
                    Log.d("lolo", "tempDeep == NULL delay")
                }
                delay(1000)
            }
        }
    }

    private fun goNextScreen() {
        findNavController().navigate(R.id.action_f3Fragment_to_f4Fragment)
    }


    override fun onDestroy() {
        fragmentF3Binding = null
        super.onDestroy()
    }

    private fun detdefdfe() {
        Snackbar.make(
            binding.root,
            "Oops something went wrong, please try again...",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().finish()
    }

    private fun initAppsFlyerLibeer(context: Context) {
        AppsFlyerLib.getInstance()
            .init(Constance.KEY_APPS_ID, conversionDataListener, context)
        AppsFlyerLib.getInstance().start(context)
    }



    private val conversionDataListener = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val dataGotten = data?.get("campaign").toString().apply {
                temNaming2hy2hy = this
                Log.d("lolo", "onConversionDataSuccess naming is $this")

            }
        }

        override fun onConversionDataFail(p0: String?) {
            Log.d("lolo", "onConversionDataFail")
        }

        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {
        }

        override fun onAttributionFailure(p0: String?) {
        }
    }

    fun fbDeee(cont: Context = mContext) {
        AppLinkData.fetchDeferredAppLinkData(
            cont
        ) { data: AppLinkData? ->
            data?.let {
                val deepData = data.targetUri?.host.toString()
                Log.d("lolo", "fbDeee GET deepData")
                Log.d("lolo", "fbDeee GET deepData deepLink is $deepData")
                tempDeep = deepData
//                Toast.makeText(cont, "Deeplink GOOD ${deepData}", Toast.LENGTH_SHORT).show()
            }
            if (data == null){
                tempDeep = "null"
                Log.d("lolo", "fbDeee deepData == null")
//                Toast.makeText(cont, "Deeplink  NUll", Toast.LENGTH_SHORT).show()
            }
        }
    }


}