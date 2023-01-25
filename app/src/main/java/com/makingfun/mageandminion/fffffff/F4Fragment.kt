package com.makingfun.mageandminion.fffffff

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.appsflyer.AppsFlyerLib
import com.google.android.material.snackbar.Snackbar
import com.makingfun.mageandminion.R
import com.makingfun.mageandminion.apapap.SupermanClass
import com.makingfun.mageandminion.apiiiiaiai.DataStoreManager
import com.makingfun.mageandminion.apiiiiaiai.DataStoreManager.Companion.advertIDDataStoreKeygt62tg2tg
import com.makingfun.mageandminion.apiiiiaiai.DataStoreManager.Companion.appsCheckerDataStoreKeygt2
import com.makingfun.mageandminion.apiiiiaiai.DataStoreManager.Companion.deepLinkDataStoreKey
import com.makingfun.mageandminion.apiiiiaiai.DataStoreManager.Companion.instIDDataStoreKeygt2gtgt
import com.makingfun.mageandminion.apiiiiaiai.DataStoreManager.Companion.linkCheckerDataStoreKeygt262
import com.makingfun.mageandminion.apiiiiaiai.DataStoreManager.Companion.listOfAllGeoDataStoreKeygt6gttg2
import com.makingfun.mageandminion.apiiiiaiai.DataStoreManager.Companion.namingDataStoreKeygt2
import com.makingfun.mageandminion.apiiiiaiai.DataStoreManager.Companion.userGeoDataStoreKeygtgt62gt
import com.makingfun.mageandminion.brovv.VebVrroLiActivity
import com.makingfun.mageandminion.databinding.FragmentF4Binding
import com.makingfun.mageandminion.otthter.Constance
import com.makingfun.mageandminion.otthter.Constance.CAMPAIGN
import com.makingfun.mageandminion.otthter.Constance.DEEPLINK
import com.makingfun.mageandminion.otthter.Constance.DEEPLINKNOAPPS
import com.makingfun.mageandminion.otthter.Constance.GEO
import com.makingfun.mageandminion.otthter.Constance.KEY_TDB2gtgt
import com.makingfun.mageandminion.otthter.Constance.PACK_NAME
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
@ActivityScoped
class F4Fragment : Fragment() {

    val deviceID = "deviceID="
    val sub_id_1 = "sub_id_1="
    val ad_id = "ad_id="
    val sub_id_4 = "sub_id_4="
    val sub_id_5 = "sub_id_5="
    val sub_id_6 = "sub_id_6="
    val naming_name = "naming"
    val deeporg = "deeporg"

