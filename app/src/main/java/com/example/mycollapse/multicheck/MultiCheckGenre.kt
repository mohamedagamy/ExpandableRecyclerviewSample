package com.example.mycollapse.multicheck

import com.example.mycollapse.Artist
import com.thoughtbot.expandablecheckrecyclerview.models.MultiCheckExpandableGroup

class MultiCheckGenre(title: String?, items: List<Artist?>?, val iconResId: Int) :
    MultiCheckExpandableGroup(title, items)