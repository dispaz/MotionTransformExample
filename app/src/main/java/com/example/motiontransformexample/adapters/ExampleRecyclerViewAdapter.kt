package com.example.motiontransformexample.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.motiontransformexample.ExampleListFragmentDirections
import com.example.motiontransformexample.data.ExampleObject
import com.example.motiontransformexample.databinding.ExampleListItemBinding

class ExampleRecyclerViewAdapter : ListAdapter<ExampleObject, RecyclerView.ViewHolder>(ExampleObjectDiffCallback())
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ExampleViewHolder(ExampleListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val example = getItem(position)
        (holder as ExampleViewHolder).bind(example)
    }

    class ExampleViewHolder(val binding: ExampleListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener{
                binding.example?.let { exampleObject ->
                    navigateToExample(exampleObject, it)
                }
            }
        }

        fun navigateToExample(example: ExampleObject, view: View)
        {
            val direction = ExampleListFragmentDirections.actionExampleListToExampleDetail(example)
            val extras = FragmentNavigatorExtras(binding.exampleImage to "${example.id}")
            view.findNavController().navigate(direction, extras)
        }

        fun bind(example: ExampleObject){
            binding.apply {
                this.example = example
                this.exampleImage.setImageBitmap(example.imageUrl)
                ViewCompat.setTransitionName(binding.exampleImage, "${example.id}")
                executePendingBindings()
            }
        }
    }
}

class ExampleObjectDiffCallback() : DiffUtil.ItemCallback<ExampleObject>(){
    override fun areContentsTheSame(oldItem: ExampleObject, newItem: ExampleObject): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areItemsTheSame(oldItem: ExampleObject, newItem: ExampleObject): Boolean {
        return  oldItem == newItem
    }
}