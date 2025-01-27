package ru.coolda.adeptus.models

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity(tableName = "personages")
data class Personage(
    @PrimaryKey val id: Int,
    val name: String? = null,
    val description: String? = null,
    val icon: ImageVector? = null,
    val element: String? = null,
    val region: String? = null
)

//interface PersonageRepository {
//    suspend fun getAllPersonages(): List<Personage>
//    suspend fun getPersonageById(id: Int): Personage
//}
//
//class RoomPersonageRepository(private val personageDao: PersonageDao) : PersonageRepository {
//    override suspend fun getAllPersonages(): List<Personage> {
//        return personageDao.getAllPersonages()
//    }
//
//    override suspend fun getPersonageById(id: Int): Personage {
//        return personageDao.getPersonageById(id)
//    }
//}
//
//@Dao
//interface PersonageDao {
//    @Query("SELECT * FROM personages")
//    suspend fun getAllPersonages(): List<Personage>
//
//    @Query("SELECT * FROM personages WHERE id = :id")
//    suspend fun getPersonageById(id: Int): Personage
//}
//
//class ApiPersonageRepository(private val apiService: ApiService) : PersonageRepository {
//    override suspend fun getAllPersonages(): List<Personage> {
//        return apiService.fetchCharacters()
//    }
//
//    override suspend fun getPersonageById(id: Int): Personage {
//        return apiService.fetchCharacterById(id)
//    }
//}