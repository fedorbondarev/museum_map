package com.history.museum.map.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.history.museum.map.R

class StartFragment : Fragment(R.layout.start_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toMapButton = view.findViewById<Button>(R.id.map_button)
        val toAppInfoButton = view.findViewById<Button>(R.id.app_info_button)
        val toMuseumInfoButton = view.findViewById<Button>(R.id.museum_info_button)
        val toContactInfoButton = view.findViewById<Button>(R.id.contact_info_button)

        toMapButton.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_mapFragment)
        }
        toAppInfoButton.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_appInfoFragment)
        }
        toMuseumInfoButton.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_museumInfoFragment)
        }
        toContactInfoButton.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_contactInfoFragment)
        }
    }

}