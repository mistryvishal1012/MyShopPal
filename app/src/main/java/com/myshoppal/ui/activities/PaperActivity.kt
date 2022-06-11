package com.myshoppal.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.myshoppal.R
import kotlinx.android.synthetic.main.activity_paper.*
import kotlinx.android.synthetic.main.activity_sub_books.*


class PaperActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paper)

        val fieldName = intent.getStringExtra("Field")
        if (fieldName == "Computer" || fieldName == "Information Technology" ) {
            val subjectsArray = resources.getStringArray(R.array.Computer)
            val subjectsAdapter =
                ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, subjectsArray)
            lv_subjectsname.adapter = subjectsAdapter
            lv_subjectsname.setOnItemClickListener { parent, view, position, id ->

                val subjectyearintent = Intent(applicationContext, PaperYearActivity::class.java)
                subjectyearintent.putExtra("Subject", subjectsArray[position])
                subjectyearintent.putExtra("Field", fieldName)
                startActivity(subjectyearintent)
                finish()


            }
            if (fieldName == "Electrical") {
                val subjectsArray = resources.getStringArray(R.array.Computer)
                val subjectsAdapter =
                    ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, subjectsArray)
                lv_subjectsname.adapter = subjectsAdapter
                lv_subjectsname.setOnItemClickListener { parent, view, position, id ->

                    val subjectyearintent =
                        Intent(applicationContext, PaperYearActivity::class.java)
                    subjectyearintent.putExtra("Subject", subjectsArray[position])
                    subjectyearintent.putExtra("Field", fieldName)
                    startActivity(subjectyearintent)
                    finish()


                }
            }
            if (fieldName == "Mechnical") {
                val subjectsArray = resources.getStringArray(R.array.Computer)
                val subjectsAdapter =
                    ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, subjectsArray)
                lv_subjectsname.adapter = subjectsAdapter
                lv_subjectsname.setOnItemClickListener { parent, view, position, id ->

                    val subjectyearintent =
                        Intent(applicationContext, PaperYearActivity::class.java)
                    subjectyearintent.putExtra("Subject", subjectsArray[position])
                    subjectyearintent.putExtra("Field", fieldName)
                    startActivity(subjectyearintent)
                    finish()


                }
            }
        }
    }
}