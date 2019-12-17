package com.example.letsplant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_plant.*

const val NEW_PLANT = "com.example.letsplant.NEW_PLANT"


class CreatePlantActivity : AppCompatActivity() {

    //private val database:DatabaseHelper? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_plant)

        val database = DatabaseHelper(this)
        // When the user clicks on the button, it creates a new plant and redirect to the plants list
        button_create_plant.setOnClickListener {
            val newPlant = Plant()
            newPlant.name = plant_name.text.toString()
            newPlant.type = plant_type.text.toString()
            newPlant.date = plant_date.text.toString()
            newPlant.description = plant_description.text.toString()

            // Retrieve the database instance from the intent
            //val database = intent?.getParcelableExtra<DatabaseHelper>(DATABASE)
            if (database != null) {
                // Save the plant into the local database
                database.addPlant(newPlant)

                // Return to the ListPlantActivity
                val intent = Intent(this, ListPlantsActivity::class.java)
                database.close()
                //intent.putExtra("DATABASE", database)
                startActivity(intent)
            }
        }
    }

}
