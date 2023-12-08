package com.cirineo.integradornatur.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.cirineo.integradornatur.R
import com.cirineo.integradornatur.adapter.MenuAdapter
import com.cirineo.integradornatur.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter
    private val originalMenuItemName = listOf("Shampoo","Vitaminas","Frutas","Verduras","Sabila","Leche")
    private val originalMenuPrice = listOf("S/30","S/50","S/10","S/15","S/20","S/22")
    private val originalMenuImage = listOf(
        R.drawable.item1,
        R.drawable.item4,
        R.drawable.item3,
        R.drawable.item4,
        R.drawable.item5,
        R.drawable.item6,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
private val filteredMenuItemName = mutableListOf<String>()
private val filteredMenuPrice = mutableListOf<String>()
private val filteredMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter = MenuAdapter(filteredMenuItemName,filteredMenuPrice,filteredMenuImage )
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        //configuración para la vista de busqueda
        setupSearchView()

        showAllMenu()
        return binding.root
    }

    private fun showAllMenu() {
        filteredMenuItemName.clear()
        filteredMenuPrice.clear()
        filteredMenuImage.clear()

        filteredMenuItemName.addAll(originalMenuItemName)
        filteredMenuPrice.addAll(originalMenuPrice)
        filteredMenuImage.addAll(originalMenuImage)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }

        })
    }

    private fun filterMenuItems(query: String) {
        filteredMenuItemName.clear()
        filteredMenuPrice.clear()
        filteredMenuImage.clear()

        originalMenuItemName.forEachIndexed { index, itemName ->
            if (itemName.contains(query,ignoreCase = true)) {
                filteredMenuItemName.add(itemName)
                filteredMenuPrice.add(originalMenuPrice[index])
                filteredMenuImage.add(originalMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }

    companion object {

    }
}