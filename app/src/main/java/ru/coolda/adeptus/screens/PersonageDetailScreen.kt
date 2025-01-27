package ru.coolda.adeptus.screens

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
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
import androidx.compose.ui.unit.dp
import ru.coolda.adeptus.Screen
import ru.coolda.adeptus.models.Personage

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun PersonageDetailScreen(
    item: Personage,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope
) {
    with(sharedTransitionScope) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .sharedElement(
                    sharedTransitionScope.rememberSharedContentState(
                        Screen.PersonageDetail.route(item.id) + "bounds"
                    ), animatedContentScope
                ), tonalElevation = 1.dp
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("ID: ${item.id}")
                Icon(
                    imageVector = item.icon ?: Icons.Outlined.ErrorOutline,
                    contentDescription = item.name,
                    modifier = Modifier
                        .height(300.dp)
                        .fillMaxWidth()
                        .sharedElement(
                            sharedTransitionScope.rememberSharedContentState(
                                Screen.PersonageDetail.route(
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
                                Screen.PersonageDetail.route(
                                    item.id
                                ) + "name"
                            ),
                            animatedContentScope
                        )
                    )
                }
                item.description?.let { Text("Описание: $it") }
                item.element?.let { Text("Элемент: $it") }
                item.region?.let { Text("Регион: $it") }
            }
        }
    }
}