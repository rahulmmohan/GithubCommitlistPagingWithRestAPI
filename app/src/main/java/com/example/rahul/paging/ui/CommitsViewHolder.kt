package com.example.rahul.paging.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rahul.paging.R
import com.example.rahul.paging.model.Response
import kotlinx.android.synthetic.main.item_commit_list.view.*


class CommitsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    private var data: Response? = null

    fun bind(data: Response?) {
        this.data = data
        view.personName.text = data?.commit?.author?.name ?: ""
        view.commitMessage.text = data?.commit?.message ?: ""
    }

    companion object {
        fun create(parent: ViewGroup): CommitsViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_commit_list, parent, false)
            return CommitsViewHolder(view)
        }
    }
}