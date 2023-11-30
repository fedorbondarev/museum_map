package com.history.museum.map.data

import com.history.museum.map.data.artifacts.Artifact
import com.history.museum.map.data.info.Info
import com.history.museum.map.data.models.entities.ArtifactEntity
import com.history.museum.map.data.models.entities.InfoEntity

class Repository {
    companion object {
        fun getArtifactEntity(artifact: Artifact): ArtifactEntity {
            return when (artifact) {
                Artifact.Art1 -> DataBase.ARTIFACT_ENTITIES[0]
            }
        }

        fun getInfoEntity(info: Info): InfoEntity {
            return when (info) {
                Info.ABOUT_MUSEUM -> DataBase.INFO_ENTITIES[0]
                Info.ABOUT_APP -> DataBase.INFO_ENTITIES[1]
                Info.CONTACT_INFO -> DataBase.INFO_ENTITIES[2]
            }
        }
    }
}