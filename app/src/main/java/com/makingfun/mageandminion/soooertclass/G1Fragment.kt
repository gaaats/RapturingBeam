package com.makingfun.mageandminion.soooertclass

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.makingfun.mageandminion.R
import com.makingfun.mageandminion.databinding.FragmentG1Binding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class G1Fragment : Fragment() {


    companion object {
        private const val SPLASH_SCREEN_TIMEggtgttg: Long = 1500
    }

    private fun hyhyhyhy() {
        lifecycleScope.launch {
            for (progress in 1..100) {
                withContext(Dispatchers.Main) {
                    yyyyy.progBarSplashScrn.progress = progress
                }
                delay(SPLASH_SCREEN_TIMEggtgttg / 125)
            }
            //here add
            gttgjjgtjigtjitgjigt()
        }
    }

    private fun gttgjjgtjigtjitgjigt() {
        findNavController().navigate(R.id.action_g1Fragment_to_g2Fragment)
    }

    private var fragmentG1Binding: FragmentG1Binding? = null
    private val yyyyy
        get() = fragmentG1Binding ?: throw RuntimeException("FragmentG1Binding = null")


    private fun eeeeeeee() {
        Snackbar.make(
            yyyyy.root,
            "Error, error, error",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentG1Binding = FragmentG1Binding.inflate(inflater, container, false)
        return yyyyy.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {

            hyhyhyhy()


        } catch (e: Exception) {
            eeeeeeee()
        }


        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        fragmentG1Binding = null
        super.onDestroy()
    }
}