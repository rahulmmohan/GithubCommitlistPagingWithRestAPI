package com.example.rahul.paging.datasource

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PageKeyedDataSource
import com.example.rahul.paging.api.GitHubClient
import com.example.rahul.paging.api.GitHubService
import com.example.rahul.paging.model.Response
import retrofit2.Call
import retrofit2.Callback

class PageKeyedCommitDataSource : PageKeyedDataSource<Int, Response>() {
    var gitHubService: GitHubService = GitHubClient.getInstance().githubService
    var networkState: MutableLiveData<NetworkState> = MutableLiveData()

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Response>) {
        networkState.postValue(NetworkState.LOADING)
        gitHubService.getCommits(1).enqueue(object : Callback<List<Response>> {
            override fun onFailure(call: Call<List<Response>>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<List<Response>>?, response: retrofit2.Response<List<Response>>?) {
                if (response!!.isSuccessful && response.code() == 200) {
                    callback.onResult(response.body(), null, 2)
                    networkState.postValue(NetworkState.LOADED)
                }else{
                    networkState.postValue(NetworkState(Status.FAILED, response.message()))
                }
            }
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Response>) {
        networkState.postValue(NetworkState.LOADING)
        gitHubService.getCommits(params.key).enqueue(object : Callback<List<Response>> {
            override fun onFailure(call: Call<List<Response>>?, t: Throwable?) {}

            override fun onResponse(call: Call<List<Response>>?, response: retrofit2.Response<List<Response>>?) {
                if (response!!.isSuccessful && response.code() == 200) {
                    callback.onResult(response.body(), params.key.inc())
                    networkState.postValue(NetworkState.LOADED)
                }else{
                    networkState.postValue(NetworkState(Status.FAILED, response.message()))
                }
            }
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Response>) {}
}