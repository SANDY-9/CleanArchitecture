package com.example.cleanarchitectureapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitectureapp.adapter.CoinRecyclerAdapter
import com.example.cleanarchitectureapp.databinding.ActivityMainBinding
import com.example.cleanarchitectureapp.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var coinAdapter: CoinRecyclerAdapter? = null

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.state.observe(this) {
            if(!it.isLoading) {
                binding.progressBar.visibility = View.INVISIBLE
                if(it.error.isNotBlank()) {
                    binding.errorText.visibility = View.VISIBLE
                    binding.errorText.text = it.error
                } else {
                    binding.recyclerView.visibility = View.VISIBLE
                    coinAdapter = CoinRecyclerAdapter(it.coins)
                    binding.recyclerView.adapter = coinAdapter
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        coinAdapter = null
    }
}