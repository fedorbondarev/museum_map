package com.history.museum.map.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Point(val x: Double, val y: Double) : Parcelable {
    operator fun minus(other: Point): Point {
        return Point(x - other.x, y - other.y)
    }

    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}
