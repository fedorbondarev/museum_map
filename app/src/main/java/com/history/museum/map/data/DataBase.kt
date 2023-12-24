package com.history.museum.map.data

import com.history.museum.map.data.models.Point
import com.history.museum.map.data.models.Triangle
import com.history.museum.map.data.models.entities.ArtifactEntity
import com.history.museum.map.data.models.entities.InfoEntity
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin


fun createTrianglesForRect(x: Double, y: Double, w: Double, h: Double): List<Triangle> {
    return listOf(
        Triangle(Point(x, y), Point(x + w, y), Point(x + w, y + h)),
        Triangle(Point(x, y), Point(x, y + h), Point(x + w, y + h))
    )
}

fun circleTriangles(n: Int, radius: Double, center: Point): List<Triangle> {
    val angle = 2 * PI / n
    val points = mutableListOf<Point>()
    var v = Point(0.0, radius)
    for (i in 0..n) {
        points.add(center + v)
        val x = v.x * cos(angle) - v.y * sin(angle)
        val y = v.x * sin(angle) + v.y * cos(angle)
        v = Point(x, y)
    }
    points.add(center + v)
    val triangles = mutableListOf<Triangle>()
    for (i in 0 until points.size) {
        triangles.add(
            Triangle(center, points[i % points.size], points[(i + 1) % points.size])
        )
    }
    return triangles
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
            ),
            ArtifactEntity(
                10,
                "Экспонат 10",
                2,
                """
                    <html>
                    <body>
                        <p>Добро пожаловать на нашу выставку музея! Исследуйте увлекательные артефакты и узнайте о их истории и значимости.</p>
                        <p>Не забудьте посетить наши интерактивные дисплеи и принять участие в практических занятиях.</p>
                    </body>
                    </html>
                """.trimIndent(),
                createTrianglesForRect(830.0, 700.0, 160.0, 261.0) +
                        createTrianglesForRect(771.0, 956.0, 270.0, 150.0)
            ),
            ArtifactEntity(
                11,
                "Экспонат 11",
                2,
                """
                    <html>
                    <body>
                        <p>Добро пожаловать на нашу выставку музея! Исследуйте увлекательные артефакты и узнайте о их истории и значимости.</p>
                        <p>Не забудьте посетить наши интерактивные дисплеи и принять участие в практических занятиях.</p>
                    </body>
                    </html>
                """.trimIndent(),
                circleTriangles(12, 140.0, Point(910.0, 1299.0))
            ),
            ArtifactEntity(
                12,
                "Экспонат 12",
                2,
                """
                    <html>
                    <body>
                        <p>Добро пожаловать на нашу выставку музея! Исследуйте увлекательные артефакты и узнайте о их истории и значимости.</p>
                        <p>Не забудьте посетить наши интерактивные дисплеи и принять участие в практических занятиях.</p>
                    </body>
                    </html>
                """.trimIndent(),
                createTrianglesForRect(1051.0, 2796.0, 409.0, 181.0)
            )
        )
    }
}
