package ru.sergey.netology.i

import ru.sergey.netology.pojo.Data
import java.util.*

interface IPresenter {
    fun loadData()
    fun showData(data: ArrayList<Data>)
    fun showError(msg: String?)
}