package com.rizkir.androiddevtest.presentation.login

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rizkir.androiddevtest.common.Resource
import com.rizkir.androiddevtest.data.datasource.remote.dto.LoginRequestDto
import com.rizkir.androiddevtest.domain.model.LoginRequest
import com.rizkir.androiddevtest.domain.use_case.GetUserLoginResponseUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get
import org.koin.java.KoinJavaComponent.get


/**
 * created by RIZKI RACHMANUDIN on 01/11/2022
 */
class LoginViewModel(
    private val loginUseCase: GetUserLoginResponseUseCase
): ViewModel() {
    private val _loginUseCase = MutableStateFlow(LoginState())
    val loginState: StateFlow<LoginState>
        get() = _loginUseCase

    fun onEvent(event: LoginEvent) {
        when(event) {
            is LoginEvent.Login -> {
                loginUser(event.loginRequest)
            }
            else -> Unit
        }
    }

    fun loginUser(loginRequest: LoginRequest) {
        viewModelScope.launch {
            loginUseCase(loginRequest).collect { result ->

                when(result) {
                    is Resource.Success -> {
                        _loginUseCase.value = _loginUseCase.value.copy(
                            data = result.data,
                        )
                    }
                    else -> Unit

                }

            }
        }
    }
}