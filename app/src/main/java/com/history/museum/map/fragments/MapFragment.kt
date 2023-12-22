package com.history.museum.map.fragments

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import com.history.museum.map.R
import com.history.museum.map.data.Repository
import com.history.museum.map.data.models.Point
import com.history.museum.map.data.models.entities.ArtifactEntity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MapFragment : Fragment(R.layout.map_fragment) {
    @Inject
    lateinit var repository: Repository

    var currentFloor = 1

    private lateinit var imageView: SubsamplingScaleImageView

    private fun onArtifactTap(artifact: ArtifactEntity) {
        val action = MapFragmentDirections.actionMapFragmentToArtifactInfoFragment(artifact)
        findNavController().navigate(action)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageView = view.findViewById(R.id.imageView)
        val button1: Button = view.findViewById(R.id.floor_button_1)
        val button2: Button = view.findViewById(R.id.floor_button_2)
        val backButton: Button = view.findViewById(R.id.button_from_map_to_start)

        backButton.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        createMap(currentFloor)

        button1.setOnClickListener {
            changeFloor(1)
        }

        button2.setOnClickListener {
            changeFloor(2)
        }

        val tapListener =
            object : GestureDetector.SimpleOnGestureListener() {
                override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
                    if (imageView.isReady) {
                        val x = imageView.viewToSourceCoord(e.x, e.y)?.x
                        val y = imageView.viewToSourceCoord(e.x, e.y)?.y

                        if (x != null && y != null) {
                            val point = Point(x.toDouble(), y.toDouble())

                            // m*n !
                            // maybe repo.GetFirstFloorArtifacts() / repo.GetSecondFloorArtifacts()
                            for (artifact in repository.getAllArtifacts()) {
                                if (artifact.floor.toInt() != currentFloor) {
                                    continue
                                }

                                for (triangle in artifact.triangles) {
                                    if (triangle.isInside(point)) {
                                        onArtifactTap(artifact)
                                    }
                                }
                            }
                        }
                    }

                    return true
                }
            }


        val tapDetector = GestureDetector(this@MapFragment.requireContext(), tapListener)

        val scaleDetector = ScaleGestureDetector(
            this@MapFragment.requireContext(),
            ScaleGestureDetector.SimpleOnScaleGestureListener()
        )

        imageView.setOnTouchListener { _, event ->
            val result = scaleDetector.onTouchEvent(event)
            val singleTap = tapDetector.onTouchEvent(event)
            !result && singleTap
        }
    }

    private fun createMap(floor: Int) {
        val bmpResourceId: Int

        when (floor) {
            1 -> {
                bmpResourceId = R.raw.first_floor
                imageView.orientation = SubsamplingScaleImageView.ORIENTATION_0
            }

            2 -> {
                bmpResourceId = R.raw.second_floor
                imageView.orientation = SubsamplingScaleImageView.ORIENTATION_0
            }

            else -> throw IllegalArgumentException()
        }

        val bmpInputStream = resources.openRawResource(bmpResourceId)
        val bmpBitmap: Bitmap = BitmapFactory.decodeStream(bmpInputStream)
        imageView.setImage(ImageSource.bitmap(bmpBitmap))
    }

    private fun changeFloor(newFloor: Int) {
        if (newFloor != currentFloor) {
            currentFloor = newFloor
            createMap(currentFloor)
        }
    }
}