package ru.sergey.netology.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.sergey.netology.R
import ru.sergey.netology.holder.GroupViewHolder
import ru.sergey.netology.i.ClickListener
import ru.sergey.netology.pojo.Group
import java.util.*

class GroupAdapter(private var items: ArrayList<Group?>) : RecyclerView.Adapter<GroupViewHolder>() {
    private var listener: ClickListener? = null
    fun setListener(listener: ClickListener?) {
        this.listener = listener
    }

    fun setItems(items: ArrayList<Group?>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return GroupViewHolder(DataBindingUtil.inflate(inflater, R.layout.item_group, parent, false))
    }

    override fun onBindViewHolder(groupHolder: GroupViewHolder, position: Int) {
        val group = items!![position]
        groupHolder.bind(group!!)
        groupHolder.itemView.setOnClickListener { v: View? -> listener!!.onGroupClick(group) }
    }

    override fun getItemCount(): Int {
        return if (items != null) items!!.size else 0
    }
}