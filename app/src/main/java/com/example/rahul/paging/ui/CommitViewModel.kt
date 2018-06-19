package com.example.rahul.paging.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.example.rahul.paging.datasource.GitHubCommitDataSourceFactory
import com.example.rahul.paging.datasource.NetworkState
import com.example.rahul.paging.model.Response

class CommitViewModel : ViewModel() {
    var commitList: LiveData<PagedList<Response>>
    var networkState: LiveData<NetworkState>
    init {
        val gitHubCommitDataSourceFactory = GitHubCommitDataSourceFactory()
        val pagedListConfig = PagedList.Config.Builder().setEnablePlaceholders(false)
                .setInitialLoadSizeHint(30)
                .setPageSize(30).build()

        commitList = LivePagedListBuilder(gitHubCommitDataSourceFactory, pagedListConfig).build()
        networkState = Transformations.switchMap(gitHubCommitDataSourceFactory.mutableLiveData) { dataSource -> dataSource.networkState }
    }
}