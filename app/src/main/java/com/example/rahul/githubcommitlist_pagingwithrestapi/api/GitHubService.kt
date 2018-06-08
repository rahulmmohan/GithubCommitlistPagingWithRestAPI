package com.example.rahul.githubcommitlist_pagingwithrestapi.api

import com.example.rahul.githubcommitlist_pagingwithrestapi.model.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubService {

    @GET("/repos/rails/rails/commits")
    fun getCommits(@Query("page") page:Int ): Call<List<Response>>
}