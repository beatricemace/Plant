package com.example.letsplant

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

public class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Start the application by opening the creation form
    fun startApplication(view: View) {
        startActivity(Intent(this, CreatePlantActivity::class.java))
    }
}
