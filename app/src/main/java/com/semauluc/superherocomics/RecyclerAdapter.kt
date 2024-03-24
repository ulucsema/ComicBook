package com.semauluc.superherocomics

import android.content.Intent
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_row.view.recyclerViewTextView

class RecyclerAdapter (val kahramanListesi: ArrayList<String>,  val kahramanGorseller : ArrayList<Int>) : RecyclerView.Adapter<RecyclerAdapter.SuperKahramanVH>(){
    class SuperKahramanVH (itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperKahramanVH {
         //Inflater
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return SuperKahramanVH(itemView)
    }

    override fun getItemCount(): Int {
        return kahramanListesi.size
    }

    override fun onBindViewHolder(holder: SuperKahramanVH, position: Int) {
       holder.itemView.recyclerViewTextView.text = kahramanListesi.get(position)
       holder.itemView.setOnClickListener{
           val intent = Intent(holder.itemView.context, DescriptionActivity::class.java)
           intent.putExtra("superKahramanIsmi", kahramanListesi.get(position))
           intent.putExtra("superKahramanGorseli", kahramanGorseller.get(position))
           /*
           val singleton = SingletonClass.SecilenKahraman
           singleton.gorsel = kahramanGorseller.get(position)

            */

           holder.itemView.context.startActivity(intent)
       }
    }

}