package com.example.wikipedia.adapter

import com.example.wikipedia.data.ItemPost

interface ItemEvent {

    fun onItemClicked(itemPost: ItemPost)

}