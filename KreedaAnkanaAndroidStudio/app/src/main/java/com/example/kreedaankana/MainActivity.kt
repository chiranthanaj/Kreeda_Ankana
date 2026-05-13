package com.example.kreedaankana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kreedaankana.ui.theme.KreedaTheme
import com.example.kreedaankana.ui.AppRoot
import com.example.kreedaankana.viewmodel.AppViewModel
import com.example.kreedaankana.viewmodel.AppViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val app = application as KreedaApplication
        setContent {
            KreedaTheme {
                val vm: AppViewModel = viewModel(factory = AppViewModelFactory(app.repository))
                AppRoot(viewModel = vm)
            }
        }
    }
}
