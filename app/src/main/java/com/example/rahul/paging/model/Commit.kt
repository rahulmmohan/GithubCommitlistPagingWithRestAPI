package com.example.rahul.paging.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Commit {
    @SerializedName("author")
    @Expose
    var author: Author? = null
    @SerializedName("committer")
    @Expose
    var committer: Committer? = null
    @SerializedName("message")
    @Expose
    var message: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("comment_count")
    @Expose
    var commentCount: Int? = null
}