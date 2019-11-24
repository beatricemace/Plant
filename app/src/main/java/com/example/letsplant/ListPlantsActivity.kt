package com.example.letsplant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ListPlantsActivity : AppCompatActivity() {

    private val plants = mutableListOf<Plant>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_plants)

        val newPlant = intent?.getParcelableExtra<Plant>(NEW_PLANT)
        if (newPlant != null) {
            plants.add(newPlant)
        }
        // Print in the terminal the plant's name
        plants.forEach { plant -> println(plant.name) }
    }

    // Open the form to create a new plant
    fun openCreatePlantForm(view: View) {
        val intent = Intent(this, CreatePlantActivity::class.java)
        startActivity(intent)
    }
}
