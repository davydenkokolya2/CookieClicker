package com.example.cookieclicker.ui.host

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cookieclicker.util.Screens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HostViewModel @Inject constructor() : ViewModel() {
    private val _stateHostScreen = MutableStateFlow<Screens>(Screens.ONBOARDING)
    val stateHostScreen: StateFlow<Screens> = _stateHostScreen
    fun loadState(screens: Screens) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateHostScreen.emit(screens)
        }
    }

    private val _stateHostCookies = MutableStateFlow<Int>(50)
    val stateHostCookies: StateFlow<Int> = _stateHostCookies
    fun loadState(cookies: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateHostCookies.emit(cookies)
        }
    }
}