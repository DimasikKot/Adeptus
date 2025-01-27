package ru.coolda.adeptus

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import ru.coolda.adeptus.bars.BottomNavBar
import ru.coolda.adeptus.screens.ArtifactDetailScreen
import ru.coolda.adeptus.screens.ArtifactsScreen
import ru.coolda.adeptus.screens.HomeScreen
import ru.coolda.adeptus.screens.NotificationsScreen
import ru.coolda.adeptus.screens.PersonageDetailScreen
import ru.coolda.adeptus.screens.PersonagesScreen
import ru.coolda.adeptus.screens.WeaponsScreen

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun NavGraph(repository: Repository) {
    val pagerState = rememberPagerState(initialPage = 2) { 5 }
    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack?.destination?.route
    val showBottomBar = currentRoute != null && currentRoute == "main"

    Scaffold(
        bottomBar = {
            AnimatedContent(showBottomBar) { targetState ->
                if (targetState) {
                    BottomNavBar(pagerState) { targetPage ->
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(targetPage)
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        SharedTransitionLayout {
            NavHost(
                navController = navController,
                startDestination = Screen.Main.route,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                composable(Screen.Main.route) {
                    HorizontalPager(
                        state = pagerState,
                        modifier = Modifier.fillMaxSize(),
                        beyondViewportPageCount = 5
                    ) { page ->
                        when (page) {
                            0 -> ArtifactsScreen(
                                navController, repository.fetchArtifacts(),
                                this@SharedTransitionLayout,
                                this@composable
                            )

                            4 -> WeaponsScreen()

                            2 -> HomeScreen()
                            3 -> NotificationsScreen {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(page = 2)
                                }
                            }

                            1 -> PersonagesScreen(
                                    navController, repository.fetchPersonages(),
                        this@SharedTransitionLayout,
                        this@composable
                            )
                        }
                    }
                    if (pagerState.currentPage != 2 && showBottomBar) {
                        BackHandler {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(page = 2)
                            }
                        }
                    }
                }
                composable(Screen.PersonageDetail.route) { backStackEntry ->
                    val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                    val personage = id?.let { repository.getPersonageFromID(id) }
                    personage?.let {
                        PersonageDetailScreen(
                            personage,
                            this@SharedTransitionLayout,
                            this@composable
                        )
                    }
                }
                composable(Screen.ArtifactDetail.route) { backStackEntry ->
                    val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                    val artifact = id?.let { repository.getArtifactFromID(id) }
                    artifact?.let {
                        ArtifactDetailScreen(
                            artifact,
                            this@SharedTransitionLayout,
                            this@composable
                        )
                    }
                }
            }
        }
    }
}

sealed class Screen(val route: String) {
    data object Main : Screen("main")
    data object ArtifactDetail : Screen("artifact_detail/{id}") {
        fun route(id: Int): String = "artifact_detail/$id"
    }

    data object PersonageDetail : Screen("personage_detail/{id}") {
        fun route(id: Int): String = "personage_detail/$id"
    }
}