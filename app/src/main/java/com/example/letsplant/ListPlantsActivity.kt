package com.example.letsplant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.letsplant.Plantlistadapteur
import kotlinx.android.synthetic.main.activity_list_plants.*

class ListPlantsActivity : AppCompatActivity() {

    private var plants: MutableList<Plant> = mutableListOf<Plant>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_plants)

        val adapter = Plantlistadapteur( this@ListPlantsActivity, plants)
        ListofPlants.adapter = adapter

        val newPlant = intent?.getParcelableExtra<Plant>(NEW_PLANT)
        if (newPlant != null) {
            plants.add(newPlant)
            adapter.notifyDataSetChanged()
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
