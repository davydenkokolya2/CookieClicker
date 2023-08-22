package com.example.cookieclicker.ui.shop

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
class ShopViewModel @Inject constructor(): ViewModel() {
    private val _stateHostShop = MutableStateFlow(mutableListOf(0, 0, 0, 0, 0))
    val stateHostShop: StateFlow<MutableList<Int>> = _stateHostShop
    fun loadState(shop: MutableList<Int>) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateHostShop.emit(shop)
        }
    }

}