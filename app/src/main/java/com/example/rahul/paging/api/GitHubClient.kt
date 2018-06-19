package com.example.rahul.paging.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GitHubClient {

    var githubService: GitHubService
    private var BASE_URL = "https://api.github.com"

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        githubService = retrofit.create(GitHubService::class.java)
    }

    companion object {
        private val gitHubClient: GitHubClient = GitHubClient()
        @Synchronized
        fun getInstance(): GitHubClient {
            return gitHubClient
        }
    }
}