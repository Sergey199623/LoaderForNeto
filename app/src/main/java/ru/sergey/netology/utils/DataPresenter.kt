package ru.sergey.netology.utils

import ru.sergey.netology.i.IModel
import ru.sergey.netology.i.IPresenter
import ru.sergey.netology.i.IView
import ru.sergey.netology.model.DataModel
import ru.sergey.netology.pojo.Data
import java.util.*

class DataPresenter(private val mView: IView) : IPresenter {
    private val mModel: IModel
    override fun loadData() {
        mView.showSpinner()
        mModel.data
    }

    override fun showData(data: ArrayList<Data>) {
        mView.showData(data)
    }

    override fun showError(msg: String?) {
        mView.showErrorMsg(msg)
    }

    init {
        mModel = DataModel(this)
    }
}