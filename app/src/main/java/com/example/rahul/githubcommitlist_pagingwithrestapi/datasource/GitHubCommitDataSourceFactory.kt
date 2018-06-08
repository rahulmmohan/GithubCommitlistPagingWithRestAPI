package com.example.rahul.githubcommitlist_pagingwithrestapi.datasource

import android.arch.paging.DataSource
import com.example.rahul.githubcommitlist_pagingwithrestapi.model.Response

class GitHubCommitDataSourceFactory: DataSource.Factory<Int, Response>() {

    lateinit var pageKeyedCommitDataSource: PageKeyedCommitDataSource
    override fun create(): DataSource<Int, Response> {
        pageKeyedCommitDataSource = PageKeyedCommitDataSource()
        return pageKeyedCommitDataSource
    }
}