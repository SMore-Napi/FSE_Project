package com.example.innorussian.home_fragment.phrasebook.topic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.example.innorussian.BehetleInfo
import com.example.innorussian.MagnitInfo
import com.example.innorussian.PyatorochkaInfo
import com.example.innorussian.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener

class TopicActivity : AppCompatActivity() {
    private lateinit var topicName: String

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        topicName = intent.getStringExtra("topic").toString()

        title = topicName
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        tabLayout.addTab(tabLayout.newTab().setText("Info"))
        tabLayout.addTab(tabLayout.newTab().setText("Phrases"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = TabLayoutAdapter(
            this, supportFragmentManager,
            tabLayout.tabCount, topicName
        )

        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.topic_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.qr_code -> {
            val qrCodeActivity = Intent(this, QRCodeImageActivity::class.java)
            qrCodeActivity.putExtra("topic", topicName)
            startActivity(qrCodeActivity)
            true
        }
        R.id.add_new -> {
            val addWordActivity = Intent(this, AddNewWord::class.java)
            addWordActivity.putExtra("topic", topicName)
            startActivity(addWordActivity)
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    fun openPyatorochka(view: View) {
        val nextFrag = PyatorochkaInfo()
        this.supportFragmentManager.beginTransaction()
            .replace(R.id.supermarkets, nextFrag, "findThisFragment")
            .addToBackStack(null)
            .commit()
    }

    fun openMagnit(view: View) {
        val nextFrag = MagnitInfo()
        this.supportFragmentManager.beginTransaction()
            .replace(R.id.supermarkets, nextFrag, "findThisFragment")
            .addToBackStack(null)
            .commit()
    }

    fun openBehetle(view: View) {
        val nextFrag = BehetleInfo()
        this.supportFragmentManager.beginTransaction()
            .replace(R.id.supermarkets, nextFrag, "findThisFragment")
            .addToBackStack(null)
            .commit()
    }
}