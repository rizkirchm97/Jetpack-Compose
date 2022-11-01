package com.rizkir.androiddevtest.presentation.login

import com.rizkir.androiddevtest.domain.model.LoginRequest

/**
 * created by RIZKI RACHMANUDIN on 01/11/2022
 */
sealed class LoginEvent {
    data class Login(val loginRequest: LoginRequest) : LoginEvent()
    object GetToken : LoginEvent()
    object None : LoginEvent()
}