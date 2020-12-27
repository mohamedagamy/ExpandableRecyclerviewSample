package com.example.mycollapse.multicheck

import android.view.View
import android.widget.Checkable
import android.widget.CheckedTextView
import com.example.mycollapse.R
import com.thoughtbot.expandablecheckrecyclerview.viewholders.CheckableChildViewHolder

class MultiCheckArtistViewHolder(itemView: View) : CheckableChildViewHolder(itemView) {
    private val childCheckedTextView: CheckedTextView
    override fun getCheckable(): Checkable {
        return childCheckedTextView
    }

    fun setArtistName(artistName: String?) {
        childCheckedTextView.text = artistName
    }

    init {
        childCheckedTextView =
            itemView.findViewById<View>(R.id.list_item_multicheck_artist_name) as CheckedTextView
    }
}