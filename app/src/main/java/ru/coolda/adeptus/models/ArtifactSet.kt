package ru.coolda.adeptus.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artifacts")
data class ArtifactSet(
    @PrimaryKey val id: Int,
    val name: String? = null,
    val description: String? = null,
    val icon: Int? = null,
    val rarity: Int? = null
)