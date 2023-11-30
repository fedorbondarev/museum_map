package com.history.museum.map.data.models.entities

class InfoEntity(val id: Long, val header: String, private val content: String) {
    fun getContent(): String {
        return content
    }
}