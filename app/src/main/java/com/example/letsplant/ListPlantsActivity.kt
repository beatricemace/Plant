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


    val myDB = DatabaseHelper(this)
    //DatabaseHelper myDB = NULL;ListofPlants

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_plants)

        // Retrieve the database from the intent

        val theList = ArrayList<Plant>()
        val data = myDB.getListContents()
        if (data.getCount() === 0) {
            Toast.makeText(this, "There are no contents in this list!", Toast.LENGTH_LONG).show()
        } else {
            while (data.moveToNext()) {
                val Pla = Plant()

                Pla.id = data.getString(data.getColumnIndex("ID")).toInt()
                Pla.name = data.getString(data.getColumnIndex("Name"))
                Pla.type = data.getString(data.getColumnIndex("Type"))
                Pla.date = data.getString(data.getColumnIndex("Date"))
                Pla.description = data.getString(data.getColumnIndex("Decription"))

                theList.add(Pla)
                val listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, theList)
                ListofPlants.setAdapter(listAdapter)
            }
        }

        // Retrieve the plants from the database
        //val plants = myDB.getPlants()

        val adapter = Plantlistadapteur( this@ListPlantsActivity, theList)
        ListofPlants.adapter = adapter

        // Print in the terminal the plant's name
        //plants.forEach { plant -> println(plant.name) }
    }

    // Open the form to create a new plant
    fun openCreatePlantForm(view: View) {
        val intent = Intent(this, CreatePlantActivity::class.java)
        startActivity(intent)

    }
}
