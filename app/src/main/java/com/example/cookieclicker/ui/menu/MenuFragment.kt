package com.example.cookieclicker.ui.menu

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.cookieclicker.R
import com.example.cookieclicker.databinding.FragmentMenuBinding
import com.example.cookieclicker.ui.host.HostViewModel
import com.example.cookieclicker.ui.shop.ShopViewModel
import com.example.cookieclicker.util.Screens
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    private val hostViewModel: HostViewModel by activityViewModels()
    private val shopViewModel: ShopViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)

        binding.btnTapPower.setOnClickListener {
            hostViewModel.loadState(Screens.SHOP)
        }
        binding.btnMyBakery.setOnClickListener {
            hostViewModel.loadState(Screens.BAKERY)
        }
        lifecycleScope.launch {
            shopViewModel.stateHostShop.collect {
                binding.tvMenuSpeed.text = (it[0] + it[1] + it[2] + it[3] + it[4]).toString() + "/sec"
            }
        }
        return binding.root
    }
}