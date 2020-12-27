package com.example.mycollapse.expand

import android.view.View
import android.widget.TextView
import com.example.mycollapse.R
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder

class ArtistViewHolder(itemView: View) : ChildViewHolder(itemView) {
    private val childTextView: TextView
    fun setArtistName(name: String?) {
        childTextView.text = name
    }

    init {
        childTextView = itemView.findViewById<View>(R.id.list_item_artist_name) as TextView
    }
}