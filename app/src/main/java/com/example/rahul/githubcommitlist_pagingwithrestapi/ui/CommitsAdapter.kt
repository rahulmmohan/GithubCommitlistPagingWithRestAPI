package com.example.rahul.githubcommitlist_pagingwithrestapi.ui

import android.arch.paging.PagedListAdapter
import android.support.v7.recyclerview.extensions.DiffCallback
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.rahul.githubcommitlist_pagingwithrestapi.model.Response

class CommitsAdapter: PagedListAdapter<Response, RecyclerView.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CommitsViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as CommitsViewHolder).bind(getItem(position))
    }

    companion object {
        private val diffCallback = object : DiffCallback<Response>() {
            override fun areItemsTheSame(oldItem: Response, newItem: Response): Boolean = oldItem.htmlUrl == newItem.htmlUrl
            override fun areContentsTheSame(oldItem: Response, newItem: Response): Boolean = oldItem == newItem
        }
    }
}