package ru.coolda.adeptus.screens

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.coolda.adeptus.Screen
import ru.coolda.adeptus.elements.ArtifactSetCard
import ru.coolda.adeptus.models.ArtifactSet

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ArtifactSetDetailScreen(
    item: ArtifactSet,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope
) {
    with(sharedTransitionScope) {
        ArtifactSetCard(
            rarity = item.rarity,
            icon = item.icon,
            description = item.name,
            modifier = Modifier
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