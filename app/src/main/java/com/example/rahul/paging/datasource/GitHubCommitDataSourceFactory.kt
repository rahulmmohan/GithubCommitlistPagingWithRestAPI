package com.example.rahul.paging.datasource

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import com.example.rahul.paging.model.Response

class GitHubCommitDataSourceFactory: DataSource.Factory<Int, Response>() {
    var mutableLiveData: MutableLiveData<PageKeyedCommitDataSource> = MutableLiveData()
    lateinit var pageKeyedCommitDataSource: PageKeyedCommitDataSource
    override fun create(): DataSource<Int, Response> {
        pageKeyedCommitDataSource = PageKeyedCommitDataSource()
        mutableLiveData.postValue(pageKeyedCommitDataSource)
        return pageKeyedCommitDataSource
    }
}