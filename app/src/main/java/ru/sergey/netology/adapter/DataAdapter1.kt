package ru.sergey.netology.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.sergey.netology.R
import ru.sergey.netology.holder.DataViewHolder
import ru.sergey.netology.i.ClickListener
import ru.sergey.netology.pojo.Data
import java.util.*

class DataAdapter(private var items: ArrayList<Data>?) : RecyclerView.Adapter<DataViewHolder>() {
    private var listener: ClickListener? = null
    fun setListener(listener: ClickListener?) {
        this.listener = listener
    }

    fun setItems(items: ArrayList<Data>?) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return DataViewHolder(DataBindingUtil.inflate(inflater, R.layout.item_data, parent, false))
    }

    override fun onBindViewHolder(dataHolder: DataViewHolder, position: Int) {
        val data = items!![position]
        dataHolder.bind(data)
        dataHolder.itemView.setOnClickListener { v: View? -> listener!!.onDataClick(data) }
    }

    override fun getItemCount(): Int {
        return if (items != null) items!!.size else 0
    }
}