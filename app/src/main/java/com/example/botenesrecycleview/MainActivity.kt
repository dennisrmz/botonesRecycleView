package com.example.botenesrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.botenesrecycleview.models.Relleno
import com.example.botenesrecycleview.models.RellenoWrapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.botenesrecycleview.ApiService

class MainActivity : AppCompatActivity() {

    lateinit var mRecyclerView : RecyclerView
    val mAdapter : RecyclerAdapter = RecyclerAdapter()
    var relleno: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        relleno = findViewById(R.id.rellenos)
        relleno!!.setOnClickListener{ setUpRecyclerView() }

        ApiService.create().getRellenos().enqueue(object : Callback<RellenoWrapper>{
            override fun onResponse(
                call: Call<RellenoWrapper>,
                response: Response<RellenoWrapper>
            ) {
                // Muestra informacion de RellenoWrapper en UI
            }

            override fun onFailure(call: Call<RellenoWrapper>, t: Throwable) {
                TODO("not implemented")
            }

        })
    }

    fun setUpRecyclerView(){
        mRecyclerView = findViewById(R.id.buttonListView) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mAdapter.RecyclerAdapter(getPupusas(), this)
        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(this)
    }
    fun getPupusas() : MutableList <Relleno>{
        var pupusas:MutableList<Relleno> = ArrayList()
        pupusas.add(Relleno("Jalapeño", 0, 0,0))
        pupusas.add(Relleno("Queso con Locoro", 0, 0,0))
        pupusas.add(Relleno("Pollo", 0 ,0,0))
        pupusas.add(Relleno("Mora",0 ,0,0))
        pupusas.add(Relleno("Jamon",0,0,0))

        return pupusas
    }


}


