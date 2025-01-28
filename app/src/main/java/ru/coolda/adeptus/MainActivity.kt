package ru.coolda.adeptus

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import ru.coolda.adeptus.models.Repository
import ru.coolda.adeptus.ui.theme.AdeptusTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { AdeptusTheme { NavGraph(Repository()) } }
    }
}

@HiltAndroidApp
class MyApplication : Application()