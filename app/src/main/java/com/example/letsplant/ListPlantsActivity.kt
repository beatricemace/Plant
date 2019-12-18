package com.example.letsplant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import com.example.letsplant.Plantlistadapteur
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_list_plants.*
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T

class ListPlantsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_plants)

        val database = (getApplication() as GlobalState).getDatabase()

        // Retrieve the plants from the database
        val plantList = ArrayList<Plant>()
        val plants = database.getListContents()

        if (plants.getCount() === 0) {
            Toast.makeText(this, "There are no contents in this list!", Toast.LENGTH_LONG).show()
        } else {
            while (plants.moveToNext()) {
                val plant = Plant()

                plant.id = plants.getString(plants.getColumnIndex("ID")).toInt()
                plant.name = plants.getString(plants.getColumnIndex("Name"))
                plant.type = plants.getString(plants.getColumnIndex("Type"))
                plant.date = plants.getString(plants.getColumnIndex("Date"))
                plant.description = plants.getString(plants.getColumnIndex("Decription"))
                plantList.add(plant)
            }
        }

        ListofPlants.setAdapter(Plantlistadapteur(this@ListPlantsActivity, plantList))

        // Print in the terminal the plant's name
        plantList.forEach { plant -> println(plant.name) }
    }

    // Open the form to create a new plant
    fun openCreatePlantForm(view: View) {
        startActivity(Intent(this, CreatePlantActivity::class.java))
    }
}
