package ru.coolda.adeptus.screens

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.coolda.adeptus.Screen
import ru.coolda.adeptus.elements.ArtifactSetCard
import ru.coolda.adeptus.models.ArtifactSet

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ArtifactSetsScreen(
    navController: NavController,
    items: List<ArtifactSet>,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope
) {
    with(sharedTransitionScope) {
        LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
            items(items) { item ->
                ArtifactSetCard(
                    rarity = item.rarity,
                    icon = item.icon,
                    description = item.name,
                    modifier = Modifier
                        .padding(5.dp)
                        .height(220.dp)
                        .clickable {
                            navController.navigate(
                                Screen.ArtifactSetDetail.route(
                                    item.id
                                )
                            )
                        }
                        .sharedElement(
                            sharedTransitionScope.rememberSharedContentState(
                                Screen.ArtifactSetDetail.route(
                                    item.id
                                ) + "ArtifactSetCard"
                            ),
                            animatedContentScope
                        )
                )
            }
        }
    }
}