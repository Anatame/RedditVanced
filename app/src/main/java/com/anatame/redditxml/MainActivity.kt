package com.anatame.redditxml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.anatame.redditxml.Presentation.Adapters.HomeRecyclerViewAdapter
import com.anatame.redditxml.Presentation.ViewModels.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeRecyclerView.layoutManager = LinearLayoutManager(this)
        lifecycleScope.launchWhenStarted {
//            Log.d("apires", viewModel.state.value.posts.toString())
//            val items = viewModel.state.value.posts
//            homeRecyclerView.adapter = HomeRecyclerViewAdapter(items)

            viewModel.state.collect{ it ->
                homeRecyclerView.adapter = HomeRecyclerViewAdapter(it.posts)
            }
        }




    }
}