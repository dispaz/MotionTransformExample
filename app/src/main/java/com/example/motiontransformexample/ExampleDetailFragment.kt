package com.example.motiontransformexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.motiontransformexample.databinding.FragmentExampleDetailBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ExampleDetailFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val args = requireArguments()
        val example = ExampleDetailFragmentArgs.fromBundle(args).selectedExample

        val binding = FragmentExampleDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.example = example
        binding.exampleImage.setImageBitmap(example.imageUrl)
        binding.executePendingBindings()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}