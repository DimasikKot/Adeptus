package ru.coolda.adeptus.bars

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@Composable
fun BottomNavBar(
    pagerState: PagerState,
    onPageSelected: (Int) -> Unit
) {
    val items = listOf(
        BottomNavItem.Artifacts,
        BottomNavItem.Weapons,
        BottomNavItem.Home,
        BottomNavItem.Notifications,
        BottomNavItem.Personages
    )

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = pagerState.currentPage == index,
                onClick = { onPageSelected(index) },
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = {
                    Text(
                        item.title,
                        maxLines = 1,
                        overflow = TextOverflow.Visible,
                        modifier = Modifier,
                        style = MaterialTheme.typography.labelSmall
                    )
                }, modifier = Modifier.alpha(if (pagerState.currentPage == index) 1f else 0.8f)
            )
        }
    }
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