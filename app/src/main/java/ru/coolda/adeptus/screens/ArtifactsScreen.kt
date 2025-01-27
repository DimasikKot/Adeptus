package ru.coolda.adeptus.screens

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
        items(items) { item ->
            Card(
                { navController.navigate(Screen.ArtifactDetail.route(item.id)) },
                item,
                sharedTransitionScope,
                animatedContentScope
            )
        }
    }
}

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
private fun Card(
    onClickNavigate: () -> Unit,
    item: Artifact,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope
) {
    with(sharedTransitionScope) {
        ElevatedCard(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .height(220.dp)
                .clickable(onClick = onClickNavigate)
                .sharedElement(
                    sharedTransitionScope.rememberSharedContentState(
                        Screen.ArtifactDetail.route(item.id) + "bounds"
                    ), animatedContentScope
                )
        ) {
            AsyncImage(
                item.icon ?: R.drawable.ic_launcher_foreground,
                contentDescription = item.name,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Brush.linearGradient(listOf(Color.Gray, Color(0, 0, 0))))
                    .sharedElement(
                        sharedTransitionScope.rememberSharedContentState(
                            Screen.ArtifactDetail.route(
                                item.id
                            ) + "icon"
                        ),
                        animatedContentScope
                    )
            )
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .height(70.dp)
                    .background(
                        Color.Gray
                    )
                    .alpha(0.2f)
            ) {
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