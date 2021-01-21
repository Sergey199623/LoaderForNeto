package ru.sergey.netology.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.sergey.netology.R
import ru.sergey.netology.holder.ItemViewHolder
import ru.sergey.netology.i.ClickListener
import ru.sergey.netology.pojo.Item
import java.util.*

class ItemAdapter(private var items: ArrayList<Item?>) : RecyclerView.Adapter<ItemViewHolder>() {
    private var listener: ClickListener? = null
    fun setListener(listener: ClickListener?) {
        this.listener = listener
    }

    fun setItems(items: ArrayList<Item?>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(DataBindingUtil.inflate(inflater, R.layout.item_item, parent, false))
    }

    override fun onBindViewHolder(itemHolder: ItemViewHolder, position: Int) {
        val item = items!![position]
        itemHolder.bind(item!!)
        itemHolder.itemView.setOnClickListener { v: View? -> listener!!.onItemClick(item) }
    }

    override fun getItemCount(): Int {
        return if (items != null) items!!.size else 0
    }
}