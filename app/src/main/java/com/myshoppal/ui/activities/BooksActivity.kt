package com.myshoppal.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.myshoppal.R
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        val folderArray = resources.getStringArray(R.array.booksactivity)
        var arrayAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,folderArray)
        rv_booksactivity.adapter = arrayAdapter
        rv_booksactivity.setOnItemClickListener { parent, view, position, id ->

            val subbookintent = Intent(applicationContext,SubBooksActivity::class.java)
            subbookintent.putExtra("Folder",folderArray[position])
            startActivity(subbookintent)
        }

    }
}