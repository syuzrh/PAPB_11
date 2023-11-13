package com.example.papb_11

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.papb_11.databinding.ItemSuperheroBinding
import com.example.papb_11.model.Hero
import com.squareup.picasso.Picasso

class SuperheroAdapter (var heros:List<Hero>): RecyclerView.Adapter<SuperheroAdapter.HeroViewHolder>()
{
    inner class HeroViewHolder(val binding: ItemSuperheroBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val binding = ItemSuperheroBinding.inflate(LayoutInflater.from(parent.context))
        return HeroViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return heros.size
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.itemView.apply {
            with(holder.binding){
                hero.text=heros[position].title
                Picasso.get().load(heros[position].image).into(poster)
            }
        }
    }


}