package com.example.motiontransformexample.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

import com.example.motiontransformexample.data.ExampleObject

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, list: List<ExampleObject>)
{
    val adapter = recyclerView.adapter as ExampleRecyclerViewAdapter
    adapter.submitList(list)
}