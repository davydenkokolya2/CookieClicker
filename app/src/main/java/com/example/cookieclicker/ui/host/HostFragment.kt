package com.example.cookieclicker.ui.host

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.cookieclicker.R
import com.example.cookieclicker.databinding.FragmentHostBinding
import com.example.cookieclicker.databinding.FragmentOnboardingBinding
import com.example.cookieclicker.ui.bakery.BakeryFragment
import com.example.cookieclicker.ui.menu.MenuFragment
import com.example.cookieclicker.ui.onboarding.OnboardingFragment
import com.example.cookieclicker.ui.shop.ShopFragment
import com.example.cookieclicker.ui.shop.ShopViewModel
import com.example.cookieclicker.util.Screens
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HostFragment : Fragment() {

    private lateinit var binding: FragmentHostBinding
    private val hostViewModel: HostViewModel by activityViewModels()
    private val shopViewModel: ShopViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHostBinding.inflate(inflater, container, false)
        lifecycleScope.launch {
            while (true) {
                var list = shopViewModel.stateHostShop.value
                hostViewModel.loadState(hostViewModel.stateHostCookies.value + list[0] + list[1] + list[2] + list[3] + list[4])
                delay(1000)
            }
        }
        lifecycleScope.launch {
            hostViewModel.stateHostScreen.collect {
                when (it) {
                    Screens.ONBOARDING -> {
                        replaceFragment(OnboardingFragment())
                        binding.tvHostTitle.text = "ONBOARDING"
                    }

                    Screens.BAKERY -> {
                        replaceFragment(BakeryFragment())
                        binding.tvHostTitle.text = "BAKERY"
                        binding.btnBack.visibility = View.VISIBLE
                    }

                    Screens.SHOP -> {
                        replaceFragment(ShopFragment())
                        binding.tvHostTitle.text = "SHOP"
                        binding.btnBack.visibility = View.VISIBLE
                    }

                    Screens.MENU -> {
                        replaceFragment(MenuFragment())
                        binding.tvHostTitle.text = "MENU"
                        binding.btnBack.visibility = View.INVISIBLE
                    }
                }
            }
        }
        lifecycleScope.launch {

        }

        lifecycleScope.launch {
            hostViewModel.stateHostCookies.collect {
                binding.tvCookiesScore.text = it.toString() + "  COOKIE"
            }
        }
        binding.btnBack.setOnClickListener {
            hostViewModel.loadState(Screens.MENU)
        }
        return binding.root
    }

    private suspend fun runWork() {
        coroutineScope {

        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView2, fragment)
        fragmentTransaction.commit()
    }


}