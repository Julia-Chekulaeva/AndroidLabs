package com.example.lab3task2.ui.activity3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lab3task2.databinding.Activity3Binding

class Activity3Fragment : Fragment() {

    private var _binding: Activity3Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val activity3ViewModel =
            ViewModelProvider(this).get(Activity3ViewModel::class.java)

        _binding = Activity3Binding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textView3
        activity3ViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}