package ru.coolda.adeptus.models

import ru.coolda.adeptus.R

class Repository {
    private val _artifactSets = listOf(
        ArtifactSet(1, name = "Заблудший в метели", icon = R.drawable.i_n400069, rarity = 5),
        ArtifactSet(2, name = "Усмиряющий гром", icon = R.drawable.i_n400074, rarity = 4),
        ArtifactSet(3, name = "Ступающий по лаве", icon = R.drawable.i_n400079, rarity = 3),
        ArtifactSet(4, name = "Возлюбленная юная дева", icon = R.drawable.i_n400084, rarity = 2),
        ArtifactSet(5, name = "Конец гладиатора", icon = R.drawable.i_n400089, rarity = 5),
        ArtifactSet(6, name = "Изумрудная тень", icon = R.drawable.i_n400094, rarity = 4),
        ArtifactSet(7, name = "Странствующий ансамбль", icon = R.drawable.i_n400099, rarity = 4),
        ArtifactSet(8, name = "Громогласный рёв ярости", icon = R.drawable.i_n400109, rarity = 3),
        ArtifactSet(9, name = "Горящая алая ведьма", icon = R.drawable.i_n400114, rarity = 2),
        ArtifactSet(10, name = "Церемония древней знати", icon = R.drawable.i_n400119, rarity = 0),
        ArtifactSet(11, name = "Заблудший в метели", icon = R.drawable.i_n400069, rarity = 5),
        ArtifactSet(12, name = "Усмиряющий гром", icon = R.drawable.i_n400074, rarity = 4),
        ArtifactSet(13, name = "Ступающий по лаве", icon = R.drawable.i_n400079, rarity = 3),
        ArtifactSet(14, name = "Возлюбленная юная дева", icon = R.drawable.i_n400084, rarity = 2),
        ArtifactSet(15, name = "Конец гладиатора", icon = R.drawable.i_n400089, rarity = 1),
        ArtifactSet(16, name = "Изумрудная тень", icon = R.drawable.i_n400094, rarity = 5),
        ArtifactSet(17, name = "Странствующий ансамбль", icon = R.drawable.i_n400099, rarity = 4),
        ArtifactSet(18, name = "Громогласный рёв ярости", icon = R.drawable.i_n400109, rarity = 3),
        ArtifactSet(19, name = "Горящая алая ведьма", icon = R.drawable.i_n400114, rarity = 2),
        ArtifactSet(20, name = "Церемония древней знати", icon = R.drawable.i_n400119, rarity = 0),
        ArtifactSet(21, name = "Заблудший в метели", icon = R.drawable.i_n400069, rarity = 5),
        ArtifactSet(22, name = "Усмиряющий гром", icon = R.drawable.i_n400074, rarity = 4),
        ArtifactSet(23, name = "Ступающий по лаве", icon = R.drawable.i_n400079, rarity = 3),
        ArtifactSet(24, name = "Возлюбленная юная дева", icon = R.drawable.i_n400084, rarity = 2),
        ArtifactSet(25, name = "Конец гладиатора", icon = R.drawable.i_n400089, rarity = 1),
        ArtifactSet(26, name = "Изумрудная тень", icon = R.drawable.i_n400094, rarity = 5),
        ArtifactSet(27, name = "Странствующий ансамбль", icon = R.drawable.i_n400099, rarity = 4),
        ArtifactSet(28, name = "Громогласный рёв ярости", icon = R.drawable.i_n400109, rarity = 3),
        ArtifactSet(29, name = "Горящая алая ведьма", icon = R.drawable.i_n400114, rarity = 2),
        ArtifactSet(30, name = "Церемония древней знати", icon = R.drawable.i_n400119, rarity = 0),
        ArtifactSet(31, name = "Рыцарь крови", icon = R.drawable.i_n400124, rarity = 0),
    )
    private val _personages = listOf(
        Personage(
            1,
            "Klee",
            "Bomb kid",
            region = "Mond",
            element = "Pyro"
        ),
        Personage(
            2,
            "Дайнслейф",
            "Каэнриах",
        ),
        Personage(
            3,
            "Capitano",
            "Хороший",
            region = "Снежная",
            element = "Crio"
        ),
        Personage(4, "Ахав", "Face Outlined", element = "Dendro"),
        Personage(
            5,
            "Klee",
            "Bomb kid",
            region = "Mond",
            element = "Pyro"
        ),
        Personage(
            6,
            "Дайнслейф",
            "Каэнриах",
        ),
        Personage(
            7,
            "Capitano",
            "Хороший",
            region = "Снежная",
            element = "Crio"
        ),
        Personage(8, "Ахав", "Face Outlined", element = "Dendro"),
        Personage(
            9,
            "Klee",
            "Bomb kid",
            region = "Mond",
            element = "Pyro"
        ),
        Personage(
            10,
            "Дайнслейф",
            "Каэнриах",
        ),
        Personage(
            11,
            "Klee",
            "Bomb kid",
            region = "Mond",
            element = "Pyro"
        ),
        Personage(
            12,
            "Дайнслейф",
            "Каэнриах",
        ),
        Personage(
            13,
            "Capitano",
            "Хороший",
            region = "Снежная",
            element = "Crio"
        ),
        Personage(14, "Ахав", "Face Outlined", element = "Dendro"),
        Personage(
            15,
            "Klee",
            "Bomb kid",
            region = "Mond",
            element = "Pyro"
        ),
        Personage(
            16,
            "Дайнслейф",
            "Каэнриах",
        ),
        Personage(
            17,
            "Capitano",
            "Хороший",
            region = "Снежная",
            element = "Crio"
        ),
        Personage(18, "Ахав", "Face Outlined", element = "Dendro"),
        Personage(
            19,
            "Klee",
            "Bomb kid",
            region = "Mond",
            element = "Pyro"
        ),
        Personage(
            20,
            "Дайнслейф",
            "Каэнриах",
        ),
        Personage(
            21,
            "Klee",
            "Bomb kid",
            region = "Mond",
            element = "Pyro"
        ),
        Personage(
            22,
            "Дайнслейф",
            "Каэнриах",
        ),
        Personage(
            23,
            "Capitano",
            "Хороший",
            region = "Снежная",
            element = "Crio"
        ),
        Personage(24, "Ахав", "Face Outlined", element = "Dendro"),
        Personage(
            25,
            "Klee",
            "Bomb kid",
            region = "Mond",
            element = "Pyro"
        ),
        Personage(
            26,
            "Дайнслейф",
            "Каэнриах",
        ),
        Personage(
            27,
            "Capitano",
            "Хороший",
            region = "Снежная",
            element = "Crio"
        ),
        Personage(28, "Ахав", "Face Outlined", element = "Dendro"),
        Personage(
            29,
            "Klee",
            "Bomb kid",
            region = "Mond",
            element = "Pyro"
        ),
        Personage(
            30,
            "Дайнслейф",
            "Каэнриах",
        ),
    )

    fun fetchArtifactSets(): List<ArtifactSet> {
        return _artifactSets
    }

    fun getItemFromArtifactSets(id: Int): ArtifactSet? {
        return _artifactSets.filter { it.id == id }.getOrNull(0)
    }

    fun fetchPersonages(): List<Personage> {
        return _personages
    }

    fun getItemFromPersonages(id: Int): Personage? {
        return _personages.filter { it.id == id }.getOrNull(0)
    }
}