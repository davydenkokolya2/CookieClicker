package com.example.cookieclicker.ui.bakery

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
class BakeryViewModel @Inject constructor(): ViewModel() {
    private val _stateHostBakery = MutableStateFlow<Int>(0)
    val stateHostBakery: StateFlow<Int> = _stateHostBakery
    fun loadState(bakery: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateHostBakery.emit(bakery)
        }
    }


}