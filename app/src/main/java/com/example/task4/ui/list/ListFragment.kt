package com.example.task4.ui.list

import CryptoAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task4.R
import com.example.task4.databinding.FragmentListBinding
import com.example.task4.util.showSnackBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val viewModel: ListViewModel by viewModels()
    private var dataAdapter = CryptoAdapter()
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
        binding.recyclerView.adapter = dataAdapter
        searchView()
        observeLiveData()
        viewModel.refreshData()
    }

    private fun observeLiveData() {
        viewModel.cryptoDataList.observe(viewLifecycleOwner) {
            if (it != null) {
                dataAdapter.updateData(it)
            } else {
                view?.showSnackBar("List is empty!")
            }
        }
    }

    private fun searchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    dataAdapter.filter.filter(newText)
                }
                return true
            }
        })
    }
}