package com.history.museum.map.data

import com.history.museum.map.data.models.Point
import com.history.museum.map.data.models.Triangle
import com.history.museum.map.data.models.entities.ArtifactEntity
import com.history.museum.map.data.models.entities.InfoEntity
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin


fun rectTriangles(x: Double, y: Double, w: Double, h: Double): List<Triangle> {
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
                1,
                "История музея",
                1,
                """
                    <html>
                    <body>
                        <p>При входе музей перед центральной лестницей слева на стене и справа в электронном киоске расположены краткие информационные справки об истории Соляного городка, музея обороны и блокады Ленинграда и блокадного архипелага.</p>
                    </body>
                    </html>
                """.trimIndent(),
                rectTriangles(881.0, 1599.0, 884.0, 717.0)
            ),
            ArtifactEntity(
                2,
                "Зал временных выставок",
                1,
                """
                    <html>
                    <body>
                        <p>В зале проходят временные выставки по отдельным сюжетам истории обороны и блокады Ленинграда, позволяющим раскрыть эту тему с разных сторон.</p>
                    </body>
                    </html>
                """.trimIndent(),
                rectTriangles(859.0, 519.0, 890.0, 855.0)
            ),
            ArtifactEntity(
                3,
                "Ленинградское дело",
                1,
                """
                    <html>
                    <body>
                        <p>Слева от центральной лестницы рядом со входом в зал временных выставок расположена экспозиция, посвященная краткой истории «Ленинградского дела» - серии судебных процессов в конце 1940-х – начале 1950-х годов против партийных и государственных руководителей РСФСР в СССР, в ходе которых им были предъявлены тяжкие обвинения. Событие стало отражением внутрипартийной борьбы и очередного витка усиления сталинских политических репрессий. Многие обвиняемые в рамках судебных процессов в годы войны занимали руководящие должности в системе управления Ленинградом.</p>
                    </body>
                    </html>
                """.trimIndent(),
                rectTriangles(1806.0, 412.0, 400.0, 255.0)
            ),
            ArtifactEntity(
                4,
                "Победа",
                1,
                """
                    <html>
                    <body>
                        <p>На стене вдоль центральной лестницы и при подъеме на второй этаж расположены портреты ключевых политических и военных деятелей, внесших свой вклад в победу над противником в ходе многолетней ленинградской блокады.</p>
                    </body>
                    </html>
                """.trimIndent(),
                rectTriangles(1942.0, 979.0, 275.0, 1413.0)
            ),
            ArtifactEntity(
                5,
                "Зал временных выставок",
                2,
                """
                    <html>
                    <body>
                        <p>В зале проходят временные выставки по отдельным сюжетам истории обороны и блокады Ленинграда, позволяющим раскрыть эту тему с разных сторон.</p>
                    </body>
                    </html>
                """.trimIndent(),
                rectTriangles(1054.0, 3232.0, 416.0, 432.0)
            ),
            ArtifactEntity(
                6,
                "Начало войны.",
                2,
                """<html>

<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<meta name=Generator content="Microsoft Word 15 (filtered)">
<style>
<!--
 /* Font Definitions */
 @font-face
	{font-family:Wingdings;
	panose-1:5 0 0 0 0 0 0 0 0 0;}
@font-face
	{font-family:"Cambria Math";
	panose-1:2 4 5 3 5 4 6 3 2 4;}
 /* Style Definitions */
 p.MsoNormal, li.MsoNormal, div.MsoNormal
	{margin:0in;
	line-height:115%;
	font-size:11.0pt;
	font-family:"Arial",sans-serif;}
p.MsoListParagraph, li.MsoListParagraph, div.MsoListParagraph
	{margin-top:0in;
	margin-right:0in;
	margin-bottom:0in;
	margin-left:.5in;
	line-height:115%;
	font-size:11.0pt;
	font-family:"Arial",sans-serif;}
p.MsoListParagraphCxSpFirst, li.MsoListParagraphCxSpFirst, div.MsoListParagraphCxSpFirst
	{margin-top:0in;
	margin-right:0in;
	margin-bottom:0in;
	margin-left:.5in;
	line-height:115%;
	font-size:11.0pt;
	font-family:"Arial",sans-serif;}
p.MsoListParagraphCxSpMiddle, li.MsoListParagraphCxSpMiddle, div.MsoListParagraphCxSpMiddle
	{margin-top:0in;
	margin-right:0in;
	margin-bottom:0in;
	margin-left:.5in;
	line-height:115%;
	font-size:11.0pt;
	font-family:"Arial",sans-serif;}
p.MsoListParagraphCxSpLast, li.MsoListParagraphCxSpLast, div.MsoListParagraphCxSpLast
	{margin-top:0in;
	margin-right:0in;
	margin-bottom:0in;
	margin-left:.5in;
	line-height:115%;
	font-size:11.0pt;
	font-family:"Arial",sans-serif;}
.MsoChpDefault
	{font-size:12.0pt;
	font-family:"Calibri",sans-serif;}
@page WordSection1
	{size:595.3pt 841.9pt;
	margin:56.7pt 42.5pt 56.7pt 85.05pt;}
div.WordSection1
	{page:WordSection1;}
 /* List Definitions */
 ol
	{margin-bottom:0in;}
ul
	{margin-bottom:0in;}
-->
</style>

</head>

<body lang=EN-US style='word-wrap:break-word'>

<div class=WordSection1>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><b><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Пролог.
</span></b></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><i><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Вдоль
стены справа расположены важнейшие символы блокады Ленинграда: дневник Тани
Савичевой, суточная норма продовольствия иждивенца в ноябре-декабре 1941 года в
виде куска хлеба весом 125 граммов и многое другое. Данная часть зала является
прологом к основной экспозиции.  </span></i></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><b><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>6.1
Начало войны. План «Барбаросса». Борьба на дальних и ближних подступах.</span></b></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=RU
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><i><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Перед
вами – начало раздела, посвященного первым дням Великой Отечественной войны. Вы
находитесь между мотоциклом и началом экспозиции, где демонстрируется план
нацистского наступления на СССР. Внимание привлекает схема плана «Барбаросса»,
разработанного немецким командованием.</span></i></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=RU
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>План
«Барбаросса», названный в честь средневекового императора Фридриха I
Барбароссы, предполагал молниеносное завоевание территории СССР, с
использованием стратегии «блицкрига». Основные цели наступления – Ленинград,
Москва, Центральный промышленный район и Донецкий бассейн.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Обратите
внимание на экспонаты:</span></p>

<p class=MsoListParagraphCxSpFirst style='margin-left:70.9pt;text-align:justify;
text-indent:-.25in;line-height:normal'><span lang=RU style='font-size:14.0pt;
font-family:Symbol'>·<span style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</span></span><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Мотоцикл
– немецкий мотоцикл «Цундапп» КС-750, захваченный в ходе боев по прорыву
блокады Ленинграда. Этот мотоцикл является символом блицкрига и имеет
уникальную историю, связанную с сержантом Николаем Исхомовым.</span></p>

<p class=MsoListParagraphCxSpLast style='margin-left:70.9pt;text-align:justify;
text-indent:-.25in;line-height:normal'><span lang=RU style='font-size:14.0pt;
font-family:Symbol'>·<span style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</span></span><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Манекен
в форме унтер-офицера германских танковых войск – демонстрирует экипировку и
знаки отличия немецких танкистов, ключевой составляющей стратегии блицкрига.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Далее,
в разделе оборонительных сражений на дальних и ближних подступах к Ленинграду,
вы увидите карту, показывающую ключевые моменты наступления немцев и
сопротивления советских войск. Значительное внимание уделяется Лужскому рубежу
обороны и роли ополчения в защите Ленинграда.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>В
витрине представлены немецкие пропагандистские листовки, а также личные вещи и
документы ополченцев, оружие начального периода войны, включая противотанковые
гранаты и «коктейли Молотова».</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Завершается
экспозиция обсуждением стабилизации фронта на южных подступах к Ленинграду к
концу сентября 1941 года, что стало критическим моментом в обороне города.</span></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><b><span
lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></b></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><b><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>6.2
Перестройка всех сфер жизни Ленинграда на военный лад. Руководство города.</span></b></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=RU
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><i><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Вы
находитесь перед экспозицией, демонстрирующей перестройку Ленинграда в военное
время. Основное внимание уделено мобилизации населения и реконструкции города
для обороны. Выставлены материалы, свидетельствующие о введении военного
положения, строительстве оборонительных сооружений, а также о роли местного
руководства в управлении городом во время блокады. </span></i></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=RU
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Ленинград
быстро перешел на военный лад после начала Великой Отечественной войны. 22 июня
1941 года город был объявлен на военном положении, а с 23 июня началась
мобилизация военнообязанных. Руководство города приняло меры для обеспечения
общественного порядка и государственной безопасности, включая ограничения на
перемещение и фотографирование. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>В
экспозиции представлены копии газеты «Ленинградская правда» от 22 июня 1941
года, демонстрирующие внезапность начала войны для города. Также выставлены
фотографии оборонительных укреплений, включая Лужский рубеж и «Линию Сталина». </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Важной
частью выставки являются материалы о мобилизации населения на строительство
оборонительных сооружений и маскировку заметных зданий и памятников, в том
числе шпиля Адмиралтейства. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Рассказывается
о мерах по защите города от пожаров и авианалетов, включая установку зенитных
орудий и аэростатов, а также о полной светомаскировке. Посетителям представлены
экспонаты советских денег и ценностей, собранных в фонд обороны, и
рассказывается об их важной роли в военное время. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Выставка
также освещает роль местного руководства в управлении городом. Особое внимание
уделяется деятельности Андрея Александровича Жданова и других руководителей, а
также упоминается о «Ленинградском деле». В экспозиции представлены часы
расстрелянного Петра Тимофеевича Талюша, секретаря горкома партии.</span></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><b><span
lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></b></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><b><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>6.3
МПВО и противопожарная охрана.</span></b></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=RU
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><i><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Экспозиция
посвящена Местной противовоздушной обороне (МПВО) и противопожарной охране
Ленинграда во время блокады. Отображается важность защиты города от авиационных
и артиллерийских атак, с использованием различных методов и средств. Выставлены
предметы, такие как противогазы, шлемы, ручные сирены и зажигательные бомбы. </span></i></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'> </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>МПВО
Ленинграда играла критическую роль в защите города от вражеских бомбардировок и
артиллерийского обстрела. На экспозиции представлены различные образцы
противогазов, начиная от модели 1928 года и более совершенные последующие
модели, включая противогаз БН-Т с маской МОД-О8. Особенностью шлема для бойцов
МПВО, разработанного в Ленинграде перед войной, были широкие поля для защиты от
обломков.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Бомбардировки
начались 23 июня 1941 года с атаки на Кронштадт, вследствие чего в городе был
объявлен первый сигнал воздушной тревоги. С 27 июня вводилось круглосуточное
дежурство работников МПВО, устанавливались сигналы воздушной и химической
тревоги. В витрине демонстрируется ручная сирена, использовавшаяся для
оповещения о бомбардировках.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>11
июля 1941 года Ленгорсовет принял решение о всеобщей обязательной подготовке
населения к противовоздушной обороне. Были организованы круглосуточные
дежурства на крышах зданий для тушения зажигательных бомб. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Выставлены
экземпляры зажигательных бомб, использованных противником, и инструменты для их
тушения, включая щипцы. Описывается создание аварийно-восстановительных полков
и комсомольского полка противопожарной охраны.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>На
экспозиции также представлены снаряды и бомбы, сброшенные по Ленинграду,
включая 250-килограммовую фугасную бомбу SC-250. Освещается вклад бойцов МПВО в
уборку города и разминирование после снятия блокады.</span></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><b><span
lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></b></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><b><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>6.4
Медицина.</span></b></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=RU
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><i><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Экспозиция
посвящена медицине в Ленинграде во время блокады, подчеркивая сложности и
достижения медицинского сообщества в этот период. Освещается важность
медицинской инфраструктуры города, которая включала больницы, поликлиники,
санитарно-эпидемиологические станции, и научно-исследовательские институты.
Представлены примеры медицинской литературы, выпущенной во время блокады, и
протезы, используемые в то время.</span></i></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=RU
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>До
начала блокады в Ленинграде была развита мощная медицинская инфраструктура,
включающая множество больниц, поликлиник и научно-исследовательских институтов.
Во время блокады эти учреждения продолжали функционировать, несмотря на тяжелые
условия.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>На
выставке представлены книги, изданные в 1941-1942 годах, посвященные «военной»
тематике, в частности огнестрельным ранениям. Витрины демонстрируют медицинскую
службу Ленинградского фронта, которая обеспечивала возвращение в строй более
60% раненых и больных. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Особое
внимание уделено проблемам, связанным с алиментарной дистрофией и другими
болезнями, возникшими в результате голода и блокадных условий. Экспозиция
рассказывает о том, как во время блокады изменилось распространение и характер
заболеваний, упоминая редкие болезни, такие как цинга, скорбут и авитаминозы.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Выставлены
личные вещи Юлии Ароновны Менделеевой, директора Педиатрического института, и
другие предметы, связанные с педиатрией и защитой материнства и детства в
условиях блокады. Освещается, как медицинские учреждения города
приспосабливались к экстремальным условиям, включая госпитализацию ослабленных
женщин и дополнительное питание для беременных.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Экспозиция
также рассказывает о важности протезирования и пластических операций для
искалеченных, представляя примеры протезов того времени.</span></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><b><span
lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></b></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><b><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>6.5
Балтийский флот и Финляндия.</span></b></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=RU
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><i><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Экспозиция
посвящена начальному периоду Великой Отечественной войны, освещая действия
Краснознаменного Балтийского флота и роль Финляндии в военных событиях.
Посетители могут увидеть манекен краснофлотца линкора «Октябрьская революция»,
штурвал с минного заградителя «Марти», а также карты и фотодокументы,
отображающие ключевые моменты боевых действий.</span></i></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=RU
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>На
начальном этапе Великой Отечественной войны, Краснознаменный Балтийский флот,
возглавляемый вице-адмиралом Владимиром Филипповичем Трибуцом, обладал
значительным арсеналом военных судов: от линейных кораблей до подводных лодок.
Однако внезапное наступление врага привело к тому, что флот был ограничен в
действиях и отступил в Финский залив. Экспозиция в музее включает предметы,
связанные с этим периодом, в том числе штурвал с минного заградителя «Марти» и
форму краснофлотца.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Участие
Финляндии в войне занимает особое место в экспозиции. Финляндия, измученная
последствиями Зимней войны, стремилась укрепить свои позиции, вступив в союз с
Германией. Это привело к активному участию Финляндии в блокаде Ленинграда, хотя
она и воздерживалась от прямого штурма города. В экспозиции представлены
материалы, освещающие стратегические и политические аспекты этого союза, а
также последствия выхода Финляндии из войны в 1944 году.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Балтийский
флот играл ключевую роль в обороне Ленинграда и поддержке сухопутных войск.
Используя береговую и корабельную артиллерию, а также авиацию, флот оказывал
существенное влияние на ход боевых действий. В экспозиции представлены
фотографии, личные вещи участников и другие предметы, отражающие важную роль
флота в этих операциях.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Экспозиция
также охватывает широкий спектр аспектов службы Балтийского флота в годы войны,
включая стратегические, тактические и политические аспекты. Это позволяет
посетителям более полно понять и оценить вклад флота в историю Великой
Отечественной войны, его роль в обеспечении обороны Ленинграда и влияние на
глобальную политическую обстановку того времени.</span></p>

<p class=MsoNormal><span lang=RU>&nbsp;</span></p>

</div>

</body>

</html>
""".trimIndent(),
                rectTriangles(342.0, 2800.0, 672.0, 1282.0)
            ),
            ArtifactEntity(
                7,
                "Ленинградский фронт в 1941-1943 годы.",
                2,
                """<html>

<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<meta name=Generator content="Microsoft Word 15 (filtered)">
<style>
<!--
 /* Font Definitions */
 @font-face
	{font-family:Wingdings;
	panose-1:5 0 0 0 0 0 0 0 0 0;}
@font-face
	{font-family:"Cambria Math";
	panose-1:2 4 5 3 5 4 6 3 2 4;}
 /* Style Definitions */
 p.MsoNormal, li.MsoNormal, div.MsoNormal
	{margin:0in;
	line-height:115%;
	font-size:11.0pt;
	font-family:"Arial",sans-serif;}
p.MsoListParagraph, li.MsoListParagraph, div.MsoListParagraph
	{margin-top:0in;
	margin-right:0in;
	margin-bottom:0in;
	margin-left:.5in;
	line-height:115%;
	font-size:11.0pt;
	font-family:"Arial",sans-serif;}
p.MsoListParagraphCxSpFirst, li.MsoListParagraphCxSpFirst, div.MsoListParagraphCxSpFirst
	{margin-top:0in;
	margin-right:0in;
	margin-bottom:0in;
	margin-left:.5in;
	line-height:115%;
	font-size:11.0pt;
	font-family:"Arial",sans-serif;}
p.MsoListParagraphCxSpMiddle, li.MsoListParagraphCxSpMiddle, div.MsoListParagraphCxSpMiddle
	{margin-top:0in;
	margin-right:0in;
	margin-bottom:0in;
	margin-left:.5in;
	line-height:115%;
	font-size:11.0pt;
	font-family:"Arial",sans-serif;}
p.MsoListParagraphCxSpLast, li.MsoListParagraphCxSpLast, div.MsoListParagraphCxSpLast
	{margin-top:0in;
	margin-right:0in;
	margin-bottom:0in;
	margin-left:.5in;
	line-height:115%;
	font-size:11.0pt;
	font-family:"Arial",sans-serif;}
.MsoChpDefault
	{font-size:12.0pt;
	font-family:"Calibri",sans-serif;}
@page WordSection1
	{size:595.3pt 841.9pt;
	margin:56.7pt 42.5pt 56.7pt 85.05pt;}
div.WordSection1
	{page:WordSection1;}
 /* List Definitions */
 ol
	{margin-bottom:0in;}
ul
	{margin-bottom:0in;}
-->
</style>

</head>

<body lang=EN-US style='word-wrap:break-word'>

<div class=WordSection1>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><b><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Пролог.
</span></b></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><i><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Вдоль
стены справа расположены важнейшие символы блокады Ленинграда: дневник Тани
Савичевой, суточная норма продовольствия иждивенца в ноябре-декабре 1941 года в
виде куска хлеба весом 125 граммов и многое другое. Данная часть зала является
прологом к основной экспозиции.  </span></i></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><b><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>6.1
Начало войны. План «Барбаросса». Борьба на дальних и ближних подступах.</span></b></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=RU
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><i><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Перед
вами – начало раздела, посвященного первым дням Великой Отечественной войны. Вы
находитесь между мотоциклом и началом экспозиции, где демонстрируется план
нацистского наступления на СССР. Внимание привлекает схема плана «Барбаросса»,
разработанного немецким командованием.</span></i></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=RU
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>План
«Барбаросса», названный в честь средневекового императора Фридриха I
Барбароссы, предполагал молниеносное завоевание территории СССР, с
использованием стратегии «блицкрига». Основные цели наступления – Ленинград,
Москва, Центральный промышленный район и Донецкий бассейн.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Обратите
внимание на экспонаты:</span></p>

<p class=MsoListParagraphCxSpFirst style='margin-left:70.9pt;text-align:justify;
text-indent:-.25in;line-height:normal'><span lang=RU style='font-size:14.0pt;
font-family:Symbol'>·<span style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</span></span><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Мотоцикл
– немецкий мотоцикл «Цундапп» КС-750, захваченный в ходе боев по прорыву
блокады Ленинграда. Этот мотоцикл является символом блицкрига и имеет
уникальную историю, связанную с сержантом Николаем Исхомовым.</span></p>

<p class=MsoListParagraphCxSpLast style='margin-left:70.9pt;text-align:justify;
text-indent:-.25in;line-height:normal'><span lang=RU style='font-size:14.0pt;
font-family:Symbol'>·<span style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</span></span><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Манекен
в форме унтер-офицера германских танковых войск – демонстрирует экипировку и
знаки отличия немецких танкистов, ключевой составляющей стратегии блицкрига.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Далее,
в разделе оборонительных сражений на дальних и ближних подступах к Ленинграду,
вы увидите карту, показывающую ключевые моменты наступления немцев и
сопротивления советских войск. Значительное внимание уделяется Лужскому рубежу
обороны и роли ополчения в защите Ленинграда.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>В
витрине представлены немецкие пропагандистские листовки, а также личные вещи и
документы ополченцев, оружие начального периода войны, включая противотанковые
гранаты и «коктейли Молотова».</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Завершается
экспозиция обсуждением стабилизации фронта на южных подступах к Ленинграду к
концу сентября 1941 года, что стало критическим моментом в обороне города.</span></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><b><span
lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></b></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><b><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>6.2
Перестройка всех сфер жизни Ленинграда на военный лад. Руководство города.</span></b></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=RU
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><i><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Вы
находитесь перед экспозицией, демонстрирующей перестройку Ленинграда в военное
время. Основное внимание уделено мобилизации населения и реконструкции города
для обороны. Выставлены материалы, свидетельствующие о введении военного
положения, строительстве оборонительных сооружений, а также о роли местного
руководства в управлении городом во время блокады. </span></i></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=RU
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Ленинград
быстро перешел на военный лад после начала Великой Отечественной войны. 22 июня
1941 года город был объявлен на военном положении, а с 23 июня началась
мобилизация военнообязанных. Руководство города приняло меры для обеспечения
общественного порядка и государственной безопасности, включая ограничения на
перемещение и фотографирование. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>В
экспозиции представлены копии газеты «Ленинградская правда» от 22 июня 1941
года, демонстрирующие внезапность начала войны для города. Также выставлены
фотографии оборонительных укреплений, включая Лужский рубеж и «Линию Сталина». </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Важной
частью выставки являются материалы о мобилизации населения на строительство
оборонительных сооружений и маскировку заметных зданий и памятников, в том
числе шпиля Адмиралтейства. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Рассказывается
о мерах по защите города от пожаров и авианалетов, включая установку зенитных
орудий и аэростатов, а также о полной светомаскировке. Посетителям представлены
экспонаты советских денег и ценностей, собранных в фонд обороны, и
рассказывается об их важной роли в военное время. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Выставка
также освещает роль местного руководства в управлении городом. Особое внимание
уделяется деятельности Андрея Александровича Жданова и других руководителей, а
также упоминается о «Ленинградском деле». В экспозиции представлены часы
расстрелянного Петра Тимофеевича Талюша, секретаря горкома партии.</span></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><b><span
lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></b></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><b><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>6.3
МПВО и противопожарная охрана.</span></b></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=RU
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><i><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Экспозиция
посвящена Местной противовоздушной обороне (МПВО) и противопожарной охране
Ленинграда во время блокады. Отображается важность защиты города от авиационных
и артиллерийских атак, с использованием различных методов и средств. Выставлены
предметы, такие как противогазы, шлемы, ручные сирены и зажигательные бомбы. </span></i></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'> </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>МПВО
Ленинграда играла критическую роль в защите города от вражеских бомбардировок и
артиллерийского обстрела. На экспозиции представлены различные образцы
противогазов, начиная от модели 1928 года и более совершенные последующие
модели, включая противогаз БН-Т с маской МОД-О8. Особенностью шлема для бойцов
МПВО, разработанного в Ленинграде перед войной, были широкие поля для защиты от
обломков.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Бомбардировки
начались 23 июня 1941 года с атаки на Кронштадт, вследствие чего в городе был
объявлен первый сигнал воздушной тревоги. С 27 июня вводилось круглосуточное
дежурство работников МПВО, устанавливались сигналы воздушной и химической
тревоги. В витрине демонстрируется ручная сирена, использовавшаяся для
оповещения о бомбардировках.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>11
июля 1941 года Ленгорсовет принял решение о всеобщей обязательной подготовке
населения к противовоздушной обороне. Были организованы круглосуточные
дежурства на крышах зданий для тушения зажигательных бомб. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Выставлены
экземпляры зажигательных бомб, использованных противником, и инструменты для их
тушения, включая щипцы. Описывается создание аварийно-восстановительных полков
и комсомольского полка противопожарной охраны.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>На
экспозиции также представлены снаряды и бомбы, сброшенные по Ленинграду,
включая 250-килограммовую фугасную бомбу SC-250. Освещается вклад бойцов МПВО в
уборку города и разминирование после снятия блокады.</span></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><b><span
lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></b></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><b><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>6.4
Медицина.</span></b></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=RU
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><i><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Экспозиция
посвящена медицине в Ленинграде во время блокады, подчеркивая сложности и
достижения медицинского сообщества в этот период. Освещается важность
медицинской инфраструктуры города, которая включала больницы, поликлиники,
санитарно-эпидемиологические станции, и научно-исследовательские институты.
Представлены примеры медицинской литературы, выпущенной во время блокады, и
протезы, используемые в то время.</span></i></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=RU
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>До
начала блокады в Ленинграде была развита мощная медицинская инфраструктура,
включающая множество больниц, поликлиник и научно-исследовательских институтов.
Во время блокады эти учреждения продолжали функционировать, несмотря на тяжелые
условия.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>На
выставке представлены книги, изданные в 1941-1942 годах, посвященные «военной»
тематике, в частности огнестрельным ранениям. Витрины демонстрируют медицинскую
службу Ленинградского фронта, которая обеспечивала возвращение в строй более
60% раненых и больных. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Особое
внимание уделено проблемам, связанным с алиментарной дистрофией и другими
болезнями, возникшими в результате голода и блокадных условий. Экспозиция
рассказывает о том, как во время блокады изменилось распространение и характер
заболеваний, упоминая редкие болезни, такие как цинга, скорбут и авитаминозы.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Выставлены
личные вещи Юлии Ароновны Менделеевой, директора Педиатрического института, и
другие предметы, связанные с педиатрией и защитой материнства и детства в
условиях блокады. Освещается, как медицинские учреждения города
приспосабливались к экстремальным условиям, включая госпитализацию ослабленных
женщин и дополнительное питание для беременных.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Экспозиция
также рассказывает о важности протезирования и пластических операций для
искалеченных, представляя примеры протезов того времени.</span></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><b><span
lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></b></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><b><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>6.5
Балтийский флот и Финляндия.</span></b></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=RU
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><i><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Экспозиция
посвящена начальному периоду Великой Отечественной войны, освещая действия
Краснознаменного Балтийского флота и роль Финляндии в военных событиях.
Посетители могут увидеть манекен краснофлотца линкора «Октябрьская революция»,
штурвал с минного заградителя «Марти», а также карты и фотодокументы,
отображающие ключевые моменты боевых действий.</span></i></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=RU
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>На
начальном этапе Великой Отечественной войны, Краснознаменный Балтийский флот,
возглавляемый вице-адмиралом Владимиром Филипповичем Трибуцом, обладал
значительным арсеналом военных судов: от линейных кораблей до подводных лодок.
Однако внезапное наступление врага привело к тому, что флот был ограничен в
действиях и отступил в Финский залив. Экспозиция в музее включает предметы,
связанные с этим периодом, в том числе штурвал с минного заградителя «Марти» и
форму краснофлотца.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Участие
Финляндии в войне занимает особое место в экспозиции. Финляндия, измученная
последствиями Зимней войны, стремилась укрепить свои позиции, вступив в союз с
Германией. Это привело к активному участию Финляндии в блокаде Ленинграда, хотя
она и воздерживалась от прямого штурма города. В экспозиции представлены
материалы, освещающие стратегические и политические аспекты этого союза, а
также последствия выхода Финляндии из войны в 1944 году.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Балтийский
флот играл ключевую роль в обороне Ленинграда и поддержке сухопутных войск.
Используя береговую и корабельную артиллерию, а также авиацию, флот оказывал
существенное влияние на ход боевых действий. В экспозиции представлены
фотографии, личные вещи участников и другие предметы, отражающие важную роль
флота в этих операциях.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Экспозиция
также охватывает широкий спектр аспектов службы Балтийского флота в годы войны,
включая стратегические, тактические и политические аспекты. Это позволяет
посетителям более полно понять и оценить вклад флота в историю Великой
Отечественной войны, его роль в обеспечении обороны Ленинграда и влияние на
глобальную политическую обстановку того времени.</span></p>

<p class=MsoNormal><span lang=RU>&nbsp;</span></p>

</div>

</body>

</html>
""".trimIndent(),
                rectTriangles(342.0, 414.0, 279.0, 1767.0)
            ),
            ArtifactEntity(
                8,
                "Дорога жизни. Эвакуация.",
                2,
                """
                    <html>

<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<meta name=Generator content="Microsoft Word 15 (filtered)">
<style>
<!--
 /* Font Definitions */
 @font-face
	{font-family:Wingdings;
	panose-1:5 0 0 0 0 0 0 0 0 0;}
@font-face
	{font-family:"Cambria Math";
	panose-1:2 4 5 3 5 4 6 3 2 4;}
 /* Style Definitions */
 p.MsoNormal, li.MsoNormal, div.MsoNormal
	{margin:0in;
	line-height:115%;
	font-size:11.0pt;
	font-family:"Arial",sans-serif;}
.MsoChpDefault
	{font-size:12.0pt;
	font-family:"Calibri",sans-serif;}
@page WordSection1
	{size:595.3pt 841.9pt;
	margin:56.7pt 42.5pt 56.7pt 85.05pt;}
div.WordSection1
	{page:WordSection1;}
 /* List Definitions */
 ol
	{margin-bottom:0in;}
ul
	{margin-bottom:0in;}
-->
</style>

</head>

<body lang=EN-US style='word-wrap:break-word'>

<div class=WordSection1>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><i><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Посетители
музея находятся перед экспозицией, посвященной легендарной «Дороге жизни» -
жизненно важному пути, соединяющему блокадный Ленинград с большой землей по
Ладожскому озеру. Экспозиция демонстрирует, как по этому пути доставлялись
продовольствие, вооружение и боеприпасы, а также эвакуировались жители и
промышленное оборудование. Выставлены уникальные артефакты, включая винт
самолета и игрушки с потопленного парохода.</span></i></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=RU
style='font-size:14.0pt;font-family:"Times New Roman",serif'> </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>«Дорога
жизни» была единственным путем во время ленинградской блокады, обеспечивая
доставку продовольствия, оружия и боеприпасов в осажденный город. Водные
перевозки начались сразу после перерезания немцами железной дороги, а с
наступлением ледостава началась эксплуатация ледовой дороги.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>В
экспозиции представлен винт от самолета иностранного производства,
символизирующий международную поддержку СССР во время войны. Выделены
трудности, с которыми сталкивались работники &quot;Дороги жизни&quot;, включая
штормовую погоду, недостаток портовых сооружений и постоянные угрозы со стороны
вражеской авиации и артиллерии. В витрине выставлены игрушки, поднятые со дна
Ладоги, и другие личные вещи, оставшиеся после потопления пароходов, что
визуализирует человеческий аспект этих трагических событий.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Экспозиция
также описывает строительство и функционирование ледовой трассы, включая меры
по усилению льда, снегоочистке, медицинской помощи и техническому обеспечению
автомобилей. Выделена роль зенитной артиллерии и истребительно-авиационной
дивизии в защите «Дороги жизни», а также представлены пулеметы и шасси
советского истребителя И-16.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Значительная
часть выставки посвящена массовой эвакуации жителей Ленинграда, организованной
в несколько этапов. Рассказывается о трудностях и трагедиях, сопровождавших
этот процесс. Выставлены материалы, отображающие усилия по обеспечению связи
Ленинграда со страной, включая прокладку морского кабеля и трубопровода по дну
Ладожского озера.</span></p>

<p class=MsoNormal><span lang=RU>&nbsp;</span></p>

</div>

</body>

</html>

                """.trimIndent(),
                rectTriangles(642.0, 414.0, 528.0, 270.0)
            ),
            ArtifactEntity(
                9,
                "Жизнь города в блокаде.",
                2,
                """
                    <html>

<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<meta name=Generator content="Microsoft Word 15 (filtered)">
<style>
<!--
 /* Font Definitions */
 @font-face
	{font-family:Wingdings;
	panose-1:5 0 0 0 0 0 0 0 0 0;}
@font-face
	{font-family:"Cambria Math";
	panose-1:2 4 5 3 5 4 6 3 2 4;}
 /* Style Definitions */
 p.MsoNormal, li.MsoNormal, div.MsoNormal
	{margin:0in;
	line-height:115%;
	font-size:11.0pt;
	font-family:"Arial",sans-serif;}
p.MsoListParagraph, li.MsoListParagraph, div.MsoListParagraph
	{margin-top:0in;
	margin-right:0in;
	margin-bottom:0in;
	margin-left:.5in;
	line-height:115%;
	font-size:11.0pt;
	font-family:"Arial",sans-serif;}
p.MsoListParagraphCxSpFirst, li.MsoListParagraphCxSpFirst, div.MsoListParagraphCxSpFirst
	{margin-top:0in;
	margin-right:0in;
	margin-bottom:0in;
	margin-left:.5in;
	line-height:115%;
	font-size:11.0pt;
	font-family:"Arial",sans-serif;}
p.MsoListParagraphCxSpMiddle, li.MsoListParagraphCxSpMiddle, div.MsoListParagraphCxSpMiddle
	{margin-top:0in;
	margin-right:0in;
	margin-bottom:0in;
	margin-left:.5in;
	line-height:115%;
	font-size:11.0pt;
	font-family:"Arial",sans-serif;}
p.MsoListParagraphCxSpLast, li.MsoListParagraphCxSpLast, div.MsoListParagraphCxSpLast
	{margin-top:0in;
	margin-right:0in;
	margin-bottom:0in;
	margin-left:.5in;
	line-height:115%;
	font-size:11.0pt;
	font-family:"Arial",sans-serif;}
.MsoChpDefault
	{font-size:12.0pt;
	font-family:"Calibri",sans-serif;}
@page WordSection1
	{size:595.3pt 841.9pt;
	margin:56.7pt 42.5pt 56.7pt 85.05pt;}
div.WordSection1
	{page:WordSection1;}
 /* List Definitions */
 ol
	{margin-bottom:0in;}
ul
	{margin-bottom:0in;}
-->
</style>

</head>

<body lang=EN-US style='word-wrap:break-word'>

<div class=WordSection1>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><b><span
lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>9.1 </span></b><b><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Начало
массовой эвакуации населения из Ленинграда</span></b><span lang=ru
style='font-size:14.0pt;font-family:"Times New Roman",serif'>.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><i><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Эта
экспозиция посвящена первой волне эвакуации из Ленинграда. Всего с 29 июня по
27 августа 1941 года железнодорожным транспортом было эвакуировано 636 203
человек. 27 августа по Кировской железной дороге прошел последний поезд, немцы
перерезали железную дорогу, и эвакуация прекратилась.</span></i></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>27 июня
1941 года была создана комиссия по эвакуации. <span style='background:white'>Началась
разъяснительная работа среди населения о необходимости выезда из Ленинграда,
так как многие жители не хотели покидать свои дома. До германского нападения на
СССР никаких заранее разработанных планов эвакуации населения Ленинграда не
существовало. Возможность достижения немцами города считалась минимальной.</span></span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Всего с 29
июня по 27 августа 1941 года железнодорожным транспортом было эвакуировано 636
203 человек</span><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>а</span><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>.
Эвакуация проходила в тяжелых санитарных условиях, людей плохо снабжали
питанием и кипятком. Однако численность населения города не уменьшалась из-за
беженцев, спасающихся от немецкого наступления на западе. Власти собирались
продолжать эвакуацию, отправляя из города по 30 000 человек в день, однако 27
августа по Кировской железной дороге прошел последний поезд, немцы захватили
Мгу, перерезали железную дорогу, и эвакуация прекратилась. Из-за неизвестного
количества беженцев, находившихся в городе, оценки расходятся, но
ориентировочно в кольце блокады оказалось до 3 500 000 ленинградцев.
Продовольствия оставалось всего на три недели.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='margin-left:35.45pt;text-align:justify;line-height:
normal'><b><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>9.2
</span></b><b><span lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Продовольствие
и голод зимы 1941-1942 гг.</span></b></p>

<p class=MsoNormal style='margin-left:35.45pt;text-align:justify;line-height:
normal'><b><span lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></b></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><i><span lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Главная
проблема, определившая быт и мировоззрение блокадников - продовольственная.
Перед вами реконструкция блокадной булочной. В витрине можно увидеть карточки,
введенные для распределения продовольствия с 18 июля 1941 года. По различным
подсчетам, от голода в период блокады умерло около <u>одного миллиона
ленинградцев</u>.</span></i></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>На момент
начала нацистской блокады 8 сентября 1941 г. население Ленинграда составляло
около 2,5 млн. человек.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>На 12
сентября 1941 года в городе имел</span><span lang=RU style='font-size:14.0pt;
font-family:"Times New Roman",serif'>и</span><span lang=ru style='font-size:
14.0pt;font-family:"Times New Roman",serif'>сь следующие запасы: муки и зерна –
на 35 дней; крупы и макарон – на 30; мяса – на 33; жиров – на 45; сахара и
кондитерских изделий – на 60 дней. Отсутствовали запасы овощей, почти не было
овса и сена.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Голод был
вызван двумя причинами:</span></p>

<p class=MsoListParagraphCxSpFirst style='margin-left:1.0in;text-align:justify;
text-indent:-.25in;line-height:normal'><span lang=ru style='font-size:14.0pt;
font-family:Symbol'>·<span style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</span></span><span lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>отсутствием
крупных рассредоточенных запасов продовольствия в городе на случай войны;</span></p>

<p class=MsoListParagraphCxSpLast style='margin-left:1.0in;text-align:justify;
text-indent:-.25in;line-height:normal'><span lang=ru style='font-size:14.0pt;
font-family:Symbol'>·<span style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</span></span><span lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>стремительным
продвижением немецких войск, сумевших в очень короткий срок отрезать Ленинград
от центра страны. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Стратегических
запасов продовольствия в городе не было. Ленинград питался «с колес».
Продовольственные запасы хранились главным образом на Бадаевских складах.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>18 июля
1941 г. была введена карточная система обеспечения продовольствием. Людям
выдали продуктовые карточки, срок действия которых истекал через месяц. Всего
установили четыре категории карточек, высшей категории соответствовал самый
большой рацион. Сохранять высшую категорию можно было только за счет ударного
труда. Рабочие на заводах получали дополнительный паек.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Блокада
началась с пожара на Бадаевских складах. В результате бомбежки 8 сентября 1941
г. на складах сгорело 3 тыс. тонн муки и 2,5 тыс. тонн сахара. До 1 тыс. тонн
горелой муки и до 900 тонн горелого сахара в дальнейшем были переработаны
пищевыми предприятиями. В сознании ленинградцев пожар на Бадаевских складах
стал причиной начала голода 1941-1942 годов.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Булочные
обычно открывались в 6 часов утра, но очередь у магазинов выстраивалась еще
задолго до их открытия. Обман, обвесы, мошенничество с «талонами», грубость
были приметами многих магазинов. Мясо перестали продавать в октябре 1941 года.
Сокращение привычных норм выдачи сахара и крупы заставило многих ощутить голод
еще в начале октября.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Употребление
в пищу мяса собак и кошек стало обыкновением в «смертное время».</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Из
растительных продуктов-суррогатов самым «цивилизованным» был жмых, остававшийся
после выжимки масел из льняных, конопляных, подсолнечных, соевых, хлопковых и
других растений, в просторечии именуемый дурандой. Использовались отруби,
картофельные очистки — из них обычно пеклись лепешки. Из хряпы — гнилых верхних
капустных листьев — варился суп. Картофельной мукой, предназначенной для
изготовления клейстера, также заправлялись супы. Большим спросом пользовались
плитки столярного клея /в витрине/. Он изготовлялся из костных отходов
скотобойни, из копыт и рогов. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><b><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></b></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><b><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>9.3
</span></b><b><span lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Быт
блокадного Ленинграда.</span></b></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=ru
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><i><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Перед вами
– реконструкция комнаты ленинградской квартиры осени 1941 – зимы 1942 гг. На
ней можно увидеть печку </span></i><i><span lang=RU style='font-size:14.0pt;
font-family:"Times New Roman",serif'>«</span></i><i><span lang=ru
style='font-size:14.0pt;font-family:"Times New Roman",serif'>буржуйку</span></i><i><span
lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>»</span></i><i><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>,
керосиновую лампу, санки, емкости для воды и прочие предметы быта, которые были
в большинстве квартир блокадного Ленинграда.</span></i></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><i><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></i></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Окно
задрапировано черной тканью согласно приказу о светомаскировке. За соблюдением
светомаскировки следили, за нарушение штрафовали (в витрине – пример штрафной
квитанции блокадного времени).</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>В окно
выведена труба печки, так называемой «буржуйки». На начало сентября в
Ленинграде было запаса угля на 75-80 дней. 17 ноября 1941 г. запретили подавать
в квартиры теплую воду для мытья. Теплоэнергия должна была использоваться лишь
для того, чтобы дома не вышли из строя. По нормам ноября температура в жилых
помещениях должна была составлять +12 градусов, в учреждениях +10, на
предприятиях +8 градусов. Однако эти нормы не соблюдались, так как далеко не
сразу люди в домах с центральным отоплением научились пользоваться печами, к
тому же в большинстве домов были выбиты окна, а фанера плохо держит тепло,
поэтому печей не хватало для отопления квартиры, и люди переезжали в 1 комнату.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'> К
сожалению, </span><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>«</span><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>буржуйки</span><span
lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>»</span><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'> были
очень пожароопасны, большинство пожаров в 1942 были из-за них. Для топлива в
печах использовали все, что горит, но по приказу правительства, нельзя было
спиливать деревья, поэтому разбирали старые постройки. Особенно много разобрали
летом-осенью перед зимой 1942 года.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>В углу
комнаты – емкости для воды и санки.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Немцы
повредили водонапорную станцию во время налета 8 сентября 1941 г. Тогда станцию
удалось пустить вновь, однако в декабре 1941 г. начались перебои с водой.
Водопровод замерз до весны. Воду стали набирать из прорубей во льду Невы и
каналов, из поврежденных бомбежкой труб, а также топили снег. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Из-за
нехватки воды вышла из строя канализация. Из-за этого люди стали выливать
нечистоты на улицу. Ассенизаторы не справлялись. До войны они использовали 100
машин и 500-600 подвод, то в декабре 1941 - 5 машин и 44 подводы. Канализацию в
значительной мере удалось восстановить только во второй половине 1942.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Также быт
изменился во многом из-за отсутствия электричества. Внутри блокадного кольца
осталось лишь 2 электростанции, поэтому с середины сентября 1941 ввели лимит
электричества, а 17 ноября отключили совсем.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Дома
пришлось освещать керосиновыми лампами (на витрине), но и к ним было мало
топлива (от 0.5 до 1 литра в мечяц), так что большую часть времени люди сидели
во тьме. Свет стали включать в домах с 1942 года, когда удалось обеспечить надежный
подвоз сырья по Ладожской трассе. Большинство домов было освещено в середине
января 1943, люди наконец смогли, не волнуясь о трате керосина, читать книги,
писать письма вечерами.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Из-за
отсутствия электричества также встал транспорт. В Ленинграде было 42 трамвайных
маршрута, к концу 1941 ни одного. Поэтому большинство грузов возили на санках и
тележках. Санки вообще стали универсальным средством передвижения, на них
возили вещи, больных и даже трупы к местам захоронений.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Уличное
освещение было отключено, поэтому при хождении по улицам в темное время
пользовались «светлячками» - значками из фосфора (в витрине). Это делалось для
того, чтобы не сталкиваться, т.к. в случае падения обессилевшие от голода люди
не имели сил подняться или помочь подняться другому.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='margin-left:35.45pt;text-align:justify;line-height:
normal'><b><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>9.4
</span></b><b><span lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Борьба
с преступностью.</span></b></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=ru
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><i><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>С началом
продовольственного кризиса в блокадном Ленинграде кривая преступности резко
пошла вверх. Быстро росло число краж сельхозпродукции на колхозных полях,
участились квартирные кражи. Пожалуй, самым страшным преступлением считалось
людоедство. В экспозиции – приказ Говорова 1943 г. о борьбе с каннибалами.</span></i></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><i><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></i></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Накануне
Великой Отечественной войны Ленинград считался самым благополучным городом
СССР. Приметой осажденного города стало увеличение пеших и конных патрулей. С
27 августа 1941 года был установлен комендантский час с 10 часов вечера до 5
часов утра. Передвижение по городу в это время запретили. Выставлялись
контрольно-пропускные пункты у мостов через Неву, на центральных дорогах.
Следили за всем, проверяли содержимое багажа, задерживали подозрительных лиц. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Преступников
в блокированном Ленинграде можно разделить на две категории: профессиональных
преступников и людей, которых толкнули на преступление тяжелые условия жизни.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>С началом
продовольственного кризиса кривая преступности резко пошла вверх. Быстро росло
число краж сельхозпродукции на колхозных полях, птицы и мелкого скота. Жильцы
коммунальных квартир, пытаясь найти теплые вещи и продукты питания, самовольно
вскрывали комнаты ушедших на фронт или уехавших в эвакуацию людей. Как правило,
этих людей не судили, ограничиваясь мерами административного воздействия.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>         Но
были и профессиональные квартирные воры. Их шайки были выявлены практически во
всех районах Ленинграда, и судили их беспощадно. Особенно досаждали
ленинградцам карманники, которые крали карточки и вырывали у ослабевших от
голода людей сумки с пайками. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'> Пожалуй,
самым страшным преступлением считалось людоедство. В большинстве случаев
каннибализм, не сопровождался умерщвлениями — мертвые лежали всюду. Первые
случаи каннибализма официально отмечены в третьей декаде ноября 1941 года.
Сначала их было немного. Но уже за первые полгода 1942 года за употребление в
пищу трупов были задержаны: 2003 человека. С лета 1942 года наблюдается быстрое
снижение числа лиц, обвиненных в каннибализме. К весне 1943 года случаи
людоедства перестали отмечаться. Действовавший Уголовный кодекс 1926 года не
предусматривал наказания за людоедство, однако, в связи с крайней общественной
опасностью данного деяния, за людоедство и трупоедство наказывали как за
бандитизм по ст. УК 59-3. В экспозиции можно увидеть приказ Говорова 1943 г. о
борьбе с каннибалами.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Бандитизм
также был распространён в годы блокады. По милицейским данным, основной
контингент бандитов составляли дезертиры из действующей армии. В 1942 году
раскрываемость бандитизма составила 81,2 %, в 1943 году – 98,1 %, в 1944–1945
годах все бандитские группировки были ликвидированы.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Особенно
трудное положение во время блокады было в тюрьмах. Паек там был гораздо меньше
обычного рабочего, кроме того, если на свободе человек мог обменять вещи на
еду, то у заключенных такой возможности не было. Смертность в тюрьмах была
высокая. Но число арестов не уменьшалось. Арестовывали по подозрению в шпионаже
и предательстве, достаточным основанием для осуждения было и чтение сброшенных
с самолетов фашистских листовок. Руководители НКВД писали в отчетах, что с 22
июня 1941 года по 30 сентября 1942 года в блокированном Ленинграде ими было
арестовано 9574 человека.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Деятельность
органов государственной безопасности была сосредоточена на борьбе с
деятельностью немецкой разведки на фронте, выявлении и ликвидации агентов
противника в тыловых районах СССР, разведке и диверсиях в тылу противника. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><b><span
lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>9.5 </span></b><b><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Промышленность</span></b><b><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>.</span></b></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=ru
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><i><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>С началом
войны большинство предприятий переключилось на выпуск военной </span></i><i><span
lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>продукции</span></i><i><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>. За
полгода успели произвести: более полутора тысяч единиц различной техники, около
3000 пушек и 1685 тыс. снарядов разных калибров. Однако из-за отсутствия
энергии большинство предприятий начали закрывать, и до середины 1942 осталось
50 из 270. Поэтому позже выпуск </span></i><i><span lang=RU style='font-size:
14.0pt;font-family:"Times New Roman",serif'>значительно уменьшился</span></i><i><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>.</span></i></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><i><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></i></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Ленинград
- крупнейший промышленный центр оборонного значения. Перед войной около 75%
выпускаемой продукции относилось к оборонному комплексу. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>С началом
войны началась мобилизация промышленности, рабочая смена выросла до 11,5 часов,
была поставлена задача по увеличению выпуска тяжелых танков КВ.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Из-за
роста заказов пришлось разбронировать стратегические запасы сырья и
перепрофилировать предприятия на выпуск военной продукции. Так на химических
предприятиях начали делать взрывчатку, средства химической защиты; на
текстильных и швейных фабриках обмундирование, белье, специальные ткани;
обувные - сапоги и военные ботинки; сотни мелких предприятий начали делать
автоматы, гильзы, бомбы.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Промышленностью
Ленинграда за полгода было изготовлено для фронта 318 самолетов, 713 танков (в
том числе 526 КВ), 58 бронепоездов и бронеплощадок, 480 бронемашин, 2406
полковых пушек, 97 морских артиллерийских орудий, 643 пушки калибра 45-мм, 275
дотов, 1375 тыс. корпусов мин, 1685 тыс. артиллерийских снарядов и ряд другой
военной продукции. К концу 1941 г. 126 ленинградских заводов перестроились на
выпуск боеприпасов и сдали фронту свыше 7 млн. единиц разных их видов, в 10 раз
превысив выпуск в первом полугодии.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Из-за
нехватки электроэнергии было законсервировано 270 фабрик и заводов, а остальные
действовали не на полную мощность. Спад промышленности продолжался до весны
1942 г. Ощущалась острая нехватка рабочей силы из-за смертности, что привело к
увеличению числа женщин на предприятиях.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>К марту
1942 г. благодаря завозу угля по Дороге Жизни, лесо- и торфозаготовкам стала
улучшаться ситуация с электроэнергией, и в апреле 1942 военную продукцию давали
50 предприятий, в июне 1942 г – 75. К осени 1942 г. производилось около 100
видов военной продукции.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>В 1942 г.
введена медаль «За оборону Ленинграда». В витрине – пробные образцы медали,
изготовленные на Монетном дворе.</span></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=ru
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><b><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>9.6
</span></b><b><span lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Культура.
Театр, музыка, живопись. Радио. Наука.</span></b></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=ru
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><i><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Несмотря
на огромные трудности искусство продолжало развиваться в блокадном Ленинграде.
В витрине можно увидеть кисти, краски, палитру известного художника Ю. М.
Непринцева и картину художника А. Ф. Пахомова. В августе 1942 года в Филармонии
была исполнена  Седьмая симфония Дмитрия Шостаковича. На стене – афиша и
программа концерта, фотографии Шостаковича и премьерного исполнения симфонии. </span></i></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><i><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></i></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Театров в
городе во время блокады почти не осталось: большинство их вывезли из Ленинграда
к августу 1941 года. Чаще прочих давал спектакли Театр музыкальной комедии.
Театр представлял собой скорбное зрелище. В зале было холодно и не очень
светло, спектакли часто прерывались обстрелами, во время которых зрители
обязаны были идти в бомбоубежище. 23 декабря 1941 года здание театра было
разбомблено, его перевели в помещение Театра им. А С. Пушкина. Только в марте
1942 года он открылся снова. Значение Театра музыкальной комедии выявлялось в
том, что он поддерживал в какой-то мере уровень цивилизованности горожан. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Судьбу
театров в первую блокадную зиму разделила и филармония. Из музыкантов,
служивших в оркестрах Кировского театра, филармонии и радиокомитета, к апрелю
насчитывалось в Ленинграде только 20 человек. В апреле 1942 года удалось
воссоздать Большой симфонический оркестр. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>В августе
1942 года в Большом зале Филармонии впервые в Ленинграде была исполнена 
Седьмая симфония Дмитрия Шостаковича. Свое произведение композитор посвятил
родному городу, и назвал симфонию «Ленинградской». В экспозиции представлен
пюпитр для нот. На стене – афиша и программа концерта, фотографии Дмитрия
Шостаковича, а также фотографии премьерного исполнения Седьмой симфонии. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Концерт из
Ленинграда на коротких радиоволнах транслировали на Москву, а Москва передавала
по всей стране. Радиотрансляцию Седьмой симфонии из блокадного Ленинграда
принимали даже в других странах. И там убеждались, что город жив, город не
сломлен.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Труд
художников в советское время был устойчиво востребован, были весьма
распространены различные виды наглядной агитации – плакаты, лозунги, оформление
зданий в советском стиле. С началом войны многие художники ушли в армию и
народное ополчение. Те, кто остался, в первые месяцы войны сами предлагали свои
услуги властям. 27 июня 1941 власти впервые привлекли художников к военному
делу: сформированную группу направили на маскировку аэродромов. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Поскольку
художники по норме 20 ноября 1941 г. получали 125 граммов хлеба, зиму они
пережили очень тяжело. Весной 1942 г. в Ленинградское отделение союза советских
художников собрали всех художников, оставшихся в живых. Они продолжали писать
картины и устраивать выставки. Согласно приказу властей, надо было рисовать
сражающийся город, но оптимистично, с верой в победу, в лучшее время. Это
наложило отпечаток на качество работ ленинградских художников. Например, в
работах А. Ф. Пахомова (одна из его работ – в экспозиции) жители блокадного
города выглядят слишком цветущими.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>В
экспозиции представлены кисти, краски, палитра, принадлежавшие известному
художнику Юрию Михайловичу Непринцеву (1909-1996). Непринцев с июля 1941 г. по
октябрь 1942 г. был командиром взвода морской пехоты, позже - художником
Политического Управления Балтийского Флота. Будучи командиром взвода, он писал
карандашом небольшие портреты боевых товарищей – балтийцев, а в управлении
выпускал сатирические плакаты. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>После
освобождения Ленинградской области военные художники приняли участие и в
формировании выставки «Оборона Ленинграда», которую начали создавать в октябре
1943 в Ленинградском доме Красной Армии, которая затем превратилась в Музей
обороны Ленинграда.</span></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=ru
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='margin-left:35.45pt;text-align:justify;line-height:
normal'><b><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>9.7
</span></b><b><span lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Дети.
Бомбоубежище.</span></b></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=ru
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><i><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>С начала
войны из Ленинграда было вывезено около 250 тыс</span></i><i><span lang=RU
style='font-size:14.0pt;font-family:"Times New Roman",serif'>яч</span></i><i><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'> детей, в
городе осталось около 400 тыс</span></i><i><span lang=RU style='font-size:14.0pt;
font-family:"Times New Roman",serif'>яч</span></i><i><span lang=ru
style='font-size:14.0pt;font-family:"Times New Roman",serif'> и им нужно было
где то учиться. Из-за того что многие школы были разрушены и немцы бомбили
Ленинград занятия часто проходили в бомбоубежищах, что и представлено на
экспозиции: на переднем плане как будто идут занятия, на заднем – выходят
наружу девушки-бойцы МПВО. </span></i></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><i><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></i></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Почти
сразу после начала войны было принято решение эвакуировать из Ленинграда 392
тыс</span><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>яч</span><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'> детей. 29
июня 1941 года десятью железнодорожными эшелонами из города вывезли 15 192
ребенка. 30 июня, девятнадцатью эшелонами, 32 236 детей. С 29 июня по 5 июля
1941 года было эвакуировано 212 209 человек (из них 162 439 в Ленинградскую
область и 49 770 – в Ярославскую). Однако это оказалось ошибкой, так как эти
районы стали подвергаться нападению немецкой авиации, из-за чего часть людей
вернулось в Ленинград. Правительство отрицало нападения на эшелоны с
эвакуированными, чтобы не вызвать панику. Самая страшная трагедия произошла 18
августа на станции Лычково. Немецкий бомбардировщик сбросил бомбы на состав с
эвакуированными детьми.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>С начала
войны сильно выросло количество детей-сирот и, начиная с января 1942, начали
открываться новые детские дома, всего было открыто 85 заведений вместивших 30
тыс</span><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>яч</span><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'> детей.
Подростков определяли в училища. Среди населения собирали одежду, обувь, посуду
и прочие необходимые вещи. К сожалению, не все дети смогли попасть в детские
дома, многие умирали по пути до него, или в райсовете, или прямо на пороге.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Разумеется
детей пытались вывезти. Вывозили самых крепких, и процесс разделения детей на
подлежащих эвакуации и остающихся </span><span lang=RU style='font-size:14.0pt;
font-family:"Times New Roman",serif'>«</span><span lang=ru style='font-size:
14.0pt;font-family:"Times New Roman",serif'>укрепляться</span><span lang=RU
style='font-size:14.0pt;font-family:"Times New Roman",serif'>»</span><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>, был
очень аморален. Это делали буквально на глазок, проверяя способность детей идти
не шатаясь и спотыкаясь.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Одним из
главных событий этого праздника</span><span lang=RU style='font-size:14.0pt;
font-family:"Times New Roman",serif'> по случаю нового, 1942 года,</span><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'> стало
проведение </span><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>«</span><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>ёлок</span><span
lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>»</span><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'> для
детей. Вход стои</span><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>л</span><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'> 5 рублей,
но для детей военных и пенсионеров бесплатно. Ёлки устраивались в Малом оперном
театре, театре им А. С. Пушкина, Большом оперном театре. На этих празднествах
дети скорее всего не запомнили ничего кроме обеденного стола, так как там они
могли поесть мясных котлет, конфет, супа, выпить компот, попробовать желе.
Некоторые дети относили еду своим родным и конечно никто не отказывался.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Несмотря
на суровые блокадные условия, власти приняли решение о необходимости продолжить
обучение детей. Свыше 90 тыс детей и подростков приступили к занятиям в
сентябре 1941. Занятия проходили в необычной обстановке, так как зачастую
приходилось спускаться в бомбоубежище и продолжать обучение там. К концу
декабря разрешили прекратить занятия из-за большой смертности детей, но 39 школ
решили продолжать. Занятия стали по 20 минут, учебный план сильно изменен, в
школах было тихо, так как у детей не было сил. Отопление отключили, поэтому
было холодно, что застывали чернила.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>После
зимних каникул занятия продолжились, а в школах даже начали появляться
полноценные обеды. Весной начали открываться школы, которые закрылись зимой,
школьная программа заключалась в повторении. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Несмотря
на истощение, дети вносили посильный вклад в жизнь города, совмещая учебу с
работой. Подростки работали на заводах, выращивали овощи, ухаживали за
ранеными, помогали в поимке шпионов. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Также с
лета началась подготовка к новому учебному году, сооружались печи,
восстанавливали канализации, организовывали питание. В конце 1942 года учебные
занятия проходили в 86 школах Ленинграда. В них училось 27 тысяч детей, в
основном младшие классы, так как подростки трудились наравне со взрослыми или
осваивали профессию. Однако все равно приходилось учиться под бой канонады или
без света, так как война продолжалась.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>С января
1943, с прорывом блокады начало расти количество учеников и к учебному году
44/45 года действовало 200 школ. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Большую
роль в выживании города сыграли бомбоубежища(обычно подвалы домов), к концу
войны их было около 4600. В них жили дети, за которыми некому было присмотреть,
истощенные граждане, чтобы им не нужно было идти до убежища при обстреле,
проводились врачебные обходы и приносили еду. Однако в бомбоубежища шли активно
только в 1941 году, после же люди привыкли к обстрелам и их приходилось
буквально загонять туда, так как они не хотели, например, терять место в
очереди, да и сидеть в подвале не самое веселое занятие.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>На стенде
вы можете увидеть имитацию дощатого щита с плакатами, выставлявшегося в
блокированном Ленинграде. При отсутствии телевидения и недостаточной доступности
кино наглядная агитация была самым действенным способом как визуальной передачи
информации, так и агитации.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>22 июня
1941 в ЛОССХ собрались, чтобы решить, чем можно быть полезным стране, и решили:
главное внимание – наглядной агитации; оформление призывных пунктов, мест
массового скопления людей и военных объектов. С осени 1941 у СХ наметился
контакт с политуправлением фронта: нужны были маленькие плакаты, рассчитанные
на блиндажи и окопы. Занимались художники также и оформлением агитационных листовок.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><b><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>9.8
</span></b><b><span lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Весна
1942 года. Очистка города, торфо-и лесозаготовки, огородничество, возобновление
движения городского транспорта.</span></b></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=ru
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=ru
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><i><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>После зимы
1941-1942 г.г. перед жителями встало множество вопросов, в том числе вопрос об
очистке города и о восстановлении транспортного движения. Постепенно военная
жизнь Ленинграда переходила к послевоенному возрождению. На фотопанно вы можете
видеть момент вступления войск в город 9 июля 1945 г. через арку на Пулковском
шоссе (ныне Московский пр.). </span></i></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Боязнь
эпидемий из-за огромного скопления трупов на улицах и во дворах, усилившаяся в
преддверии весны, стала одной из главных причин знаменитых «субботников». С 27
марта по 8 апреля 1942 г. была объявлена мобилизация всего трудоспособного
населения (мужчины от 15 до 60 лет и женщины от 15 до 55 лет) для очистки
Ленинграда. Люди, оставшиеся без работы, должны были трудиться 8 часов в день,
а рабочие — не менее 2 часов в день. Учащиеся и домохозяйки — 6 часов в день.
Но и после «субботников» печать разрухи и «мерзости запустения» не стерлась с
лица города. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Много
специалистов-энергетиков ушло на фронт, а оставшиеся продолжали работать,
обеспечивая выработку возможного количества электроэнергии. Жители города
помогали, как могли, – 3000 ленинградцев отправились на лесозаготовки, для
заготовки торфа формировались специальные «женские бригады», но наработанные
запасы быстро заканчивались. Работники электростанции собирали остатки топлива
с эвакуированных предприятий. Был разрешен снос всех деревянных построек в
черте города. Тогда же частично разобрали деревянный саркофаг Медного всадника,
на оставшихся досках появилась надпись: «Ему не холодно, а мы согреемся». Весной
1942 года началась добыча торфа на правом берегу Невы.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Осенью -
зимой 1941 г. ленинградцам катастрофически не хватало овощей, поэтому Ленинград
с весны 1942 года стал «большим огородом». Хрестоматийными, вошедшими во все
блокадные антологии стали капустные грядки на Исаакиевской площади. Был засеян
овощами Большой проспект Васильевского острова. Огороды возникли на улицах, в
парках, скверах, на пустырях, газонах. Наиболее часто встречались посевы
свеклы, капусты, салата, редиса. Все запасы картофеля были съедены во время
голода, поэтому его не сажали. Для разведения огородов предприятиям было отдано
около семи тысяч гектар пустующих земель рядом с городом, но, видимо, не все
они были засеяны. Более надежным считали выращивать овощи в черте города, где было
легче следить за их сохранностью.  </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Когда
горожане справились с задачей по очистке города, встал вопрос о восстановлении
перевозок пассажиров. Но электроэнергии по-прежнему не хватало. Поэтому на
Волховской ГЭС начались работы по вводу в строй демонтированных энергоблоков. А
от нее по дну Ладожского озера протянули электрокабели. Когда подготовительные
мероприятия были выполнены, Ленгорсовет принял постановление открыть с 15
апреля 1942 года трамвайное движение по пяти маршрутам: № 3, 7, 9, 10, 12. В дальнейшем
количество маршрутов и вагонов на них продолжало увеличиваться. К ноябрю
количество поездов, ежедневно работающих на линиях, возросло до 152 (456
вагонов), перевозивших в день до миллиона пассажиров. В экспозиции – трамвайные
билеты и ручка ленинградского трамвая.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>Постепенно
военная жизнь Ленинграда переходила к послевоенному возрождению. Салют 27
января 1944 г. был разрешен Ленинграду в виде исключения: подобные салюты
полагалось устраивать только в Москве. Но по аналогии можно сказать, что у Ленинграда
был и свой Парад Победы.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:.5in;line-height:normal'><span
lang=ru style='font-size:14.0pt;font-family:"Times New Roman",serif'>29 мая
1945 года войска Ленфронта, находившиеся в Курляндии, получили приказ начать
марш в Ленинград. Им предстояло преодолеть пешком 1000 километров. На фотопанно
вы можете видеть момент вступления войск в город 9 июля 1945 г. через арку на
Пулковском шоссе (ныне Московский пр.), в месте, где впоследствии будет разбита
Площадь Победы. </span></p>

<p class=MsoNormal><span lang=ru>&nbsp;</span></p>

</div>

</body>

</html>

                """.trimIndent(),
                rectTriangles(1182.0, 414.0, 279.0, 1767.0)
            ),
            ArtifactEntity(
                10,
                "Прорыв блокады. Дорога победы.",
                2,
                """
                    <html>

<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<meta name=Generator content="Microsoft Word 15 (filtered)">
<style>
<!--
 /* Font Definitions */
 @font-face
	{font-family:Wingdings;
	panose-1:5 0 0 0 0 0 0 0 0 0;}
@font-face
	{font-family:"Cambria Math";
	panose-1:2 4 5 3 5 4 6 3 2 4;}
 /* Style Definitions */
 p.MsoNormal, li.MsoNormal, div.MsoNormal
	{margin:0in;
	line-height:115%;
	font-size:11.0pt;
	font-family:"Arial",sans-serif;}
.MsoChpDefault
	{font-size:12.0pt;
	font-family:"Calibri",sans-serif;}
@page WordSection1
	{size:595.3pt 841.9pt;
	margin:56.7pt 42.5pt 56.7pt 85.05pt;}
div.WordSection1
	{page:WordSection1;}
 /* List Definitions */
 ol
	{margin-bottom:0in;}
ul
	{margin-bottom:0in;}
-->
</style>

</head>

<body lang=EN-US style='word-wrap:break-word'>

<div class=WordSection1>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><i><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Экспозиция
посвящена одному из ключевых моментов Великой Отечественной войны – прорыву
блокады Ленинграда.  </span></i></p>

<p class=MsoNormal style='text-align:justify;line-height:normal'><span lang=RU
style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>В
экспозиции представлены образцы оружия того времени, включая ППШ-41. Достоинствами
ППШ были простота и дешевизна конструкции, эффективная для такого оружия
дальность стрельбы, высокий темп стрельбы, из недостатков можно выделить
большой вес модели, громоздкость, а также склонность к непроизвольным выстрелам
в случае падения пистолета-пулемета на твердые поверхности.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Гранату
РГ-42. Наступательная граната дистанционного действия. Для применения РГ-42
требовалось только ввинтить запал (если он находился отдельно), выдернуть
предохранительную чеку и метнуть гранату. Запал гранаты РГ-42 безотказно
действовал при попадании в грязь, снег или воду. РГ-42 была проста в
производстве: корпус гранаты представляет собой металлическую банку,
наполненную зарядом тротила массой 110 граммов. Осколочный эффект достигается
разрывом насеченной на ромбы стальной ленты, свернутой в 4-6 слоев.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'> 82-мм
миномет. Миномет был удобен в эксплуатации, в частности, тем, что позволял
использовать трофейные мины к 81-мм германскому миномету. Выпуск 82-мм
миномётов был освоен в осаждённом Ленинграде. Выпущенные миномёты
использовались не только в войсках Ленинградского фронта, но и на других
фронтах (в ноябре 1941 года 115 шт. 82-мм миномётов были переданы из Ленинграда
в Москву и использовались в ходе битвы под Москвой, ещё 40 шт. были переданы в
войска Волховского фронт.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Поскольку
«Дорога жизни» не в состоянии была удовлетворять потребности осаждённого
города, была разработана операция «Искра» начатая утром 12-го января 1943 года.
Специально для этой операции были созданы две ударные группировки в составе
Ленинградского и Волховского фронтов. Задача бойцов состояла в преодолении 600
метров Невы и закреплении на противоположном берегу. Наиболее успешно
действовала 136-я дивизия Симоняка. Спустя некоторое количество дней 18 января
1943 года части Ленинградских и Волховских фронтов встретились.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'> В
экспозиции демонстрируются материалы, связанные с подготовкой и проведением
этой операции, включая брошюру «Умей преодолевать проволочные препятствия»,
пулемет Максима: Он поставлен на салазки и замаскирован в белый цвет. Ведение
боевых действий зимой требует специальной подготовки, в частности,
дооборудования вооружения. Идея ставить пулеметы на лыжи существовала в РККА
еще до начала второй мировой войны. Маскировка бойцов, вооружения и техники в
белый цвет применялась, как правило, в отношении передовых подразделений,
которым предстояло вести бой на снегу, еще не разрушенном взрывами и не
испачканном землей и копотью. Марля (или другая ткань) использовалась
параллельно с белой краской из-за доступности и потому, что ткань, в отличие от
краски, не демаскирует блеском. Кроме того, краска быстро стиралась с
предметов.«Форсирование реки Невы в районе деревни Марьино» художника Глеба
Савинова, который написал это полотно в 1944 году.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'> </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Особое
внимание стоит уделить строительству железнодорожной линии Шлиссельбург –
Поляны и моста через Неву, которые были ключевыми для восстановления связи
Ленинграда с «Большой землёй». Строительство началось 19 января 1943 года и
продлилось 17 дней. За это время в исключительно сложных условиях было
проложено 33 км железнодорожных путей. Можно увидеть модель высоководного моста
и рисунки, иллюстрирующие строительство и использование мостов.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Стоит
отметить, что из-за частых обстрелов немцами поезда ходили только ночью.
Гитлеровцы более 1200 раз вывели дорогу из строя, а весенние оттаивание болот
приводило к разрушению насыпи. Тем не менее дорога продолжала работать.
Улучшилось не только снабжение населения города продовольствием, а
Ленинградского фронта оружием и боеприпасами, стали оживать ленинградские
заводы, потому что на них по Дороге Победы стали поступать топливо и сырьё.</span></p>

<p class=MsoNormal><span lang=ru>&nbsp;</span></p>

</div>

</body>

</html>

                """.trimIndent(),
                rectTriangles(830.0, 700.0, 160.0, 261.0) +
                        rectTriangles(771.0, 956.0, 270.0, 150.0)
            ),
            ArtifactEntity(
                11,
                "Полное освобождение Ленинграда от вражеской блокады.",
                2,
                """
                    <html>

<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<meta name=Generator content="Microsoft Word 15 (filtered)">
<style>
<!--
 /* Font Definitions */
 @font-face
	{font-family:Wingdings;
	panose-1:5 0 0 0 0 0 0 0 0 0;}
@font-face
	{font-family:"Cambria Math";
	panose-1:2 4 5 3 5 4 6 3 2 4;}
 /* Style Definitions */
 p.MsoNormal, li.MsoNormal, div.MsoNormal
	{margin:0in;
	line-height:115%;
	font-size:11.0pt;
	font-family:"Arial",sans-serif;}
.MsoChpDefault
	{font-size:12.0pt;
	font-family:"Calibri",sans-serif;}
@page WordSection1
	{size:595.3pt 841.9pt;
	margin:56.7pt 42.5pt 56.7pt 85.05pt;}
div.WordSection1
	{page:WordSection1;}
 /* List Definitions */
 ol
	{margin-bottom:0in;}
ul
	{margin-bottom:0in;}
-->
</style>

</head>

<body lang=EN-US style='word-wrap:break-word'>

<div class=WordSection1>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><i><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Экспозиция
представляет собой глубокое погружение в события, связанные с полным
освобождением Ленинграда от блокады. </span></i></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>&nbsp;</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>В
1943 немцы значительно усилили артиллерийские обстрелы Ленинграда. Выставлены
предметы, связанные с обороной и освобождением города, включая штурмовую
винтовку СГ-43. Она была найдена на местах боев. В 1943 г. в германских войсках
появилась штурмовая винтовка – принципиально новое оружие, обладающее мощью и
меткостью винтовки и скорострельностью пулемета (в отечественной военной
терминологии этот тип оружия сейчас называется «автомат»). </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Также
выставлен стальной нагрудник СН-42. В РККА началось формирование штурмовых
инженерно-саперных бригад, предназначавшиеся для штурма сильно укрепленных
рубежей и населенных пунктов. Таких бригад под Ленинградом в разное время
воевало восемь. С осени 1943 г. бойцы бригад снабжаются стальными нагрудниками.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>В
ходе битвы за Ленинград наиболее прославился 106-й отдельный инженерно-саперный
батальон и его командир И.И. Соломахин. Свою службу батальон начал в июле 1941
г., минируя местность между реками Плюсса и Луга, в 1942 г. участвовал в боях
за Невский пятачок, в 1943 г., начиная с операции «Искра» и в боях под Синявино
включительно, использовался как штурмовой. В январе 1944 г., за двое суток до
начала общего наступления, батальон забросил в тыл противника группу глубокой
инженерной разведки. Задача группы состояла в разведке дорог и мостов на
магистральной шоссейной дороге Ленинград — Кингисепп и предотвращении взрывов
мостов отступающими немецкими войсками. Наступал вместе с войсками 42-й армии,
отличился при освобождении Красного Села и Кингисеппа. Летом 1944 г. отправлен
в резерв на Карельский перешеек.).</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Прорыв
блокады открывал путь в Прибалтику. Это улучшило положение Ленинграда, но город
продолжал сталкиваться с серьёзными трудностями. </span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Операция
«Нева-2» (также известная как Ленинградско-Новгородская стратегическая
наступательная операция) стала первой из десяти операций зимне-весенней и
летне-осенней кампании 1944 года по разгрому германских войск под Ленинградом.
В ней участвовали Ленинградский, Волховский и 2-й Прибалтийский фронты, а также
Краснознаменный Балтийский флот. Немецкая сторона ответила мощным
сопротивлением в виде армий «Север», «Карельский перешеек» и «Восток», а также
включала прочные оборонительные линии.</span></p>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>Во
конце проведения операций 24 января были освобождены город Пушкин и Павловск.
27 января является официальной датой снятия блокады, которая длилась 900 дней. </span></p>

<p class=MsoNormal><span lang=ru>&nbsp;</span></p>

</div>

</body>

</html>

                """.trimIndent(),
                circleTriangles(12, 140.0, Point(910.0, 1299.0))
            ),
            ArtifactEntity(
                12,
                "Медиатека.",
                2,
                """
                    <html>

<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<meta name=Generator content="Microsoft Word 15 (filtered)">
<style>
<!--
 /* Font Definitions */
 @font-face
	{font-family:Wingdings;
	panose-1:5 0 0 0 0 0 0 0 0 0;}
@font-face
	{font-family:"Cambria Math";
	panose-1:2 4 5 3 5 4 6 3 2 4;}
 /* Style Definitions */
 p.MsoNormal, li.MsoNormal, div.MsoNormal
	{margin:0in;
	line-height:115%;
	font-size:11.0pt;
	font-family:"Arial",sans-serif;}
.MsoChpDefault
	{font-size:12.0pt;
	font-family:"Calibri",sans-serif;}
@page WordSection1
	{size:595.45pt 841.7pt;
	margin:1.0in 1.0in 1.0in 1.0in;}
div.WordSection1
	{page:WordSection1;}
 /* List Definitions */
 ol
	{margin-bottom:0in;}
ul
	{margin-bottom:0in;}
-->
</style>

</head>

<body lang=EN-US style='word-wrap:break-word'>

<div class=WordSection1>

<p class=MsoNormal style='text-align:justify;text-indent:35.45pt;line-height:
normal'><i><span lang=RU style='font-size:14.0pt;font-family:"Times New Roman",serif'>В
заключительном зале основной экспозиции расположении медиа экраны на которых, в
том числе, можно проверить собственные знания по итогам посещения музея. </span></i></p>

</div>

</body>

</html>

                """.trimIndent(),
                rectTriangles(1051.0, 2796.0, 409.0, 181.0)
            )
        )
    }
}