package com.rizkir.androiddevtest.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rizkir.androiddevtest.common.Routes
import com.rizkir.androiddevtest.presentation.login.LoginViewModel
import com.rizkir.androiddevtest.presentation.login.component.LoginPage
import org.koin.androidx.compose.getViewModel

/**
 * created by RIZKI RACHMANUDIN on 01/11/2022
 */

@Composable
fun ScreenMain() {
    val navController = rememberNavController()
    val viewModel = getViewModel<LoginViewModel>()
    NavHost(navController = navController, startDestination = Routes.Login.route) {
        composable("login") {
            LoginPage(
                viewModel = viewModel,
                modifier = Modifier.fillMaxSize(),
                navController = navController
            )
        }
    }
}