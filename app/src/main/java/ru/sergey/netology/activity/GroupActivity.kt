package ru.sergey.netology.activity

import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import ru.sergey.netology.R
import ru.sergey.netology.adapter.ItemAdapter
import ru.sergey.netology.databinding.ActivityContentBinding
import ru.sergey.netology.i.ClickListener
import ru.sergey.netology.pojo.Data
import ru.sergey.netology.pojo.Group
import ru.sergey.netology.pojo.Item
import ru.sergey.netology.utils.Constants
import java.util.*

class GroupActivity : AppCompatActivity(), ClickListener {
    private var ui: ActivityContentBinding? = null
    private var mItemAdapter: ItemAdapter? = null
    var group: Group? = null
    var builder: CustomTabsIntent.Builder? = null
    var customTabsIntent: CustomTabsIntent? = null
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("group", group)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = DataBindingUtil.setContentView(this, R.layout.activity_content)
        group = if (savedInstanceState != null) savedInstanceState.getParcelable("group") else intent.getParcelableExtra("group")
        initUI()
    }

    private fun initUI() {
        setSupportActionBar(ui!!.toolbar)
        title = group!!.title
        if (supportActionBar != null) supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        builder = CustomTabsIntent.Builder()
        customTabsIntent = builder!!.build()
        builder!!.setShowTitle(true)
        val params = CustomTabColorSchemeParams.Builder()
                .setNavigationBarColor(ContextCompat.getColor(this, R.color.colorPrimary))
                .build()
        builder!!.setDefaultColorSchemeParams(params)
        //builder.setColorScheme(params);
        mItemAdapter = ItemAdapter(group!!.items as ArrayList<Item?>)
        mItemAdapter!!.setListener(this)
        ui!!.recycler.adapter = mItemAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) super.onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    override fun onDataClick(data: Data?) {}
    override fun onGroupClick(group: Group?) {}
    override fun onItemClick(item: Item?) {
        var link = item!!.link
        if (link == null) Toast.makeText(this, Constants.MSG_NONE, Toast.LENGTH_SHORT).show() else {
            if (!item.link!!.startsWith("https://netology.ru")) {
                link = "https://netology.ru" + item.link
            }
            customTabsIntent!!.launchUrl(this, Uri.parse(link))
        }
    }
}