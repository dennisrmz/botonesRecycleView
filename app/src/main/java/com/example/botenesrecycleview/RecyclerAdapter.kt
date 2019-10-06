package com.example.botenesrecycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.botenesrecycleview.models.Pupusa

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    var pupusas: MutableList<Pupusa> = ArrayList()
    lateinit var context:Context

    fun RecyclerAdapter(pupusas: MutableList<Pupusa>, context: Context){
        this.pupusas = pupusas
        this.context = context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_button_list, parent, false))
    }

    override fun getItemCount(): Int {
        return pupusas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = pupusas.get(position)
        holder.bind(item, context)
    }



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var rellenoPupusaArroz = view.findViewById<Button>(R.id.buttonArroz)
        var rellenoPupusaMaiz = view.findViewById<Button>(R.id.buttonMaiz)



        fun bind(pupusa: Pupusa,    context: Context){
            rellenoPupusaArroz.text = pupusa.pupusa
            rellenoPupusaMaiz.text = pupusa.pupusa
            rellenoPupusaArroz.setOnClickListener {
                pupusa.cantidadArroz += 1
                Toast.makeText(context," ${pupusa.pupusa}${pupusa.cantidadArroz}", Toast.LENGTH_SHORT).show() }
            rellenoPupusaMaiz.setOnClickListener {
                pupusa.cantidadMaiz += 1
                Toast.makeText(context," ${pupusa.pupusa}${pupusa.cantidadMaiz}", Toast.LENGTH_SHORT).show() }
        }
    }

}