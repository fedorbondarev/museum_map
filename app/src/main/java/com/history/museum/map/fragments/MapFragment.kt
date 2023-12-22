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
import com.history.museum.map.data.RepositoryImpl
import com.history.museum.map.data.models.Point


class MapFragment : Fragment(R.layout.map_layout) {
    var current_floor = 1
    var repo = RepositoryImpl()
    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageView: SubsamplingScaleImageView = view.findViewById(R.id.imageView)
        val button1: Button = view.findViewById(R.id.button)
        val button2: Button = view.findViewById(R.id.button2)
        val toStartButton: Button = view.findViewById(R.id.button_from_map_to_start)

        toStartButton.setOnClickListener {
            findNavController().navigate(R.id.action_mapFragment_to_startFragment)
        }

        CreateMap(current_floor, imageView)

        button1.setOnClickListener {
            changeFloor(1, imageView)
        }

        button2.setOnClickListener {
            changeFloor(2, imageView)
        }


        val gestureDetector = GestureDetector(
            this@MapFragment.requireContext(),
            object : GestureDetector.SimpleOnGestureListener() {
                override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
                    if (imageView.isReady) {
                        val x = imageView.viewToSourceCoord(e.x, e.y)?.x
                        val y = imageView.viewToSourceCoord(e.x, e.y)?.y

                        if (x != null && y != null) {
                            val point = Point(x.toDouble(), y.toDouble())

                            // m*n !
                            // maybe repo.GetFirstFloorArtifacts() / repo.GetSecondFloorArtifacts()
                            for (artifact in repo.getAllArtifacts()) {
                                if (artifact.floor.toInt() == current_floor) {
                                    for (triangle in artifact.triangles) {
                                        if (triangle.isInside(point)) {
                                            // Diplay Info
                                        }
                                    }
                                }
                            }

                            // Testing feature: display coordinates of tap
                            // Toast.makeText(this@MapFragment.requireContext(), "X: $x, Y: $y", Toast.LENGTH_SHORT).show()
                        }
                    }
                    return true
                }
            }
        )

        val scaleGestureDetector = ScaleGestureDetector(
            this@MapFragment.requireContext(),
            object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
                override fun onScale(detector: ScaleGestureDetector): Boolean {
                    // Обработка масштабирования, иначе не работает зум)
                    return true
                }
            }
        )

        imageView.setOnTouchListener { _, event ->
            val result = scaleGestureDetector.onTouchEvent(event)
            val singleTap = gestureDetector.onTouchEvent(event)

            !result && singleTap
        }
    }

    fun CreateMap(floor: Int, imageView: SubsamplingScaleImageView) {
        var bmpResourceId = R.raw.first_floor
        imageView.orientation = SubsamplingScaleImageView.ORIENTATION_0

        if (floor == 2) {
            bmpResourceId = R.raw.second_floor
            imageView.orientation = SubsamplingScaleImageView.ORIENTATION_90
        }

        val bmpInputStream = resources.openRawResource(bmpResourceId)
        val bmpBitmap: Bitmap = BitmapFactory.decodeStream(bmpInputStream)
        imageView.setImage(ImageSource.bitmap(bmpBitmap))
    }

    private fun changeFloor(newFloor: Int, imageView: SubsamplingScaleImageView) {
        if (newFloor != current_floor) {
            current_floor = newFloor
            CreateMap(current_floor, imageView)
        }
    }
}