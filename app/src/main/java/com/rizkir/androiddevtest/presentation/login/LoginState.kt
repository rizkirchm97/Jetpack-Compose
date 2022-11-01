package com.rizkir.androiddevtest.presentation.login

import com.rizkir.androiddevtest.domain.model.LoginResponse

/**
 * created by RIZKI RACHMANUDIN on 01/11/2022
 */
data class LoginState(
    val isLoading: Boolean = false,
    val loadingMessage: String? = "",
    val isError: Boolean = false,
    val errorMessage: String = "",
    val data: LoginResponse? = null
)
