package com.history.museum.map.data

import com.history.museum.map.data.models.entities.ArtifactEntity
import com.history.museum.map.data.models.entities.InfoEntity


class DataBase {
    companion object {
        val INFO_ENTITIES = mutableListOf(
            InfoEntity(0, "О музее", "Музей Блокады Ленинграда"),
            InfoEntity(1, "О приложении", "Информация о приложении"),
            InfoEntity(2, "Контактная информация", "Информация о контактной информации")
        )

        val ARTIFACT_ENTITIES = mutableListOf(
            ArtifactEntity(0, "Экспонат 1", 1, "/assets/art1.html", listOf())
        )
    }
}

