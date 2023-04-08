package com.example.movieretrofit.fragments.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.movieretrofit.R
import com.example.movieretrofit.data.Nutrients
import com.example.movieretrofit.databinding.FragmentSearchBinding
import com.example.movieretrofit.model.SharedViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

//const val API_KEY = "6e787e3ba6ae4fdf8ff34be760e2b14e" // maxlepinskih
//const val API_KEY = "3895be68fe5b44b49bb4e3848c012498" // polina
const val API_KEY = "f1a7af1bc1744b7c8fd25cb13f716aef" // gogohihi8
const val BASE_URI = "https://api.spoonacular.com/food/"

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setupActionBarWithNavController(
            findNavController(
                requireActivity().findViewById(R.id.fragment)
            )
        )
    }

    fun handleNutrientsData(nutrients: Nutrients) {
        val viewModel: SharedViewModel by activityViewModels()

        viewModel.data.value = nutrients
        // Открытие другого фрагмента
        val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bNav)
        bottomNav.selectedItemId = R.id.home
    }

    companion object {
        @JvmStatic
        fun newInstance() = SearchFragment()
    }
}