package com.myshoppal.ui.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.bumptech.glide.load.model.FileLoader
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.krishna.fileloader.listener.FileRequestListener
import com.krishna.fileloader.pojo.FileResponse
import com.krishna.fileloader.request.FileLoadRequest
import com.myshoppal.R
import kotlinx.android.synthetic.main.activity_paper_year.*
import kotlinx.android.synthetic.main.activity_pdf.*
import java.io.File

class PdfActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf)

        val url = intent.getStringExtra("url")

        if (url != null) {
            loadpdf(url)
        }



    }

    fun loadpdf(url: String){
        progressBar2.visibility = View.VISIBLE
        com.krishna.fileloader.FileLoader.with(this)
            .load(url, false)
            .fromDirectory("test4", com.krishna.fileloader.FileLoader.DIR_INTERNAL)
            .asFile(object : FileRequestListener<File?> {
                override fun onLoad(request: FileLoadRequest, response: FileResponse<File?>) {
                    val loadedFile = response.body
                    pdfviewer.fromFile(loadedFile)
                        .password(null).defaultPage(0)
                        .enableSwipe(true) // allows to block changing pages using swipe
                        .swipeHorizontal(false)
                        .enableDoubletap(true)
                        .onDraw { canvas, pageWidth, pageHeight, displayedPage ->  }
                        .onDrawAll{ canvas, pageWidth, pageHeight, displayedPage -> }
                        .onPageChange{ page, pageCount-> }
                        .onPageError{page, t-> }
                        .onRender { nbPages, pageWidth, pageHeight ->  pdfviewer.fitToWidth()}
                        .onTap{false}
                        .enableAnnotationRendering(false)
                        .invalidPageColor(Color.WHITE)
                        .load();
                }
                override fun onError(request: FileLoadRequest, t: Throwable) {
                    progressBar2.visibility = View.GONE
                    Toast.makeText(this@PdfActivity,"Error While Downloading PDF FILE",Toast.LENGTH_LONG).show()
                }
            })
    }
}