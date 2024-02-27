package com.example.domain.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.example.common.Constants
import com.example.common.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class LocalUserManagerImpl @Inject constructor(
    private val context: Context
): LocalUserManager {

    override suspend fun saveAppEntry() {
        context.dataStore.edit { settings ->
            settings[PrefsKeys.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map {  prefs ->
            prefs[PrefsKeys.APP_ENTRY] ?: false
        }
    }

}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

private object PrefsKeys {
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}