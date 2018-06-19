package com.example.rahul.paging.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Response {
    @SerializedName("commit")
    @Expose
    var commit: Commit? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("html_url")
    @Expose
    var htmlUrl: String? = null
    @SerializedName("comments_url")
    @Expose
    var commentsUrl: String? = null
    @SerializedName("author")
    @Expose
    var author: Author_? = null
}