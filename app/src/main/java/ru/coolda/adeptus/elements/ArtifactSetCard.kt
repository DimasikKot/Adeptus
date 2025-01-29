package ru.coolda.adeptus.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import kotlinx.coroutines.delay
import ru.coolda.adeptus.R

@Composable
fun ArtifactSetCard(
    modifier: Modifier = Modifier,
    modifierRarity: Modifier = Modifier,
    modifierIcon: Modifier = Modifier,
    modifierDescription: Modifier = Modifier,
    rarity: Int? = null,
    icon: Int? = null,
    description: String? = null,
    needLoad: Boolean = false,
) {
    var load by rememberSaveable { mutableStateOf(!needLoad) }
    LaunchedEffect(!load) {
        delay(300)
        load = true
    }
    Box(
        modifier = modifier
            .width(170.dp)
            .height(220.dp)
            .padding(6.dp)
            .clip(MaterialTheme.shapes.small)
            .background(Color(236, 234, 237))
    ) {
        Column {
            Box(
                Modifier
                    .weight(4f)
                    .fillMaxSize()
                    .padding(bottom = 5.dp)
                    .clip(RoundedCornerShape(bottomEnd = 30.dp))
                    .background(
                        Brush.linearGradient(
                            when (rarity) {
                                5 -> listOf(Color(106, 85, 81), Color(215, 161, 88))
                                4 -> listOf(Color(94, 86, 125), Color(175, 134, 194))
                                3 -> listOf(Color(79, 83, 113), Color(75, 149, 167))
                                2 -> listOf(Color(76, 89, 90), Color(90, 138, 108))
                                1 -> listOf(Color(78, 88, 99), Color(125, 134, 146))
                                else -> listOf(
                                    Color(119, 84, 92),
                                    Color(210, 122, 110)
                                )
                            }
                        )
                    )
            ) {
                if (load) {
                    AsyncImage(
                        when (rarity) {
                            5 -> R.drawable.background_item_5_star
                            4 -> R.drawable.background_item_4_star
                            3 -> R.drawable.background_item_3_star
                            2 -> R.drawable.background_item_2_star
                            1 -> R.drawable.background_item_1_star
                            else -> R.drawable.background_item_0_star
                        },
                        contentDescription = null,
                        modifier = modifierIcon
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        alpha = 0.6f
                    )
                }
                if (load) {
                    AsyncImage(
                        model = icon ?: R.drawable.kate_001_gacha_card_w145,
                        contentDescription = null,
                        modifier = modifierIcon
                            .fillMaxSize()
                    )
                }
            }
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxSize()
            ) {
                if (load) {
                    Text(
                        text = description ?: "?",
                        modifier = modifierDescription
                            .padding(start = 5.dp, bottom = 5.dp, end = 5.dp)
                            .align(Alignment.Center),
                        color = Color(78, 88, 114),
                        style = MaterialTheme.typography.titleMedium,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
        if (rarity != null && load) {
            Column {
                Row(
                    modifier = modifierRarity
                        .weight(4f)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Bottom
                ) {
                    repeat(rarity) {
                        AsyncImage(
                            model = R.drawable.star_35,
                            contentDescription = null,
                            modifier = Modifier
                                .height(24.dp)
                        )
                    }
                }
                Spacer(Modifier.weight(1f))
            }
        }
    }
}

@Preview
@Composable
private fun ItemPreview() {
    Row {
        ArtifactSetCard(
            rarity = 5,
            description = "Заблудший в метели",
            icon = R.drawable.i_n400069
        )
        ArtifactSetCard()
    }
}