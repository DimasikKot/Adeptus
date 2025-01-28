package ru.coolda.adeptus

import androidx.activity.compose.BackHandler
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
import ru.coolda.adeptus.elements.BottomNavBar
import ru.coolda.adeptus.models.Repository
import ru.coolda.adeptus.screens.ArtifactSetDetailScreen
import ru.coolda.adeptus.screens.ArtifactSetsScreen
import ru.coolda.adeptus.screens.HomeScreen
import ru.coolda.adeptus.screens.NotificationsScreen
import ru.coolda.adeptus.screens.PersonageDetailScreen
import ru.coolda.adeptus.screens.PersonagesScreen
import ru.coolda.adeptus.screens.WeaponsScreen

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun NavGraph(repository: Repository) {
    val pagerState = rememberPagerState(initialPage = 0) { 5 }
    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack?.destination?.route
    val showBottomBar = currentRoute != null && currentRoute == "main"

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavBar(pagerState) { targetPage ->
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(targetPage)
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
                            0 -> ArtifactSetsScreen(
                                repository.fetchArtifactSets(),
                                navController,
                                this@SharedTransitionLayout,
                                this@composable
                            )

                            1 -> PersonagesScreen(
                                navController, repository.fetchPersonages(),
                                this@SharedTransitionLayout,
                                this@composable
                            )

                            2 -> HomeScreen()

                            3 -> NotificationsScreen()

                            4 -> WeaponsScreen()
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
                    val item = id?.let { repository.getItemFromPersonages(id) }
                    item?.let {
                        PersonageDetailScreen(
                            item,
                            this@SharedTransitionLayout,
                            this@composable
                        )
                    }
                }
                composable(Screen.ArtifactSetDetail.route) { backStackEntry ->
                    val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                    val item = id?.let { repository.getItemFromArtifactSets(id) }
                    item?.let {
                        ArtifactSetDetailScreen(
                            item,
                            this@SharedTransitionLayout,
                            this@composable
                        )
                    }
                }
            }
        }
    }
}