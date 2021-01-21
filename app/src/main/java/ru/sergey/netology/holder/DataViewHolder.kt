package ru.sergey.netology.holder

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.RecyclerView
import ru.sergey.netology.databinding.ItemDataBinding
import ru.sergey.netology.pojo.Data

class DataViewHolder(var binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Data) {
        binding.data = data
        binding.executePendingBindings()
        binding.badge.setImageDrawable(ColorDrawable(Color.parseColor(data.direction!!.badge!!.bgColor)))
    }
}