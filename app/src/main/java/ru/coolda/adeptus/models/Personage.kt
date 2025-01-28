package ru.coolda.adeptus.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.coolda.adeptus.R

@Entity(tableName = "personages")
data class Personage(
    @PrimaryKey val id: Int,
    val name: String? = null,
    val description: String? = null,
    val icon: Int = R.drawable.kate_001_gacha_card_w145,
    val element: String? = null,
    val region: String? = null
)