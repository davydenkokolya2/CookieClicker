package com.example.cookieclicker.ui.onboarding

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.cookieclicker.R
import com.example.cookieclicker.databinding.FragmentOnboardingBinding
import com.example.cookieclicker.ui.host.HostViewModel
import com.example.cookieclicker.util.Screens
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class OnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding
    private val hostViewModel: HostViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        binding.textView2.setOnClickListener {
            hostViewModel.loadState(Screens.MENU)
        }
        return binding.root
    }


}