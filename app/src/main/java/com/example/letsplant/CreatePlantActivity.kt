package com.example.letsplant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_plant.*

class CreatePlantActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_plant)

        val database = (getApplication() as GlobalState).getDatabase()

        // When the user clicks on the button, it creates a new plant and redirects to the plants list
        button_create_plant.setOnClickListener {
            val newPlant = Plant()

            newPlant.name = plant_name.text.toString()
            newPlant.type = plant_type.text.toString()
            newPlant.date = plant_date.text.toString()
            newPlant.description = plant_description.text.toString()

            // Save the plant into the local database
            database.addPlant(newPlant)

            // Return to the ListPlantActivity
            startActivity(Intent(this, ListPlantsActivity::class.java))
        }
    }
}
