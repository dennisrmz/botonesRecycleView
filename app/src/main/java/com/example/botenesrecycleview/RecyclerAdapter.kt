package com.example.botenesrecycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.botenesrecycleview.models.Relleno

class RecyclerAdapter(var pupusas: MutableList<Relleno>, listener: ViewHolderListener ) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_button_list, parent, false), listener)
    }

    override fun getItemCount(): Int {
        return pupusas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = pupusas.get(position)
        holder.bind(item)
    }



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var rellenoPupusaArroz = view.findViewById<Button>(R.id.buttonArroz)
        var rellenoPupusaMaiz = view.findViewById<Button>(R.id.buttonMaiz)



        fun bind(pupusa: Relleno){
            rellenoPupusaArroz.text = pupusa.nombre
            rellenoPupusaMaiz.text = pupusa.nombre
            rellenoPupusaArroz.setOnClickListener {
                pupusa.cantidadArroz += 1
                Toast.makeText(itemView.context," ${pupusa.nombre}${pupusa.cantidadArroz}", Toast.LENGTH_SHORT).show() }
            rellenoPupusaMaiz.setOnClickListener {
                pupusa.cantidadMaiz += 1
                Toast.makeText(itemView.context," ${pupusa.nombre}${pupusa.cantidadMaiz}", Toast.LENGTH_SHORT).show() }
        }
    }

    class ViewHolderListener {

    }

}