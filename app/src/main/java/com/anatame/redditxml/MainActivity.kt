package com.anatame.redditxml

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.anatame.redditxml.Presentation.Adapters.HomeRecyclerViewAdapter
import com.anatame.redditxml.Presentation.ViewModels.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    private val viewModel: MainActivityViewModel by viewModels()
    private val context: Context = this@MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        setSupportActionBar(materialToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)


        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.mItem1 -> Toast.makeText(context, "Clicked item 1", Toast.LENGTH_SHORT).show()
                R.id.mItem2 -> Toast.makeText(context, "Clicked item 2", Toast.LENGTH_SHORT).show()
                R.id.mItem3 -> Toast.makeText(context, "Clicked item 3", Toast.LENGTH_SHORT).show()
            }

            true
        }


        homeRecyclerView.layoutManager = LinearLayoutManager(this)
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect{ it ->
                homeRecyclerView.adapter = HomeRecyclerViewAdapter(it.posts, context)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}