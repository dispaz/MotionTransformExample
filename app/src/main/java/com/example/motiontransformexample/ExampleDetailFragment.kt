package com.example.motiontransformexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import com.example.motiontransformexample.databinding.FragmentExampleDetailBinding
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialContainerTransform

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

        ViewCompat.setTransitionName(binding.exampleImage, "${example.id}")

        binding.executePendingBindings()

        configureTransitions()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun configureTransitions()
    {
        val transition = MaterialContainerTransform()/*.apply {
            duration = 1000L
        }*/
        sharedElementEnterTransition = transition

    }
}