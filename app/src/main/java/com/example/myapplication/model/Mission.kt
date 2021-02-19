package com.example.myapplication.model

data class Mission(
    val flight_number:Int,
    val mission_name:String,
    val launch_year:Int,
    val launch_success:Boolean,
    val details:String,
    val links:Links
) {
}