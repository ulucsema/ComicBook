package com.semauluc.superherocomics

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.recyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Veri Hazırlığı

        var superKahramanIsimleri = ArrayList<String>()
        superKahramanIsimleri.add("Batman")
        superKahramanIsimleri.add("Ironman")
        superKahramanIsimleri.add("Spiderman")
        superKahramanIsimleri.add("Star Lord")
        superKahramanIsimleri.add("Vanda")

        /*  //verimsiz Tanımlamalar
        val batmanBitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.batman)
        val ironmanBitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.ironman)
        val spidermanBitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.spiderman)
        val starlordBitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.starlord)
        val vandaBitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.vanda)


        var superKahramanGorselleri = ArrayList<Bitmap> ()
        superKahramanGorselleri.add(batmanBitmap)
        superKahramanGorselleri.add(ironmanBitmap)
        superKahramanGorselleri.add(spidermanBitmap)
        superKahramanGorselleri.add(starlordBitmap)
        superKahramanGorselleri.add(vandaBitmap)

         */

        //Verimli Tanımlar

        val batmanDrawableId = R.drawable.batman
        val ironmanDrawableId = R.drawable.ironman
        val spidermanDrawable = R.drawable.spiderman
        val starlordDrawable = R.drawable.starlord
        val vandaDrawable = R.drawable.vanda

        var superKahramanDrawableListesi = ArrayList<Int> ()
        superKahramanDrawableListesi.add(batmanDrawableId)
        superKahramanDrawableListesi.add(ironmanDrawableId)
        superKahramanDrawableListesi.add(spidermanDrawable)
        superKahramanDrawableListesi.add(starlordDrawable)
        superKahramanDrawableListesi.add(vandaDrawable)




        //Adapter
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val adapter = RecyclerAdapter (superKahramanIsimleri, superKahramanDrawableListesi)
        recyclerView.adapter = adapter
    }

}