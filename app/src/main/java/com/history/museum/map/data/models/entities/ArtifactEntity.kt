package com.history.museum.map.data.models.entities

import com.history.museum.map.data.models.Triangle

class ArtifactEntity(
    val id: Long,
    val name: String,
    private val htmlLink: String, // в каком виде нужно поставлять html? я хочу его из assets'ов брать
    val triangles: List<Triangle>
)