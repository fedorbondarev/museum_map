package com.history.museum.map.data.models

class Point(val x: Double, val y: Double) {
    operator fun minus(other: Point): Point {
        return Point(x - other.x, y - other.y)
    }

    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}