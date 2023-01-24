package com.makingfun.mageandminion.apapap

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Singleton


@HiltAndroidApp
@Singleton
class SupermanClass : Application() {

    companion object{
        var typeOfPromotion = ""
        var link = ""
        var id = ""
    }

}
