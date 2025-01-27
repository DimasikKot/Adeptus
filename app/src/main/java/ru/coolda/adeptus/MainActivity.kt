package ru.coolda.adeptus

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChildCare
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material.icons.twotone.SmokingRooms
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.delay
import ru.coolda.adeptus.models.Artifact
import ru.coolda.adeptus.models.Personage
import ru.coolda.adeptus.ui.theme.AdeptusTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var load by remember { mutableStateOf(false) }
            LaunchedEffect(Unit) {
                delay(5000)
                load = true
            }
            if (load) {
                AdeptusTheme { NavGraph(Repository()) }
            }
        }
    }
}

@HiltAndroidApp
class MyApplication : Application()

class Repository {
    private val _artifacts = listOf(
        Artifact(1, name = "Крио сет", icon = R.drawable.cake01),
        Artifact(2, name = "Anemo", "Сила в пуках", icon = R.drawable.cake02, "Modshtadt"),
        Artifact(3, description = "????", region = "????sd"),
        Artifact(4, name = "Крио сет", icon = R.drawable.cake03),
        Artifact(5, name = "Anemo", "Сила в пуках", icon = R.drawable.cake04, "Modshtadt"),
        Artifact(6, description = "????", region = "????sd"),
        Artifact(7, name = "Крио сет", icon = R.drawable.cake05),
        Artifact(8, name = "Anemo", "Сила в пуках", icon = R.drawable.cake06, "Modshtadt"),
        Artifact(9, description = "????", region = "????sd"),
        Artifact(10, name = "Крио сет", icon = R.drawable.cake07),
        Artifact(11, name = "Anemo", "Сила в пуках", icon = R.drawable.cake08, "Modshtadt"),
        Artifact(12, description = "????", region = "????sd"),
        Artifact(13, name = "Крио сет", icon = R.drawable.cake09),
        Artifact(14, name = "Anemo", "Сила в пуках", icon = R.drawable.cake10, "Modshtadt"),
        Artifact(15, description = "????", region = "????sd"),
        Artifact(16, name = "Крио сет", icon = R.drawable.cake01),
        Artifact(17, name = "Anemo", "Сила в пуках", icon = R.drawable.cake02, "Modshtadt"),
        Artifact(18, description = "????", region = "????sd"),
        Artifact(19, name = "Крио сет", icon = R.drawable.cake03),
        Artifact(20, name = "Anemo", "Сила в пуках", icon = R.drawable.cake04, "Modshtadt"),
        Artifact(21, description = "????", region = "????sd"),
        Artifact(22, name = "Крио сет", icon = R.drawable.cake05),
        Artifact(23, name = "Anemo", "Сила в пуках", icon = R.drawable.cake06, "Modshtadt"),
        Artifact(24, description = "????", region = "????sd"),
        Artifact(25, name = "Крио сет", icon = R.drawable.cake07),
        Artifact(26, name = "Anemo", "Сила в пуках", icon = R.drawable.cake08, "Modshtadt"),
        Artifact(27, description = "????", region = "????sd"),
        Artifact(28, name = "Крио сет", icon = R.drawable.cake09),
        Artifact(29, name = "Anemo", "Сила в пуках", icon = R.drawable.cake10, "Modshtadt"),
        Artifact(30, description = "????", region = "????sd")
    )
    private val _personages = listOf(
        Personage(
            1,
            "Klee",
            "Bomb kid",
            Icons.Outlined.ChildCare,
            region = "Mond",
            element = "Pyro"
        ),
        Personage(
            2,
            "Дайнслейф",
            "Каэнриах",
            Icons.TwoTone.SmokingRooms,
        ),
        Personage(
            3,
            "Capitano",
            "Хороший",
            Icons.Rounded.Warning,
            region = "Снежная",
            element = "Crio"
        ),
        Personage(4, "Ахав", "Face Outlined", element = "Dendro"),
        Personage(
            5,
            "Klee",
            "Bomb kid",
            Icons.Outlined.ChildCare,
            region = "Mond",
            element = "Pyro"
        ),
        Personage(
            6,
            "Дайнслейф",
            "Каэнриах",
            Icons.TwoTone.SmokingRooms,
        ),
        Personage(
            7,
            "Capitano",
            "Хороший",
            Icons.Rounded.Warning,
            region = "Снежная",
            element = "Crio"
        ),
        Personage(8, "Ахав", "Face Outlined", element = "Dendro"),
        Personage(
            9,
            "Klee",
            "Bomb kid",
            Icons.Outlined.ChildCare,
            region = "Mond",
            element = "Pyro"
        ),
        Personage(
            10,
            "Дайнслейф",
            "Каэнриах",
            Icons.TwoTone.SmokingRooms
        ),
        Personage(
            11,
            "Klee",
            "Bomb kid",
            Icons.Outlined.ChildCare,
            region = "Mond",
            element = "Pyro"
        ),
        Personage(
            12,
            "Дайнслейф",
            "Каэнриах",
            Icons.TwoTone.SmokingRooms
        ),
        Personage(
            13,
            "Capitano",
            "Хороший",
            Icons.Rounded.Warning,
            region = "Снежная",
            element = "Crio"
        ),
        Personage(14, "Ахав", "Face Outlined", element = "Dendro"),
        Personage(
            15,
            "Klee",
            "Bomb kid",
            Icons.Outlined.ChildCare,
            region = "Mond",
            element = "Pyro"
        ),
        Personage(
            16,
            "Дайнслейф",
            "Каэнриах",
            Icons.TwoTone.SmokingRooms
        ),
        Personage(
            17,
            "Capitano",
            "Хороший",
            Icons.Rounded.Warning,
            region = "Снежная",
            element = "Crio"
        ),
        Personage(18, "Ахав", "Face Outlined", element = "Dendro"),
        Personage(
            19,
            "Klee",
            "Bomb kid",
            Icons.Outlined.ChildCare,
            region = "Mond",
            element = "Pyro"
        ),
        Personage(
            20,
            "Дайнслейф",
            "Каэнриах",
            Icons.TwoTone.SmokingRooms,
        ),
        Personage(
            21,
            "Klee",
            "Bomb kid",
            Icons.Outlined.ChildCare,
            region = "Mond",
            element = "Pyro"
        ),
        Personage(
            22,
            "Дайнслейф",
            "Каэнриах",
            Icons.TwoTone.SmokingRooms
        ),
        Personage(
            23,
            "Capitano",
            "Хороший",
            Icons.Rounded.Warning,
            region = "Снежная",
            element = "Crio"
        ),
        Personage(24, "Ахав", "Face Outlined", element = "Dendro"),
        Personage(
            25,
            "Klee",
            "Bomb kid",
            Icons.Outlined.ChildCare,
            region = "Mond",
            element = "Pyro"
        ),
        Personage(
            26,
            "Дайнслейф",
            "Каэнриах",
            Icons.TwoTone.SmokingRooms
        ),
        Personage(
            27,
            "Capitano",
            "Хороший",
            Icons.Rounded.Warning,
            region = "Снежная",
            element = "Crio"
        ),
        Personage(28, "Ахав", "Face Outlined", element = "Dendro"),
        Personage(
            29,
            "Klee",
            "Bomb kid",
            Icons.Outlined.ChildCare,
            region = "Mond",
            element = "Pyro"
        ),
        Personage(
            30,
            "Дайнслейф",
            "Каэнриах",
            Icons.TwoTone.SmokingRooms,
        ),
    )

