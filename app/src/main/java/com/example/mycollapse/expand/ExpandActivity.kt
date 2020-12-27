package com.example.mycollapse.expand

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import com.example.mycollapse.GenreDataFactory
import com.example.mycollapse.R

class ExpandActivity : AppCompatActivity() {
    var adapter: GenreAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expand)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = javaClass.simpleName
        val recyclerView = findViewById(R.id.recycler_view) as RecyclerView?
        val layoutManager =
            LinearLayoutManager(this)

        // RecyclerView has some built in animations to it, using the DefaultItemAnimator.
        // Specifically when you call notifyItemChanged() it does a fade animation for the changing
        // of the data in the ViewHolder. If you would like to disable this you can use the following:
        val animator = recyclerView!!.itemAnimator
        if (animator is DefaultItemAnimator) {
            animator.supportsChangeAnimations = false
        }
        adapter = GenreAdapter(GenreDataFactory.makeGenres())
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter as? RecyclerView.Adapter<*>
        val clear = findViewById(R.id.toggle_button) as Button?
        clear!!.setOnClickListener { adapter!!.toggleGroup(GenreDataFactory.makeClassicGenre()) }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        adapter!!.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        adapter!!.onRestoreInstanceState(savedInstanceState)
    }
}