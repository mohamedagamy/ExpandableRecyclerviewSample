package com.example.mycollapse.multicheck

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mycollapse.Artist
import com.example.mycollapse.R
import com.example.mycollapse.expand.GenreViewHolder
import com.thoughtbot.expandablecheckrecyclerview.CheckableChildRecyclerViewAdapter
import com.thoughtbot.expandablecheckrecyclerview.models.CheckedExpandableGroup
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup

class MultiCheckGenreAdapter(groups: List<MultiCheckGenre?>?) :
    CheckableChildRecyclerViewAdapter<GenreViewHolder, MultiCheckArtistViewHolder>(groups) {
    override fun onCreateCheckChildViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MultiCheckArtistViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_multicheck_artist, parent, false)
        return MultiCheckArtistViewHolder(view)
    }

    override fun onBindCheckChildViewHolder(
        holder: MultiCheckArtistViewHolder, position: Int,
        group: CheckedExpandableGroup, childIndex: Int
    ) {
        val artist = group.items[childIndex] as Artist
        holder.setArtistName(artist.name)
    }

    override fun onCreateGroupViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_genre, parent, false)
        return GenreViewHolder(view)
    }

    override fun onBindGroupViewHolder(
        holder: GenreViewHolder, flatPosition: Int,
        group: ExpandableGroup<*>
    ) {
        holder.setGenreTitle(group)
    }
}