package ru.sergey.netology.holder

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.RecyclerView
import ru.sergey.netology.databinding.ItemGroupBinding
import ru.sergey.netology.pojo.Group

class GroupViewHolder(var binding: ItemGroupBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(group: Group) {
        binding.group = group
        binding.executePendingBindings()
        binding.badge.setImageDrawable(ColorDrawable(Color.parseColor(group.badge!!.bgColor)))
    }
}