package ru.coolda.adeptus.screens

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import ru.coolda.adeptus.R
import ru.coolda.adeptus.Screen
import ru.coolda.adeptus.models.Artifact

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ArtifactDetailScreen(
    item: Artifact,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope
) {
    with(sharedTransitionScope) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .sharedElement(
                    sharedTransitionScope.rememberSharedContentState(
                        Screen.ArtifactDetail.route(item.id) + "bounds"
                    ), animatedContentScope
                ), tonalElevation = 1.dp
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("ID: ${item.id}")
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
                item.region?.let { Text("Регион: $it") }
            }
        }
    }
}