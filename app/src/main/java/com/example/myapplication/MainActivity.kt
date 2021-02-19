package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.api.MissionAPI
import com.example.myapplication.api.RetrofitClient
import com.example.myapplication.model.Mission
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val missionApi = RetrofitClient.retrofit.create(MissionAPI::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val missionRecyclerView = findViewById<RecyclerView>(R.id.mission_recyclerview)
        missionRecyclerView.layoutManager = LinearLayoutManager(this)
       //GlobalScope.launch(Dispatchers.IO) {
            val missions = missionApi.getMissions(10)
                .enqueue(object : Callback<List<Mission>> {
                    override fun onResponse(
                        call: Call<List<Mission>>,
                        response: Response<List<Mission>>
                    ) {
                        Log.d("log", response.body().toString())
                        val recyclerAdapter = MissionRecyclerAdapter(response.body()!!)
                        missionRecyclerView.adapter = recyclerAdapter
                    }

                    override fun onFailure(call: Call<List<Mission>>, t: Throwable) {
                        t.printStackTrace()
                    }

                })
            //val recyclerAdapter = MissionRecyclerAdapter(listOf())
           // missionRecyclerView.adapter = recyclerAdapter
       //}
    }
}