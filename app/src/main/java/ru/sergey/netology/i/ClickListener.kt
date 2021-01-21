package ru.sergey.netology.i

import ru.sergey.netology.pojo.Data
import ru.sergey.netology.pojo.Group
import ru.sergey.netology.pojo.Item

interface ClickListener {
    fun onDataClick(data: Data?)
    fun onGroupClick(group: Group?)
    fun onItemClick(item: Item?)
}