    val buildVers = Build.VERSION.RELEASE


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("lolo", "F4Fragment")
        try {
            lifecycleScope.launch {
                val naming =
                    dataManager.readStringFromDataStore6gt5tg5gt(key = namingDataStoreKeygt2)
                        ?: Constance.KEY_NO_DATA
                val deepLink =
                    dataManager.readStringFromDataStore6gt5tg5gt(key = deepLinkDataStoreKey)
                        ?: Constance.KEY_NO_DATA
                val geoUser =
                    dataManager.readStringFromDataStore6gt5tg5gt(key = userGeoDataStoreKeygtgt62gt)
                        ?: "no geeeeo"
                val listGeo =
                    dataManager.readStringFromDataStore6gt5tg5gt(key = listOfAllGeoDataStoreKeygt6gttg2)
                        ?: Constance.KEY_NO_DATA

                val mainId =
                    dataManager.readStringFromDataStore6gt5tg5gt(key = advertIDDataStoreKeygt62tg2tg)
                        ?: Constance.KEY_NO_DATA
                val checkNumber =
                    dataManager.readStringFromDataStore6gt5tg5gt(key = appsCheckerDataStoreKeygt2)
                        ?: Constance.KEY_NO_DATA
                val linka =
                    dataManager.readStringFromDataStore6gt5tg5gt(key = linkCheckerDataStoreKeygt262)
                        ?: Constance.KEY_NO_DATA
                val myInstID =
                    dataManager.readStringFromDataStore6gt5tg5gt(key = instIDDataStoreKeygt2gtgt)
                        ?: Constance.KEY_NO_DATA

                val appsId =
                    AppsFlyerLib.getInstance().getAppsFlyerUID(requireContext().applicationContext)


                delay(1000)

                when (checkNumber) {
                    "2" -> {
                        Log.d("lolo", "in 2")
                        findNavController().navigate(R.id.action_f4Fragment_to_g1Fragment)
                    }
                    "1" -> {
                        Log.d("lolo", "in 1")
                        Log.d("lolo", "naming in 1 ${naming}")
                        Log.d("lolo", "deepLink in 1 ${deepLink}")
//                        Toast.makeText(requireContext(), "Deeplink GOOD ${deepLink}, frag4", Toast.LENGTH_SHORT).show()


                        //Fb + Apps
                        AppsFlyerLib.getInstance().setCollectAndroidID(true)
                        if (naming.contains(KEY_TDB2gtgt)) {
                            SupermanClass.typeOfPromotion = CAMPAIGN
                            SupermanClass.id = appsId.toString()

                            SupermanClass.link =
                                "$linka?$sub_id_1$naming&$deviceID$appsId&$ad_id$mainId&$sub_id_4${PACK_NAME}&$sub_id_5$buildVers&$sub_id_6$naming_name"
                            goToVeb()
                        } else {
                            if (deepLink.contains(KEY_TDB2gtgt) || listGeo.contains(
                                    geoUser
                                )
                            ) {
                                SupermanClass.typeOfPromotion = DEEPLINK
                                SupermanClass.link =
                                    "$linka?$sub_id_1$deepLink&$deviceID$appsId&$ad_id$mainId&$sub_id_4${PACK_NAME}&$sub_id_5$buildVers&$sub_id_6$deeporg"
                                SupermanClass.id = appsId.toString()
                                goToVeb()
                            } else {
                                findNavController().navigate(R.id.action_f4Fragment_to_g1Fragment)
                            }

                        }
                    }
                    "0" -> {
                        Log.d("lolo", "in 3")
                        //Fb + initLoadMyTracker
                        Log.d("lolo", "tempDeepLoad NOT null, 0 var")
                        if (deepLink.contains(KEY_TDB2gtgt)) {
                            Log.d("lolo", "var 0 deepLink.contains(MAIN_CHECKER)")
                            SupermanClass.typeOfPromotion = DEEPLINKNOAPPS
                            SupermanClass.id = myInstID
                            SupermanClass.link =
                                "$linka?$sub_id_1$deepLink&$deviceID$myInstID&$ad_id$myInstID&$sub_id_4${PACK_NAME}&$sub_id_5$buildVers&$sub_id_6$deeporg"

                            goToVeb()
                        } else {
                            if (listGeo.contains(geoUser)) {
                                Log.d("lolo", "var 3 listOfGeo.contains(userCurrentGeo)")
                                SupermanClass.typeOfPromotion = GEO
                                SupermanClass.id = myInstID
                                SupermanClass.link =
                                    "$linka?$sub_id_1$myInstID&$ad_id$myInstID&$sub_id_4${PACK_NAME}&$sub_id_5$buildVers&$sub_id_6$naming_name"

                                goToVeb()
                            } else {
                                //go to game
                                findNavController().navigate(R.id.action_f4Fragment_to_g1Fragment)
                            }
                        }


                    }
                }


//                if (naming.contains(Constance.KEY_TDB2gtgt) || listGeo.contains(geoUser)) {
//                    MainClassssa.typeOfPromotion = Constance.CAMPAIGN
//                    SupermanClass.link =
//                        "$linka?$sub_id_1$naming&$deviceID$appsId&$ad_id$advertMainId&$sub_id_4${pacaaakageNameMain}&$sub_id_5$buildVers&$sub_id_6$naming_name"
//
//
//
//                    gmmhmhyjyhjijyhjhyj()
//                } else {
//
//                    findNavController().navigate(R.id.action_f4Fragment_to_g1Fragment)
//                }
            }


        } catch (e: Exception) {
            hkphykphyhykoky()
        }
        super.onViewCreated(view, savedInstanceState)
    }


    @Inject
    lateinit var dataManager: DataStoreManager

    private var fragmentB4Binding: FragmentF4Binding? = null
    private val binding
        get() = fragmentB4Binding ?: throw RuntimeException("FragmentF4Binding = null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentB4Binding = FragmentF4Binding.inflate(inflater, container, false)
        return binding.root
    }


    private fun goToVeb() {
        val gtmgtogtkgtkt = Intent(requireActivity(), VebVrroLiActivity::class.java)
        startActivity(gtmgtogtkgtkt)
        jtggtjgtjjgtjitgji()
    }

    private fun hkphykphyhykoky() {
        Snackbar.make(
            binding.root,
            "Oops something went wrong, please try again...",
            Snackbar.LENGTH_LONG
        ).show()
        jtggtjgtjjgtjitgji()
    }

    private fun jtggtjgtjjgtjitgji() {
        requireActivity().finish()
    }


    override fun onDestroy() {
        fragmentB4Binding = null
        super.onDestroy()
    }
}