package com.myshoppal.ui.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.krishna.fileloader.FileLoader
import com.krishna.fileloader.listener.FileRequestListener
import com.krishna.fileloader.pojo.FileResponse
import com.krishna.fileloader.request.FileLoadRequest
import com.myshoppal.R
import kotlinx.android.synthetic.main.activity_paper_year.*
import java.io.File


class PaperYearActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paper_year)

        var field = intent.getStringExtra("Field")
        var subject = intent.getStringExtra("Subject")
        if (field != null) {
            Log.i("PaperActivity",field)
        }
        if (subject != null) {
            Log.i("PaperActivity",subject)
        }
        val strReference = Firebase.storage.reference
        val subjectsyearArray = resources.getStringArray(R.array.Year)
        val subjectsyearAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, subjectsyearArray)
        lv_subjectyear.adapter = subjectsyearAdapter
        lv_subjectyear.setOnItemClickListener { parent, view, position, id ->
            var url:String?
            val year = subjectsyearArray[position]
            Log.i("PaperActivity",year)
            val fname = "$subject" + "_" + "$year" + ".pdf"
            val path = "$field" + "/" + "$subject"
            val pdfRef = strReference.child(path)
            var urlforDownload = pdfRef.child(fname).downloadUrl.addOnSuccessListener {
                url = it.toString()
                val pdfintent = Intent(applicationContext,PdfActivity::class.java)
                pdfintent.putExtra("url",url)
                startActivity(pdfintent)
                Log.i("PaperActivity", url.toString())
            }

        }
    }
}


