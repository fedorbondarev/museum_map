package com.history.museum.map.data.models.entities

import com.history.museum.map.data.models.Triangle

data class ArtifactEntity(
    val id: Long,
    val name: String,
    val floor: Long,
    val html: String,
    val triangles: List<Triangle>
)