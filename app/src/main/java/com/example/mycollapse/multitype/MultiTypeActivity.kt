package com.example.mycollapse.multitype

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycollapse.GenreDataFactory
import com.example.mycollapse.R

class MultiTypeActivity : AppCompatActivity() {
    private var adapter: MultiTypeGenreAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_type)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = javaClass.simpleName
        val recyclerView = findViewById(R.id.recycler_view) as RecyclerView?
        val layoutManager =
            LinearLayoutManager(this)
        adapter = MultiTypeGenreAdapter(GenreDataFactory.makeGenres())
        recyclerView!!.layoutManager = layoutManager
        recyclerView.adapter = adapter
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