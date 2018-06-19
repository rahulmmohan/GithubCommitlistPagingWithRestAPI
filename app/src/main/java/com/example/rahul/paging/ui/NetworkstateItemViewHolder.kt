package com.example.rahul.paging.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rahul.paging.R
import com.example.rahul.paging.datasource.NetworkState
import com.example.rahul.paging.datasource.Status
import kotlinx.android.synthetic.main.network_state_item.view.*


class NetworkstateItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(networkState: NetworkState?) {
        if (networkState != null && networkState.status === Status.RUNNING) {
            view.progress_bar.visibility = View.VISIBLE
        } else {
            view.progress_bar.visibility = View.GONE
        }
    }

    companion object {
        fun create(parent: ViewGroup): NetworkstateItemViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.network_state_item, parent, false)
            return NetworkstateItemViewHolder(view)
        }
    }
}