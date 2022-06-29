package com.example.leagueoflegends

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.leagueoflegends.databinding.ChampionlistRecyclerItemBinding
import java.util.*

class ChampionListRecyclerViewAdpater(
    private val context: Context,
    private val championList: List<Node>?
) : RecyclerView.Adapter<ChampionListRecyclerViewAdpater.ChampionListRecyclerViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChampionListRecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ChampionlistRecyclerItemBinding>(
            layoutInflater,
            R.layout.championlist_recycler_item,
            parent,
            false
        )

        return ChampionListRecyclerViewHolder(binding, context)
    }

    //각 Item마다 bind가 호출되어 list의 position 번째에 있는 값을 보여준다.
    override fun onBindViewHolder(holder: ChampionListRecyclerViewHolder, position: Int) {

        holder.bind(championList!![position])
    }

    override fun getItemCount(): Int {
        return championList!!.size
    }

    inner class ChampionListRecyclerViewHolder(
        val binding: ChampionlistRecyclerItemBinding,
        val context: Context
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Node) {

            binding.data = data.node

            binding.textView.text = data.node.champion_name.toString()
            var championName=data.node.champion_name

            Log.d("response","${championName}")
            var imageURL = data.node.champion_splash
            Glide.with(context).load(imageURL).into(binding.imageView);

            binding.executePendingBindings()
        }

    }
}