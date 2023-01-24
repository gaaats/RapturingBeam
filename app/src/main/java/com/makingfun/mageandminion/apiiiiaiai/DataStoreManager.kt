package com.makingfun.mageandminion.apiiiiaiai

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStoreManager @Inject constructor(context: Application) {


    private val Context.datasote: DataStore<Preferences> by preferencesDataStore("SETTINGS")
    private val dataStore = context.datasote


    suspend fun readStringFromDataStore6gt5tg5gt(key: Preferences.Key<String>): String? {
        val pref = dataStore.data.first()
        return pref[key]
    }


    companion object {
        val instIDDataStoreKeygt2gtgt = stringPreferencesKey("instID")
        val firstStartDataStoreKeyhyhy2yh2 = stringPreferencesKey("firstStart")

        val advertIDDataStoreKeygt62tg2tg = stringPreferencesKey("advertID")
        val userGeoDataStoreKeygtgt62gt = stringPreferencesKey("userGeo")
        val listOfAllGeoDataStoreKeygt6gttg2 = stringPreferencesKey("listOfAllGeo")
        val appsCheckerDataStoreKeygt2 = stringPreferencesKey("appsChecker")
        val linkCheckerDataStoreKeygt262 = stringPreferencesKey("link")

        val namingDataStoreKeygt2 = stringPreferencesKey("naming")
        val deepLinkDataStoreKey = stringPreferencesKey("deepLink")
        val randomUUIDDataStoreKeygt62tg2 = stringPreferencesKey("randomId")

        val mainLinkKey = stringPreferencesKey("mainLinkKey")

    }

    suspend fun saveStringToDataStoregtgttgt(key: Preferences.Key<String>, value: String) {
        dataStore.edit {
            it[key] = value
        }
    }
}