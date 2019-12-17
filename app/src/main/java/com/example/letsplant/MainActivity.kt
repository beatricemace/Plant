package com.example.letsplant

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

const val DATABASE = "com.example.letsplant.DATABASE"

public class MainActivity : AppCompatActivity() {

    private var database: DatabaseHelper? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = DatabaseHelper(this)
        setContentView(R.layout.activity_main)
    }

    // Start the application by opening the creation form
    fun startApplication(view: View) {
        val intent = Intent(this, CreatePlantActivity::class.java)
        startActivity(intent)
    }

}


