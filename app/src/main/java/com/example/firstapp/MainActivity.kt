package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

const val EXTRA_MESSAGE = "com.example.firstapp.MESSAGE"

class MainActivity : AppCompatActivity() {

    private var showedCat = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendMessage(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        val message = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    fun showCat(view: View) {
        val catBtn = findViewById<Button>(R.id.catButton)
        if (!showedCat){
            catBtn.setText(R.string.getAnotherCat)
        }
        showedCat = true
        val catView = findViewById<WebView>(R.id.catView)
        catView.clearCache(true)
        catView.loadUrl("https://cataas.com/cat/gif")
        Log.i("showCatClick", "Clicked showCatButton")
    }
}
