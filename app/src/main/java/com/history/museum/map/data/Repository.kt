package com.history.museum.map.data

import com.history.museum.map.data.info.Info
import com.history.museum.map.data.models.entities.ArtifactEntity
import com.history.museum.map.data.models.entities.InfoEntity

interface Repository {
    fun getArtifactById(id: Long): ArtifactEntity
    fun getInfoEntity(info: Info): InfoEntity
    fun getAllArtifacts(): List<ArtifactEntity>
}

fun Repository.getFloorArtifacts(floor: Int) = getAllArtifacts().filter { it.floor == floor }