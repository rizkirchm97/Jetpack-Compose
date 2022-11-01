package com.rizkir.androiddevtest.domain.repository

import com.rizkir.androiddevtest.common.Resource
import com.rizkir.androiddevtest.data.datasource.remote.dto.LoginRequestDto
import com.rizkir.androiddevtest.data.datasource.remote.dto.LoginResponseDto
import com.rizkir.androiddevtest.domain.model.LoginRequest
import com.rizkir.androiddevtest.domain.model.LoginResponse
import kotlinx.coroutines.flow.Flow

/**
 * created by RIZKI RACHMANUDIN on 30/10/2022
 */
interface LoginRepository {
    suspend fun login(loginRequest: LoginRequest): Flow<Resource<LoginResponse>?>
}