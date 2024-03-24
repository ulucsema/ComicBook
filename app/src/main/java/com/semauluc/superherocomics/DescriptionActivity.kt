package com.semauluc.superherocomics

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.android.synthetic.main.activity_description.imageView
import kotlinx.android.synthetic.main.activity_description.textView

class DescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_description)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val intent = intent
        val secilenKahrmanIsmi = intent.getStringExtra("superKahramanIsmi")
        textView.text = secilenKahrmanIsmi

        val secilenKahramanGorseli = intent.getIntExtra("superKahramanGorseli", 0)
        val bitmap = BitmapFactory.decodeResource(applicationContext.resources, secilenKahramanGorseli)
        imageView.setImageBitmap(bitmap)

        /*
        val secilenKahraman = SingletonClass.SecilenKahraman
        val secilenGorsel = secilenKahraman.gorsel
        imageView.setImageBitmap(secilenGorsel)

         */
    }
}