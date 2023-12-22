package com.history.museum.map.data

import com.history.museum.map.data.models.Point
import com.history.museum.map.data.models.Triangle
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
            ArtifactEntity(
                0, "Экспонат 1", 2, "/assets/art1.html", listOf(
                    Triangle(
                        Point(3489.0, 212.0),
                        Point(3489.0 + 266.0, 212.0),
                        Point(3489.0, 212.0 + 597.0)
                    ),
                    Triangle(
                        Point(3489.0 + 266.0, 212.0 + 597.0),
                        Point(3489.0 + 266.0, 212.0),
                        Point(3489.0, 212.0 + 597.0)
                    )
                )
            )
        )
    }
}

