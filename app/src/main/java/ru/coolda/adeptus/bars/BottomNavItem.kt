package ru.coolda.adeptus.bars

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Masks
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ScatterPlot
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

sealed class BottomNavItem(val title: String, val icon: ImageVector) {
    data object Artifacts :
        BottomNavItem(
            "Artifacts",
            Icons.Filled.Masks
        )

    data object Personages :
        BottomNavItem(
            "Personages",
            Icons.Filled.People
        )

    data object Home :
        BottomNavItem(
            "Home",
            Icons.Filled.Home
        )

    data object Notifications :
        BottomNavItem(
            "Notifications",
            Icons.Filled.Notifications
        )

    data object Weapons :
        BottomNavItem(
            "Weapons",
            Icons.Default.ScatterPlot
        )
}

@Preview
@Composable
private fun BottomNavItemPreview() {
    val pagerState = rememberPagerState(3) { 5 }
    val coroutineScope = rememberCoroutineScope()
    BottomNavBar(pagerState) { targetPage ->
        coroutineScope.launch {
            pagerState.animateScrollToPage(targetPage)
        }
    }
    HorizontalPager(pagerState) { }
}