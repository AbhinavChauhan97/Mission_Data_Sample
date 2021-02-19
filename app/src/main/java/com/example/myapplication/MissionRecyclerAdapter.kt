package com.example.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapplication.model.Mission

class MissionRecyclerAdapter(val missions:List<Mission>) : RecyclerView.Adapter<MissionRecyclerAdapter.MissionViewHolder>() {


    class MissionViewHolder(view: View):RecyclerView.ViewHolder(view){
        val missionNameTextView: TextView
        val wasSuccessfulTextView:TextView
        val flightNumberTextView:TextView
        val launchYearTextView:TextView
        val detailsTextView:TextView
        val image: ImageView
        init {
            missionNameTextView = itemView.findViewById(R.id.mission_name)
            wasSuccessfulTextView = itemView.findViewById(R.id.successful_launch)
            flightNumberTextView = itemView.findViewById(R.id.flightNumber)
            launchYearTextView = itemView.findViewById(R.id.launch_year)
            detailsTextView = itemView.findViewById(R.id.details)
            image = itemView.findViewById(R.id.image)

        }
        fun bind(mission:Mission){
           missionNameTextView.setText("Mission Name   :  " + mission.mission_name)
            wasSuccessfulTextView.setText("Successful launch :  " + mission.launch_success.toString())
            flightNumberTextView.setText("Flight Number :  " + mission.flight_number.toString());
            launchYearTextView.setText("Launch Year :  " + mission.launch_year.toString())
            detailsTextView.setText("Details :  " + mission.details)
            Log.d("log",mission.links.mission_patch_small)
            image.load(mission.links.mission_patch_small){
                placeholder(R.drawable.ic_baseline_theaters_24)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MissionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.row_mission,parent,false)
        return MissionViewHolder(view)
    }

    override fun onBindViewHolder(holder: MissionViewHolder, position: Int) {
       holder.bind(missions.get(position))
    }

    override fun getItemCount(): Int {
       return missions.size
    }

}