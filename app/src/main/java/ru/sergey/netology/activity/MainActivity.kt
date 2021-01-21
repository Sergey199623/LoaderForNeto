package ru.sergey.netology.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import ru.sergey.netology.R
import ru.sergey.netology.adapter.DataAdapter
import ru.sergey.netology.databinding.ActivityDataBinding
import ru.sergey.netology.i.ClickListener
import ru.sergey.netology.i.IView
import ru.sergey.netology.pojo.Data
import ru.sergey.netology.pojo.Group
import ru.sergey.netology.pojo.Item
import ru.sergey.netology.utils.Constants
import ru.sergey.netology.utils.DataPresenter
import java.util.*

class MainActivity : AppCompatActivity(), IView, ClickListener {
    private var ui: ActivityDataBinding? = null
    private var mPresenter: DataPresenter? = null
    private var mDataAdapter: DataAdapter? = null
    private var data: ArrayList<Data>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = DataBindingUtil.setContentView(this, R.layout.activity_data)
        initUI()
    }

    private fun initUI() {
        mPresenter = DataPresenter(this)
        setSupportActionBar(ui!!.toolbar)
        data = ArrayList()
        mDataAdapter = DataAdapter(data)
        mDataAdapter!!.setListener(this)
        ui!!.recycler.adapter = mDataAdapter
        mPresenter!!.loadData()
    }

    override fun showSpinner() {
        ui!!.spinner.visibility = View.VISIBLE
        ui!!.error.visibility = View.GONE
        ui!!.recycler.visibility = View.GONE
    }

    override fun showErrorMsg(msg: String?) {
        ui!!.error.text = msg
        ui!!.spinner.visibility = View.GONE
        ui!!.error.visibility = View.VISIBLE
        ui!!.recycler.visibility = View.GONE
    }

    override fun showData(data: ArrayList<Data>) {
        this.data!!.addAll(data)
        mDataAdapter!!.setItems(data)
        ui!!.spinner.visibility = View.GONE
        ui!!.error.visibility = View.GONE
        ui!!.recycler.visibility = View.VISIBLE
    }

    override fun onDataClick(data: Data?) {
        if (data!!.groups.size > 0) {
            val intent = Intent(this, DataActivity::class.java)
            intent.putExtra("data", data)
            startActivity(intent)
        } else Toast.makeText(this, Constants.MSG_NONE, Toast.LENGTH_SHORT).show()
    }

    override fun onGroupClick(group: Group?) {}
    override fun onItemClick(item: Item?) {}
}