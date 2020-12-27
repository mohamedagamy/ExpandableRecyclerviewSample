package com.example.mycollapse.multicheck

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import com.example.mycollapse.GenreDataFactory
import com.example.mycollapse.R

class MultiCheckActivity : AppCompatActivity() {
    private var adapter: MultiCheckGenreAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_check)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = javaClass.simpleName
        val recyclerView = findViewById(R.id.recycler_view) as RecyclerView?
        val layoutManager =
            LinearLayoutManager(this)
        adapter = MultiCheckGenreAdapter(GenreDataFactory.makeMultiCheckGenres())
        recyclerView!!.layoutManager = layoutManager
        recyclerView.adapter = adapter
        val clear = findViewById(R.id.clear_button) as Button?
        clear!!.setOnClickListener { adapter!!.clearChoices() }
        val check = findViewById(R.id.check_first_child) as Button?
        check!!.setOnClickListener { adapter!!.checkChild(true, 0, 3) }
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