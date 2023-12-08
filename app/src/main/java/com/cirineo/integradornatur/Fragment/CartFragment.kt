package com.cirineo.integradornatur.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.cirineo.integradornatur.R
import com.cirineo.integradornatur.adapter.CartAdapter
import com.cirineo.integradornatur.databinding.FragmentCartBinding
import java.util.ArrayList


class CartFragment : Fragment() {
    private lateinit var binding:FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater,container,false)



        val cartItemName = listOf("Shampoo","Vitaminas","Frutas","Verduras","Sabila","Leche")
        val cartItemPrice = listOf("S/30","S/50","S/10","S/15","S/20","S/22")
        val cartImage = listOf(
            R.drawable.item1,
            R.drawable.item4,
            R.drawable.item3,
            R.drawable.item4,
            R.drawable.item5,
            R.drawable.item6,
        )
        val adapter = CartAdapter(ArrayList(cartItemName),ArrayList(cartItemPrice),ArrayList(cartImage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}