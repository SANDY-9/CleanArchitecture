package com.example.cleanarchitectureapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitectureapp.databinding.CoinRowBinding
import com.example.domain.model.Coin


class CoinRecyclerAdapter(val coinList: List<Coin>): RecyclerView.Adapter<CoinRecyclerAdapter.CoinViewHolder>() {
    inner class CoinViewHolder(val binding: CoinRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val binding = CoinRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.binding.coinName.text = coinList[position].name
    }

    override fun getItemCount() = coinList.size
}