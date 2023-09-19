package com.hadirahimi.splashandonboarding

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hadirahimi.splashandonboarding.databinding.SlideItemBinding

 class SliderAdapter(private val images : IntArray , private val context : Context) :
    RecyclerView.Adapter<SliderAdapter.SliderViewHolder>()
{
    override fun onCreateViewHolder(parent : ViewGroup , viewType : Int) : SliderViewHolder
    {
        val binding = SlideItemBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return SliderViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder : SliderViewHolder , position : Int)
    {
        val imageRes = images[position]
        holder.binding.imageView.setImageResource(imageRes)
    }
    
    override fun getItemCount() : Int
    {
        return images.size
    }
    
     class SliderViewHolder(var binding : SlideItemBinding) : RecyclerView.ViewHolder(
        binding.root
    )
}