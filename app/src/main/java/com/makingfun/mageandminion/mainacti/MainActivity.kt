package com.makingfun.mageandminion.mainacti

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.makingfun.mageandminion.R
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped


@AndroidEntryPoint
@ActivityScoped
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        onDestroy()
    }
}