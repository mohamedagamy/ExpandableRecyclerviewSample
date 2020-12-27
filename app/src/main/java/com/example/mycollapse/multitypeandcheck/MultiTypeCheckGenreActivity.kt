package com.example.mycollapse.multitypeandcheck

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import com.example.mycollapse.GenreDataFactory
import com.example.mycollapse.R

class MultiTypeCheckGenreActivity : AppCompatActivity() {
    private var adapter: MultiTypeCheckGenreAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_type_and_check)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = javaClass.simpleName
        val recyclerView = findViewById(R.id.recycler_view) as RecyclerView?
        val layoutManager =
            LinearLayoutManager(this)
        adapter = MultiTypeCheckGenreAdapter(GenreDataFactory.makeSingleCheckGenres())
        recyclerView!!.layoutManager = layoutManager
        recyclerView.adapter = adapter
        val clear = findViewById(R.id.clear_button) as Button?
        clear!!.setOnClickListener { adapter!!.clearChoices() }
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