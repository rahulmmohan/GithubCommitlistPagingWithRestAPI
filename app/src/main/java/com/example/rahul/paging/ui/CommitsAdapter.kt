package com.example.rahul.paging.ui

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.rahul.paging.R
import com.example.rahul.paging.datasource.NetworkState
import com.example.rahul.paging.model.Response

class CommitsAdapter: PagedListAdapter<Response, RecyclerView.ViewHolder>(diffCallback) {
    private var networkState: NetworkState? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            R.layout.item_commit_list -> run {
                return CommitsViewHolder.create(parent)
            }
            R.layout.network_state_item -> run {
                return NetworkstateItemViewHolder.create(parent)
            }
            else -> run { throw IllegalArgumentException("unknown view type") }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            R.layout.item_commit_list -> (holder as CommitsViewHolder).bind(getItem(position))
            R.layout.network_state_item -> (holder as NetworkstateItemViewHolder).bind(networkState)
        }
    }

    fun setNetworkState(newNetworkState: NetworkState) {
        val previousState = this.networkState
        val previousExtraRow = hasExtraRow()
        this.networkState = newNetworkState
        val newExtraRow = hasExtraRow()
        if (previousExtraRow != newExtraRow) {
            if (previousExtraRow) {
                notifyItemRemoved(itemCount)
            } else {
                notifyItemInserted(itemCount)
            }
        } else if (newExtraRow && previousState !== newNetworkState) {
            notifyItemChanged(itemCount - 1)
        }
    }

    private fun hasExtraRow(): Boolean {
        return networkState != null && networkState !== NetworkState.LOADED
    }

    override fun getItemViewType(position: Int): Int {
        return if (hasExtraRow() && position == itemCount - 1) {
            R.layout.network_state_item
        } else {
            R.layout.item_commit_list
        }
    }
    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Response>() {
            override fun areItemsTheSame(oldItem: Response, newItem: Response): Boolean = oldItem.htmlUrl == newItem.htmlUrl
            override fun areContentsTheSame(oldItem: Response, newItem: Response): Boolean = oldItem == newItem
        }
    }
}