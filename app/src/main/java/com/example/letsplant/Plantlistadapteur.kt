package com.example.letsplant

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.TextView
import com.example.letsplant.Plant
import com.example.letsplant.R
import kotlinx.android.synthetic.main.row_layout.view.*

class Plantlistadapteur(
    internal var activity: Activity,
    internal var plantList: MutableList<Plant>
    //internal var Id: TextView
    //internal var plantName: EditText,
    //internal var planttype: EditText,
    //internal var plantdate: EditText,
    //internal var plantdescription: EditText
): BaseAdapter() {

    internal var inflater: LayoutInflater

    init {
        inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView:View

        rowView = inflater.inflate(R.layout.row_layout, null)

//        rowView.txt_row_id.text = plantList[position].id.toString()
        rowView.txt_name.text = plantList[position].name.toString()
        rowView.txt_date.text = plantList[position].date.toString()
        rowView.txt_description.text = plantList[position].description.toString()
        rowView.txt_type.text = plantList[position].type.toString()

        /*
        rowView.setOnClickListener{
            gymClassId.setText(plantList[position].id.toString())
            gymClassName.setText(rowView.txt_name.text.toString())
            gymClassInstructor.setText(rowView.txt_instructor.text.toString())
            gymClassRoom.setText(rowView.txt_room.text.toString())
        }

         */
        return rowView
    }

    override fun getItem(position: Int): Any {
        return plantList[position]
    }

    override fun getItemId(position: Int): Long {
        return plantList[position].id.toLong()
    }

    override fun getCount(): Int {
        return plantList.size
    }
}