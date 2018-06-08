package com.example.rahul.githubcommitlist_pagingwithrestapi.datasource

import android.arch.paging.PageKeyedDataSource
import com.example.rahul.githubcommitlist_pagingwithrestapi.api.GitHubClient
import com.example.rahul.githubcommitlist_pagingwithrestapi.api.GitHubService
import com.example.rahul.githubcommitlist_pagingwithrestapi.model.Response
import retrofit2.Call
import retrofit2.Callback

class PageKeyedCommitDataSource : PageKeyedDataSource<Int, Response>() {
    var gitHubService: GitHubService = GitHubClient.getInstance().githubService

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Response>) {
        gitHubService.getCommits(1).enqueue(object : Callback<List<Response>> {
            override fun onFailure(call: Call<List<Response>>?, t: Throwable?) {}

            override fun onResponse(call: Call<List<Response>>?, response: retrofit2.Response<List<Response>>?) {
                if (response!!.isSuccessful && response.code() == 200) {
                    callback.onResult(response.body(), null, 2)
                }
            }
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Response>) {
        gitHubService.getCommits(params.key).enqueue(object : Callback<List<Response>> {
            override fun onFailure(call: Call<List<Response>>?, t: Throwable?) {}

            override fun onResponse(call: Call<List<Response>>?, response: retrofit2.Response<List<Response>>?) {
                if (response!!.isSuccessful && response.code() == 200) {
                    callback.onResult(response.body(), params.key.inc())
                }
            }
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Response>) {}
}