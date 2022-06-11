package com.myshoppal.ui.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.google.firebase.firestore.FirebaseFirestore
import com.myshoppal.R
import kotlinx.android.synthetic.main.activity_books.*
import kotlinx.android.synthetic.main.activity_sub_books.*

class SubBooksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_books)

        val selectedFolder = intent.getStringExtra("Folder")

        if(selectedFolder == "Question Paper"){
            val paperArray = resources.getStringArray(R.array.QuestionPaper)
            val paperAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,paperArray)
            lv_subbooks.adapter = paperAdapter
            lv_subbooks.setOnItemClickListener { parent, view, position, id ->

                val subjectintent = Intent(applicationContext,PaperActivity::class.java)
                subjectintent.putExtra("Field",paperArray[position])
                startActivity(subjectintent)
                finish()
            }
        }


    }
}