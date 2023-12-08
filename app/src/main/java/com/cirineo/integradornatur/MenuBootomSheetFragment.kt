package com.cirineo.integradornatur

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.cirineo.integradornatur.adapter.MenuAdapter
import com.cirineo.integradornatur.databinding.FragmentMenuBootomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.ArrayList

class MenuBootomSheetFragment : BottomSheetDialogFragment(){
    private lateinit var binding:FragmentMenuBootomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBootomSheetBinding.inflate(inflater,container,false)

        binding.buttonBack.setOnClickListener {
            dismiss()
        }
        val menuItemName = listOf("Shampoo","Vitaminas","Frutas","Verduras","Sabila","Leche")
        val menuPrice = listOf("S/30","S/50","S/10","S/15","S/20","S/22")
        val menuImage = listOf(
            R.drawable.item1,
            R.drawable.item4,
            R.drawable.item3,
            R.drawable.item4,
            R.drawable.item5,
            R.drawable.item6,
        )
        val adapter = MenuAdapter(
            ArrayList(menuItemName),
            ArrayList(menuPrice),
            ArrayList(menuImage)
        )
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}