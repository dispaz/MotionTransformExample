package com.example.motiontransformexample

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.motiontransformexample.adapters.ExampleRecyclerViewAdapter
import com.example.motiontransformexample.data.ExampleObject
import com.example.motiontransformexample.databinding.FragmentExampleListBinding
import java.io.InputStream
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ExampleListFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentExampleListBinding.inflate(inflater, container, false)
        binding.list = createExampleList()
        binding.listView.adapter = ExampleRecyclerViewAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun createExampleList() : List<ExampleObject>{
        val am = context!!.assets
        val files = am.list("images")
        var inputStream: InputStream? = null

        val examples: ArrayList<ExampleObject> = ArrayList()
        val random = Random()
        for ((index, file) in files!!.withIndex()) {
            try {
                inputStream = am.open("images/${file!!}")
            }
            catch (ex: Exception)
            {
                break
            }

            val d = BitmapFactory.decodeStream(inputStream)
            val example = ExampleObject(index, file, d, random.nextInt(5))
            examples.add(example)
        }
        return examples
    }
}