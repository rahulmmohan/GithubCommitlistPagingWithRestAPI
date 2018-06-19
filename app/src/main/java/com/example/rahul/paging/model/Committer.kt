package com.example.rahul.paging.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Committer {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("date")
    @Expose
    var date: String? = null
}