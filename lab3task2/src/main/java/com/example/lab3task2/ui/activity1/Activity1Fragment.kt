package com.example.lab3task2.ui.activity1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lab3task2.databinding.Activity1Binding

class Activity1Fragment : Fragment() {

    private var _binding: Activity1Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val activity1ViewModel =
            ViewModelProvider(this).get(Activity1ViewModel::class.java)

        _binding = Activity1Binding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textView1
        activity1ViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}