package com.example.cookieclicker.ui.bakery

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.cookieclicker.R
import com.example.cookieclicker.databinding.FragmentBakeryBinding
import com.example.cookieclicker.ui.host.HostViewModel
import com.example.cookieclicker.ui.shop.ShopViewModel
import com.example.cookieclicker.util.Screens
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Integer.min

class BakeryFragment : Fragment() {

    private lateinit var binding: FragmentBakeryBinding
    private val bakeryViewModel: BakeryViewModel by activityViewModels()
    private val hostViewModel: HostViewModel by activityViewModels()
    private val shopViewModel: ShopViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBakeryBinding.inflate(inflater, container, false)
        lifecycleScope.launch {
            bakeryViewModel.stateHostBakery.collect {
                when (it) {
                    1 -> {
                        binding.bakeryCard1.visibility = View.VISIBLE
                    }

                    2 -> {
                        binding.bakeryCard1.visibility = View.VISIBLE
                        binding.bakeryCard2.visibility = View.VISIBLE
                    }

                    3 -> {
                        binding.bakeryCard1.visibility = View.VISIBLE
                        binding.bakeryCard2.visibility = View.VISIBLE
                        binding.bakeryCard3.visibility = View.VISIBLE
                    }

                    4 -> {
                        binding.bakeryCard1.visibility = View.VISIBLE
                        binding.bakeryCard2.visibility = View.VISIBLE
                        binding.bakeryCard3.visibility = View.VISIBLE
                        binding.bakeryCard4.visibility = View.VISIBLE
                    }

                    5 -> {
                        binding.bakeryCard1.visibility = View.VISIBLE
                        binding.bakeryCard2.visibility = View.VISIBLE
                        binding.bakeryCard3.visibility = View.VISIBLE
                        binding.bakeryCard4.visibility = View.VISIBLE
                        binding.bakeryCard5.visibility = View.VISIBLE
                    }
                }
            }
        }

        binding.btnHireaBaker.setOnClickListener {
            if (hostViewModel.stateHostCookies.value >= 50) {
                val bakeryValue = bakeryViewModel.stateHostBakery.value
                hostViewModel.loadState(hostViewModel.stateHostCookies.value - 50)
                bakeryViewModel.loadState(min(5, bakeryValue + 1))
                var list = shopViewModel.stateHostShop.value
                list[bakeryValue]++
                Log.d("test", list[0].toString())
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
        val it = shopViewModel.stateHostShop.value
        binding.tvLevelBakeryCard1.text = "Level ${it[0]}  ${it[0]}/sec"
        binding.tvLevelBakeryCard2.text = "Level ${it[1]}  ${it[1]}/sec"
        binding.tvLevelBakeryCard3.text = "Level ${it[2]}  ${it[2]}/sec"
        binding.tvLevelBakeryCard4.text = "Level ${it[3]}  ${it[3]}/sec"
        binding.tvLevelBakeryCard5.text = "Level ${it[4]}  ${it[4]}/sec"
    }

}