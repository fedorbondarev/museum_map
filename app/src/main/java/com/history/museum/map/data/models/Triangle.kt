package com.history.museum.map.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlin.math.abs

@Parcelize
data class Triangle(val a: Point, val b: Point, val c: Point) : Parcelable {
    @Suppress("MemberVisibilityCanBePrivate")
    fun area(): Double {
        val v1 = b - a
        val v2 = c - a
        return abs(v1.x * v2.y - v2.x * v1.y) * 0.5
    }

    fun isInside(p: Point): Boolean {
        val s0 = area()
        val s1 = Triangle(p, a, b).area()
        val s2 = Triangle(p, a, c).area()
        val s3 = Triangle(p, b, c).area()
        return abs(s0 - (s1 + s2 + s3)) < EPS
    }
}
