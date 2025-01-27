package ru.coolda.adeptus.screens

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import ru.coolda.adeptus.R
import ru.coolda.adeptus.Screen
import ru.coolda.adeptus.models.Artifact

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ArtifactsScreen(
    navController: NavController,
    items: List<Artifact>,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope
) {
    with(sharedTransitionScope) {
        LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
            items(items) { item ->
                ElevatedCard(
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            navController.navigate(Screen.ArtifactDetail.route(item.id))
                        }
                        .sharedElement(
                            sharedTransitionScope.rememberSharedContentState(
                                Screen.ArtifactDetail.route(item.id) + "bounds"
                            ), animatedContentScope
                        )
                ) {
                    Column {
                        AsyncImage(
                            item.icon ?: R.drawable.ic_launcher_foreground,
                            contentDescription = item.name,
                            modifier = Modifier
                                .height(120.dp)
                                .fillMaxWidth()
                                .sharedElement(
                                    sharedTransitionScope.rememberSharedContentState(
                                        Screen.ArtifactDetail.route(
                                            item.id
                                        ) + "icon"
                                    ),
                                    animatedContentScope
                                )
                        )
                        item.name?.let {
                            Text(
                                "Имя: $it", modifier = Modifier.sharedElement(
                                    sharedTransitionScope.rememberSharedContentState(
                                        Screen.ArtifactDetail.route(
                                            item.id
                                        ) + "name"
                                    ),
                                    animatedContentScope
                                )
                            )
                        }
                        item.description?.let {
                            Text(
                                "Описание: $it", modifier = Modifier.sharedElement(
                                    sharedTransitionScope.rememberSharedContentState(
                                        Screen.ArtifactDetail.route(
                                            item.id
                                        ) + "description"
                                    ),
                                    animatedContentScope
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}