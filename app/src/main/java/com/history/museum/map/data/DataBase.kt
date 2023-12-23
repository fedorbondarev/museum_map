package com.history.museum.map.data

import com.history.museum.map.data.models.Point
import com.history.museum.map.data.models.Triangle
import com.history.museum.map.data.models.entities.ArtifactEntity
import com.history.museum.map.data.models.entities.InfoEntity


fun createTrianglesForRect(x: Double, y: Double, w: Double, h: Double): List<Triangle> {
    return listOf(
        Triangle(Point(x, y), Point(x + w, y), Point(x + w, y + h)),
        Triangle(Point(x, y), Point(x, y + h), Point(x + w, y + h))
    )
}

class DataBase {
    companion object {
        val INFO_ENTITIES = mutableListOf(
            InfoEntity(0, "О музее", "Музей Блокады Ленинграда"),
            InfoEntity(1, "О приложении", "Информация о приложении"),
            InfoEntity(2, "Контактная информация", "Информация о контактной информации")
        )

        val ARTIFACT_ENTITIES = listOf(
            ArtifactEntity(
                7,
                "Экспонат 7",
                2,
                """
                    <html>
                    <body>
                        <p>Добро пожаловать на нашу выставку музея! Исследуйте увлекательные артефакты и узнайте о их истории и значимости.</p>
                        <p>Не забудьте посетить наши интерактивные дисплеи и принять участие в практических занятиях.</p>
                    </body>
                    </html>
                """.trimIndent(),
                createTrianglesForRect(342.0, 414.0, 279.0, 1767.0)
            ),
            ArtifactEntity(
                8,
                "Экспонат 8",
                2,
                """
                    <html>
                    <body>
                        <p>Добро пожаловать на нашу выставку музея! Исследуйте увлекательные артефакты и узнайте о их истории и значимости.</p>
                        <p>Не забудьте посетить наши интерактивные дисплеи и принять участие в практических занятиях.</p>
                    </body>
                    </html>
                """.trimIndent(),
                createTrianglesForRect(642.0, 414.0, 528.0, 270.0)
            ),
            ArtifactEntity(
                9,
                "Экспонат 9",
                2,
                """
                    <html>
                    <body>
                        <p>Добро пожаловать на нашу выставку музея! Исследуйте увлекательные артефакты и узнайте о их истории и значимости.</p>
                        <p>Не забудьте посетить наши интерактивные дисплеи и принять участие в практических занятиях.</p>
                    </body>
                    </html>
                """.trimIndent(),
                createTrianglesForRect(1182.0, 414.0, 279.0, 1767.0)
            )
        )
    }
}
