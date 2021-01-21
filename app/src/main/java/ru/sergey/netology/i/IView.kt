package ru.sergey.netology.i

import ru.sergey.netology.pojo.Data
import java.util.*

interface IView {
    fun showSpinner()
    fun showErrorMsg(msg: String?)
    fun showData(data: ArrayList<Data>)
}