package com.example.mycollapse
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.mycollapse.expand.ExpandActivity
import com.example.mycollapse.multicheck.MultiCheckActivity
import com.example.mycollapse.multitype.MultiTypeActivity
import com.example.mycollapse.multitypeandcheck.MultiTypeCheckGenreActivity
import com.example.mycollapse.singlecheck.SingleCheckActivity

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val expand = findViewById<View>(R.id.expand_button) as Button
        expand.setOnClickListener(navigateTo(ExpandActivity::class.java))
        val multiSelect = findViewById<View>(R.id.multi_check_button) as Button
        multiSelect.setOnClickListener(navigateTo(MultiCheckActivity::class.java))
        val singleSelect = findViewById<View>(R.id.single_check_button) as Button
        singleSelect.setOnClickListener(navigateTo(SingleCheckActivity::class.java))
        val mixedSelect = findViewById<View>(R.id.mixedtype_button) as Button
        mixedSelect.setOnClickListener(navigateTo(MultiTypeActivity::class.java))
        val mixedTypeAndCheck = findViewById<View>(R.id.mixedtype_check_button) as Button
        mixedTypeAndCheck.setOnClickListener(navigateTo(MultiTypeCheckGenreActivity::class.java))
    }

    fun navigateTo(clazz: Class<*>?): View.OnClickListener {
        return View.OnClickListener {
            val intent = Intent(this@MainActivity, clazz)
            startActivity(intent)
        }
    }
}