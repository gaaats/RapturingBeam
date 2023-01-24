package com.makingfun.mageandminion

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.makingfun.mageandminion.apiiiiaiai.DataStoreManager
import com.makingfun.mageandminion.apiiiiaiai.DataStoreManager.Companion.firstStartDataStoreKeyhyhy2yh2
import com.makingfun.mageandminion.apiiiiaiai.DataStoreManager.Companion.instIDDataStoreKeygt2gtgt
import com.makingfun.mageandminion.apiiiiaiai.DataStoreManager.Companion.randomUUIDDataStoreKeygt62tg2
import com.makingfun.mageandminion.databinding.FragmentF1Binding
import com.makingfun.mageandminion.otthter.Constance
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
@ActivityScoped
class F1Fragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {

            initOneSignal()
            initMyTrackerAndGoNext()

        } catch (e: Exception) {
            detdefdfe()
        }


        super.onViewCreated(view, savedInstanceState)
    }

    @Inject
    lateinit var hyhy6hyhy2hy: DataStoreManager

    private var hyhy2yh2hy: FragmentF1Binding? = null
    private val binding get() = hyhy2yh2hy ?: throw RuntimeException("FragmentF1Binding = null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        hyhy2yh2hy = FragmentF1Binding.inflate(inflater, container, false)
        Log.d("lolo", "F1Fragment")
        return binding.root
    }

    private fun initMyTrackerAndGoNext() {
        val trackerParamsgt3tg2 = MyTracker.getTrackerParams()
        val trackerConfiggt2 = MyTracker.getTrackerConfig()
        val instIDgt22 = MyTracker.getInstanceId(requireContext())
        trackerConfiggt2.isTrackingLaunchEnabled = true

        lifecycleScope.launch {
            val isFirstStart =
                hyhy6hyhy2hy.readStringFromDataStore6gt5tg5gt(key = firstStartDataStoreKeyhyhy2yh2)


            lifecycleScope.launch {
                if (isFirstStart == null) {
                    val IDIN2622 = UUID.randomUUID().toString()

                    trackerParamsgt3tg2.customUserId = IDIN2622
                    hyhy6hyhy2hy.saveStringToDataStoregtgttgt(
                        key = randomUUIDDataStoreKeygt62tg2,
                        value = IDIN2622
                    )
                    hyhy6hyhy2hy.saveStringToDataStoregtgttgt(
                        key = instIDDataStoreKeygt2gtgt,
                        value = instIDgt22
                    )
                    hyhy6hyhy2hy.saveStringToDataStoregtgttgt(
                        key = firstStartDataStoreKeyhyhy2yh2,
                        value = "noope"
                    )
                } else {
                    val customUserId =
                        hyhy6hyhy2hy.readStringFromDataStore6gt5tg5gt(key = randomUUIDDataStoreKeygt62tg2)
                            ?: Constance.KEY_NO_DATA
                    trackerParamsgt3tg2.customUserId = customUserId

                }
                MyTracker.initTracker(Constance.MY_TRACKER_ID, requireActivity().application)
                gttgjgtjigtjjtg()
            }
        }
    }

    private fun gttgjgtjigtjjtg() {
        findNavController().navigate(R.id.action_f1Fragment_to_f2Fragment)
    }

    private fun initOneSignal() {
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(requireContext())
        OneSignal.setAppId(Constance.ONE_SINGNAL_ID)
    }

    override fun onDestroy() {
        hyhy2yh2hy = null
        super.onDestroy()
    }


    private fun detdefdfe() {
        Snackbar.make(
            binding.root,
            "Oops something went wrong, please try again...",
            Snackbar.LENGTH_LONG
        ).show()
        jgtjtgjtgtgjigt()
    }

    private fun jgtjtgjtgtgjigt() {
        requireActivity().onBackPressed()
    }


}