package ru.sergey.netology.holder

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.RecyclerView
import ru.sergey.netology.databinding.ItemItemBinding
import ru.sergey.netology.pojo.Item

class ItemViewHolder(var binding: ItemItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Item) {
        binding.item = item
        binding.executePendingBindings()
        binding.badge.setImageDrawable(ColorDrawable(Color.parseColor(item.badge!!.bgColor)))
    }
}