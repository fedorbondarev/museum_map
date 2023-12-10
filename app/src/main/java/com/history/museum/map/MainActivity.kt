package com.history.museum.map

import androidx.appcompat.app.AppCompatActivity
import com.history.museum.map.data.Repository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main){
    @Inject
    lateinit var repository: Repository
}