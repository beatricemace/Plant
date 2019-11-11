package com.example.myapplication


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.FragmentAddingplantBinding


/**
 * A simple [Fragment] subclass.
 */
class Addingplant : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentAddingplantBinding>(inflater, R.layout.fragment_addingplant, container, false)
        return binding.root


    }


}
