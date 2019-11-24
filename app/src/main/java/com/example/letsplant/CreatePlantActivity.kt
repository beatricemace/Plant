package com.example.letsplant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_plant.*

const val NEW_PLANT = "com.example.letsplant.NEW_PLANT"

class CreatePlantActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_plant)

        // When the user clicks on the button, it creates a new plant and redirect to the plants list
        button_create_plant.setOnClickListener {
            val newPlant = Plant(
                name = plant_name.text.toString(),
                type = plant_type.text.toString(),
                date = plant_date.text.toString(),
                description = plant_description.text.toString()
            )

            // Send the new plant's data to ListPlantsActivity
            val intent = Intent(this, ListPlantsActivity::class.java)
            intent.putExtra(NEW_PLANT, newPlant)
            startActivity(intent)
        }
    }
}
