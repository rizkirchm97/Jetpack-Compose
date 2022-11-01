package com.rizkir.androiddevtest.domain.use_case

import com.rizkir.androiddevtest.common.Resource
import com.rizkir.androiddevtest.data.datasource.remote.dto.LoginRequestDto
import com.rizkir.androiddevtest.domain.model.LoginRequest
import com.rizkir.androiddevtest.domain.model.LoginResponse
import com.rizkir.androiddevtest.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import org.koin.androidx.compose.get

/**
 * created by RIZKI RACHMANUDIN on 01/11/2022
 */
class GetUserLoginResponseUseCase(
    private val repository: LoginRepository
) {
    suspend operator fun invoke(loginRequest: LoginRequest): Flow<Resource<LoginResponse>?> = repository.login(loginRequest)
}