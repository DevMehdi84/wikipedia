package com.example.wikipedia.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wikipedia.adapter.ExploreAdapter
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.FragmentExploreBinding

class Fragment_Explore : Fragment() {
    lateinit var binding: FragmentExploreBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentExploreBinding.inflate(layoutInflater , container , false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = arrayListOf<ItemPost>()

        val myAdapter = ExploreAdapter(data)

        binding.recyclerviewExplore.layoutManager  = LinearLayoutManager(context , RecyclerView.VERTICAL , false)
        binding.recyclerviewExplore.adapter = myAdapter
    }

}