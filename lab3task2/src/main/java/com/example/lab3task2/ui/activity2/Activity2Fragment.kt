package com.example.lab3task2.ui.activity2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lab3task2.databinding.Activity2Binding

class Activity2Fragment : Fragment() {

    private var _binding: Activity2Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val activity2ViewModel =
            ViewModelProvider(this).get(Activity2ViewModel::class.java)

        _binding = Activity2Binding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textView2
        activity2ViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}