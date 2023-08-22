package com.example.cookieclicker

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.example.cookieclicker.util.Screens
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltAndroidApp
class App : Application() {
        private val _stateHostShop = MutableStateFlow(mutableListOf(0, 0, 0, 0, 0))
        val stateHostShop: StateFlow<MutableList<Int>> = _stateHostShop
        suspend fun loadState(shop: MutableList<Int>) {
            coroutineScope {
                _stateHostShop.emit(shop)
            }
        }
        private val _stateHostBakery = MutableStateFlow<Int>(0)
        val stateHostBakery: StateFlow<Int> = _stateHostBakery
        suspend fun loadState(bakery: Int) {
            coroutineScope {
                _stateHostBakery.emit(bakery)
            }
        }

        private val _stateHostScreen = MutableStateFlow<Screens>(Screens.ONBOARDING)
        val stateHostScreen: StateFlow<Screens> = _stateHostScreen
        suspend fun loadState(screens: Screens) {
            coroutineScope {
                _stateHostScreen.emit(screens)
            }
        }

        private val _stateHostCookies = MutableStateFlow<Int>(50)
        val stateHostCookies: StateFlow<Int> = _stateHostCookies
        suspend fun loadStateR(cookies: Int) {
            coroutineScope {
                _stateHostCookies.emit(cookies)
            }
        }
}