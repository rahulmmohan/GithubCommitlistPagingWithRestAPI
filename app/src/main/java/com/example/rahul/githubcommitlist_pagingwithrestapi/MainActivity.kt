package com.example.rahul.githubcommitlist_pagingwithrestapi

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.rahul.githubcommitlist_pagingwithrestapi.ui.CommitViewModel
import com.example.rahul.githubcommitlist_pagingwithrestapi.ui.CommitsAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: CommitViewModel
    private lateinit var commitsAdapter: CommitsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecyclerView()
        viewModel = ViewModelProviders.of(this).get(CommitViewModel::class.java)
        viewModel.commitList.observe(this, Observer {
            commitsAdapter.submitList(it)
        })
    }


    private fun setRecyclerView() {
        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        commitList.layoutManager = llm
        commitsAdapter = CommitsAdapter()
        commitList.adapter = commitsAdapter
    }
}
