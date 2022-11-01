package com.rizkir.androiddevtest.common

/**
 * created by RIZKI RACHMANUDIN on 01/11/2022
 */
sealed class Routes(val route: String) {
    object Login : Routes("login")
    object Home : Routes("home")
}
