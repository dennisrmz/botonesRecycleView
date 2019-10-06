package com.example.botenesrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.botenesrecycleview.models.Pupusa

class MainActivity : AppCompatActivity() {

    lateinit var mRecyclerView : RecyclerView
    val mAdapter : RecyclerAdapter = RecyclerAdapter()
    var relleno: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        relleno = findViewById(R.id.rellenos)
        relleno!!.setOnClickListener{ setUpRecyclerView() }
    }

    fun setUpRecyclerView(){
        mRecyclerView = findViewById(R.id.buttonListView) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mAdapter.RecyclerAdapter(getPupusas(), this)
        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(this)
    }
    fun getPupusas() : MutableList <Pupusa>{
        var pupusas:MutableList<Pupusa> = ArrayList()
        pupusas.add(Pupusa("Jalapeño", 0, 0))
        pupusas.add(Pupusa("Queso con Locoro", 0, 0))
        pupusas.add(Pupusa("Pollo", 0 ,0))
        pupusas.add(Pupusa("Mora",0 ,0))
        pupusas.add(Pupusa("Jamon",0,0))

        return pupusas
    }
}
