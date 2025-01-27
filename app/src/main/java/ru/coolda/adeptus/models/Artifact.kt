package ru.coolda.adeptus.models

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity(tableName = "artifacts")
data class Artifact(
    @PrimaryKey val id: Int,
    val name: String? = null,
    val description: String? = null,
    val icon: Int? = null,
    val region: String? = null,
    val rarity: Int? = null
)

//interface ArtifactRepository {
//    suspend fun getAllArtifacts(): List<Artifact>
//    suspend fun getArtifactById(id: Int): Artifact
//}
//
//class RoomArtifactRepository(private val artifactDao: ArtifactDao) : ArtifactRepository {
//    override suspend fun getAllArtifacts(): List<Artifact> {
//        return artifactDao.getAllArtifacts()
//    }
//
//    override suspend fun getArtifactById(id: Int): Artifact {
//        return artifactDao.getArtifactById(id)
//    }
//}
//
//@Dao
//interface ArtifactDao {
//    @Query("SELECT * FROM artifacts")
//    suspend fun getAllArtifacts(): List<Artifact>
//
//    @Query("SELECT * FROM artifacts WHERE id = :id")
//    suspend fun getArtifactById(id: Int): Artifact
//}
//
//class ApiArtifactRepository(private val apiService: ApiService) : ArtifactRepository {
//    override suspend fun getAllArtifacts(): List<Artifact> {
//        return apiService.fetchArtifacts()
//    }
//
//    override suspend fun getArtifactById(id: Int): Artifact {
//        return apiService.fetchArtifactById(id)
//    }
//}