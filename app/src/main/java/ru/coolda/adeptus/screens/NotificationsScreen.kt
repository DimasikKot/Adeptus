package ru.coolda.adeptus.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NotificationsScreen(
    onBackGestureComplete: () -> Unit
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    var offsetX by remember { mutableFloatStateOf(0f) } // Смещение по X
    var isGestureActive by remember { mutableStateOf(false) } // Активен ли жест

    val animatedOffsetX by animateFloatAsState(
        targetValue = if (isGestureActive) offsetX else 0f,
        animationSpec = tween(durationMillis = 300)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .offset { IntOffset(animatedOffsetX.toInt(), 0) } // Смещение экрана
            .pointerInput(Unit) {
                detectHorizontalDragGestures(
                    onDragStart = { isGestureActive = true },
                    onHorizontalDrag = { change, dragAmount ->
                        offsetX = (offsetX + dragAmount).coerceIn(0f, screenWidth.value * 3) // Ограничиваем движение
                        change.consume() // Поглощаем событие
                    },
                    onDragEnd = {
                        if (offsetX > screenWidth.value / 2) { // Если смещение больше половины ширины экрана
                            onBackGestureComplete() // Завершаем жест назад
                        } else {
                            offsetX = 0f // Возвращаем экран на место
                        }
                        isGestureActive = false
                    }
                )
            }
            .background(Color.Gray)
    ) {
        // Основное содержимое экрана
        Text(
            text = "Swipe Back Gesture Screen",
            color = Color.White,
            modifier = Modifier.align(Alignment.Center),
            fontSize = 24.sp
        )
    }
}
