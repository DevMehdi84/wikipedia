package com.example.wikipedia.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wikipedia.databinding.FragmentExploreBinding
import com.example.wikipedia.databinding.FragmentTrendBinding

class Fragment_Trend : Fragment() {
    lateinit var binding: FragmentTrendBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTrendBinding.inflate(layoutInflater , container , false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}