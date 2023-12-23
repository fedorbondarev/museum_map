package com.history.museum.map.data.models.entities

import android.os.Parcelable
import com.history.museum.map.data.models.Triangle
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArtifactEntity(
    val id: Long,
    val name: String,
    val floor: Int,
    val html: String,
    val triangles: List<Triangle>
) : Parcelable
