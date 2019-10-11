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
    var mAdapter : RecyclerAdapter = RecyclerAdapter()
    var relleno: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        relleno = findViewById(R.id.rellenos)
//        relleno!!.setOnClickListener{ setUpRecyclerView() }
        mAdapter = RecyclerAdapter(arrayListOf<Relleno>(), this)
        ApiService.create().getRellenos().enqueue(object : Callback<List<Relleno>>{
            override fun onResponse(
                call: Call<List<Relleno>>,
                response: Response<List<Relleno>>
            ) {
                if(response.isSuccessful){
                    val rellenos = response.body()!! as ArrayList<Relleno>
                    mAdapter.pupusas = rellenos
                    mAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<Relleno>>, t: Throwable) {
                TODO("not implemented")
            }

        })

    }

    fun getPupusas() : MutableList <Relleno>{
        var pupusas:MutableList<Relleno> = ArrayList()

        return pupusas
    }
//    fun setUpRecyclerView(){
//        mRecyclerView = findViewById(R.id.buttonListView) as RecyclerView
//        mRecyclerView.setHasFixedSize(true)
//        mAdapter.RecyclerAdapter(getPupusas(), this)
//        mRecyclerView.adapter = mAdapter
//        mRecyclerView.layoutManager = LinearLayoutManager(this)
//    }



}