    fun fetchArtifacts(): List<Artifact> {
        return _artifacts
    }

    fun getArtifactFromID(id: Int): Artifact? {
        return _artifacts.filter { it.id == id }.getOrNull(0)
    }

    fun fetchPersonages(): List<Personage> {
        return _personages
    }

    fun getPersonageFromID(id: Int): Personage? {
        return _personages.filter { it.id == id }.getOrNull(0)
    }
}

//@Module
//@InstallIn(SingletonComponent::class)
//object RepositoryModule {
//
//    @Provides
//    fun providePersonageRepository(personageDao: PersonageDao): PersonageRepository {
//        return RoomPersonageRepository(personageDao)
//    }
//
//    @Provides
//    fun provideArtifactRepository(artifactDao: ArtifactDao): ArtifactRepository {
//        return RoomArtifactRepository(artifactDao)
//    }
//}
//
//@HiltViewModel
//class PersonageViewModel @Inject constructor(
//    private val personageDao: PersonageDao
//) : ViewModel() {
//
//    private val _personages = MutableLiveData<List<Personage>>()
//    val personages: LiveData<List<Personage>> = _personages
//
//    fun loadCharacters() {
//        viewModelScope.launch {
//            _personages.value = personageDao.getAllPersonages()
//        }
//    }
//}
//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//
//    @Provides
//    @Singleton
//    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
//        return Room.databaseBuilder(
//            context,
//            AppDatabase::class.java,
//            "app_database"
//        ).build()
//    }
//
//    @Provides
//    fun providePersonageDao(db: AppDatabase): PersonageDao {
//        return db.personageDao()
//    }
//
//    @Provides
//    fun provideArtifactDao(db: AppDatabase): ArtifactDao {
//        return db.artifactDao()
//    }
//}