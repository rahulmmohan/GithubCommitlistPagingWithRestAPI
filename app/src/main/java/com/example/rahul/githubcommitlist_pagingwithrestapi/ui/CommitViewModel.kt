package com.example.rahul.githubcommitlist_pagingwithrestapi.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.example.rahul.githubcommitlist_pagingwithrestapi.datasource.GitHubCommitDataSourceFactory
import com.example.rahul.githubcommitlist_pagingwithrestapi.model.Response

class CommitViewModel : ViewModel() {
    var commitList: LiveData<PagedList<Response>>

    init {
        val gitHubCommitDataSourceFactory = GitHubCommitDataSourceFactory()
        val pagedListConfig = PagedList.Config.Builder().setEnablePlaceholders(false)
                .setInitialLoadSizeHint(30)
                .setPageSize(30).build()

        commitList = LivePagedListBuilder(gitHubCommitDataSourceFactory, pagedListConfig).build()
    }
}