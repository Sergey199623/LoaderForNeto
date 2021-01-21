package ru.sergey.netology.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

import ru.sergey.netology.R
import ru.sergey.netology.adapter.GroupAdapter
import ru.sergey.netology.databinding.ActivityContentBinding
import ru.sergey.netology.i.ClickListener
import ru.sergey.netology.pojo.Data
import ru.sergey.netology.pojo.Group
import ru.sergey.netology.pojo.Item
import ru.sergey.netology.utils.Constants
import java.util.*

class DataActivity : AppCompatActivity(), ClickListener {

    private var ui: ActivityContentBinding? = null
    private var mGroupAdapter: GroupAdapter? = null
    var data: Data? = null

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("data", data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = DataBindingUtil.setContentView(this, R.layout.activity_content)
        data = if (savedInstanceState != null) savedInstanceState.getParcelable("data") else intent.getParcelableExtra("data")
        initUI()
    }

    private fun initUI() {
        setSupportActionBar(ui!!.toolbar)
        title = data!!.direction!!.title
        if (supportActionBar != null) supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        mGroupAdapter = GroupAdapter(data!!.groups as ArrayList<Group?>)
        mGroupAdapter!!.setListener(this)
        ui!!.recycler.adapter = mGroupAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) super.onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    override fun onDataClick(data: Data?) {}
    override fun onGroupClick(group: Group?) {
        if (group!!.items.size > 0) {
            val intent = Intent(this, GroupActivity::class.java)
            intent.putExtra("group", group)
            startActivity(intent)
        } else Toast.makeText(this, Constants.MSG_NONE, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClick(item: Item?) {}
}