package ru.coolda.adeptus

sealed class Screen(val route: String) {
    data object Main : Screen("main")
    data object ArtifactSetDetail : Screen("artifact_set_detail/{id}") {
        fun route(id: Int): String = "artifact_set_detail/$id"
    }

    data object PersonageDetail : Screen("personage_detail/{id}") {
        fun route(id: Int): String = "personage_detail/$id"
    }
}