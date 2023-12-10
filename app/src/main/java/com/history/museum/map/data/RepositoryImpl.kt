package com.history.museum.map.data

import com.history.museum.map.data.exceptions.NoSuchArtifactException
import com.history.museum.map.data.info.Info
import com.history.museum.map.data.models.entities.ArtifactEntity
import com.history.museum.map.data.models.entities.InfoEntity

class RepositoryImpl : Repository {
    override fun getArtifactById(id: Long): ArtifactEntity {
        return DataBase.ARTIFACT_ENTITIES
            .stream()
            .filter {
                id == it.id
            }
            .findFirst()
            .orElseThrow { NoSuchArtifactException("No artifact entity with such id=$id") }
    }

    override fun getAllArtifacts(): List<ArtifactEntity> {
        return DataBase.ARTIFACT_ENTITIES
    }

    override fun getInfoEntity(info: Info): InfoEntity {
        return when (info) {
            Info.ABOUT_MUSEUM -> DataBase.INFO_ENTITIES[0]
            Info.ABOUT_APP -> DataBase.INFO_ENTITIES[1]
            Info.CONTACT_INFO -> DataBase.INFO_ENTITIES[2]
        }
    }
}