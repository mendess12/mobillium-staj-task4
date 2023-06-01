package com.example.task4.ui.list

import CryptoAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task4.R
import com.example.task4.databinding.FragmentListBinding
import com.example.task4.util.showSnackBar

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val viewModel: ListViewModel by viewModels()
    private lateinit var dataAdapter: CryptoAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)

        binding.recyclerView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.layoutManager = linearLayoutManager
        observeLiveData()
        viewModel.getCryptoDataFromAPI()
    }

    private fun observeLiveData() {
        viewModel.cryptoDataList.observe(viewLifecycleOwner) {
            if (it != null) {
                dataAdapter = CryptoAdapter(it)
                binding.recyclerView.adapter = dataAdapter
            } else {
                view?.showSnackBar("List is empty!")
            }
        }
    }
}