package com.example.cookieclicker.ui.shop

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.lifecycleScope
import com.example.cookieclicker.R
import com.example.cookieclicker.databinding.FragmentShopBinding
import com.example.cookieclicker.ui.bakery.BakeryViewModel
import com.example.cookieclicker.ui.host.HostViewModel
import com.example.cookieclicker.util.Screens
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ShopFragment : Fragment() {

    private lateinit var binding: FragmentShopBinding
    private val bakeryViewModel: BakeryViewModel by activityViewModels()
    private val shopViewModel: ShopViewModel by activityViewModels()
    private val hostViewModel: HostViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentShopBinding.inflate(inflater, container, false)
        lifecycleScope.launch {
            bakeryViewModel.stateHostBakery.collect {
                when (it) {
                    1 -> {
                        binding.ivShopCard1.setImageResource(R.drawable.icon_blue_background_shop)
                    }

                    2 -> {
                        binding.ivShopCard1.setImageResource(R.drawable.icon_blue_background_shop)
                        binding.ivShopCard2.setImageResource(R.drawable.icon_blue_background_shop)
                    }

                    3 -> {
                        binding.ivShopCard1.setImageResource(R.drawable.icon_blue_background_shop)
                        binding.ivShopCard2.setImageResource(R.drawable.icon_blue_background_shop)
                        binding.ivShopCard3.setImageResource(R.drawable.icon_blue_background_shop)
                    }

                    4 -> {
                        binding.ivShopCard1.setImageResource(R.drawable.icon_blue_background_shop)
                        binding.ivShopCard2.setImageResource(R.drawable.icon_blue_background_shop)
                        binding.ivShopCard3.setImageResource(R.drawable.icon_blue_background_shop)
                        binding.ivShopCard4.setImageResource(R.drawable.icon_blue_background_shop)
                    }

                    5 -> {
                        binding.ivShopCard1.setImageResource(R.drawable.icon_blue_background_shop)
                        binding.ivShopCard2.setImageResource(R.drawable.icon_blue_background_shop)
                        binding.ivShopCard3.setImageResource(R.drawable.icon_blue_background_shop)
                        binding.ivShopCard4.setImageResource(R.drawable.icon_blue_background_shop)
                        binding.ivShopCard5.setImageResource(R.drawable.icon_blue_background_shop)
                    }
                }
            }
        }

        binding.shopCard1.setOnClickListener {
            var list = shopViewModel.stateHostShop.value
            if (list[0] > 0 && list[0] * 50 <= hostViewModel.stateHostCookies.value) {
                hostViewModel.loadState(hostViewModel.stateHostCookies.value - list[0] * 50)
                list[0]++
                shopViewModel.loadState(list)
                changeLevel()
            }

        }
        binding.shopCard2.setOnClickListener {
            var list = shopViewModel.stateHostShop.value
            if (list[1] > 0 && list[1] * 50 <= hostViewModel.stateHostCookies.value) {
                hostViewModel.loadState(hostViewModel.stateHostCookies.value - list[1] * 50)
                list[1]++
                shopViewModel.loadState(list)
                changeLevel()
            }
        }
        binding.shopCard3.setOnClickListener {
            var list = shopViewModel.stateHostShop.value
            if (list[2] > 0 && list[2] * 50 <= hostViewModel.stateHostCookies.value) {
                hostViewModel.loadState(hostViewModel.stateHostCookies.value - list[2] * 50)
                list[2]++
                shopViewModel.loadState(list)
                changeLevel()
            }
        }
        binding.shopCard4.setOnClickListener {
            var list = shopViewModel.stateHostShop.value
            if (list[3] > 0 && list[3] * 50 <= hostViewModel.stateHostCookies.value) {
                hostViewModel.loadState(hostViewModel.stateHostCookies.value - list[3] * 50)
                list[3]++
                shopViewModel.loadState(list)
                changeLevel()
            }
        }
        binding.shopCard5.setOnClickListener {
            var list = shopViewModel.stateHostShop.value
            if (list[4] > 0 && list[4] * 50 <= hostViewModel.stateHostCookies.value) {
                hostViewModel.loadState(hostViewModel.stateHostCookies.value - list[4] * 50)
                list[4]++
                shopViewModel.loadState(list)
                changeLevel()
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeLevel()
    }

    private fun changeLevel() {
        val list = shopViewModel.stateHostShop.value

        binding.tvScoreShopCard1.text = (list[0] * 50).toString() + " Cookie"
        binding.tvScoreShopCard2.text = (list[1] * 50).toString() + " Cookie"
        binding.tvScoreShopCard3.text = (list[2] * 50).toString() + " Cookie"
        binding.tvScoreShopCard4.text = (list[3] * 50).toString() + " Cookie"
        binding.tvScoreShopCard5.text = (list[4] * 50).toString() + " Cookie"
        binding.tvSpeedShopCard1.text = (list[0]).toString() + "/sec"
        binding.tvSpeedShopCard2.text = (list[1]).toString() + "/sec"
        binding.tvSpeedShopCard3.text = (list[2]).toString() + "/sec"
        binding.tvSpeedShopCard4.text = (list[3]).toString() + "/sec"
        binding.tvSpeedShopCard5.text = (list[4]).toString() + "/sec"
    }
    

}