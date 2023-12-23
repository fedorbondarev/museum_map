package com.history.museum.map.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.history.museum.map.R

class ArtifactInfoFragment : Fragment(R.layout.artifact_info_fragment) {
    private val args: ArtifactInfoFragmentArgs by navArgs()

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val backButton = view.findViewById<Button>(R.id.back_button)
        backButton.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        view.findViewById<TextView>(R.id.title).text = args.artifact.name


        val webView = view.findViewById<WebView>(R.id.info_web_view)
        webView.settings.javaScriptEnabled = true
        webView.loadData(args.artifact.html, "text/html; charset=utf-8", "UTF-8")
    }
}