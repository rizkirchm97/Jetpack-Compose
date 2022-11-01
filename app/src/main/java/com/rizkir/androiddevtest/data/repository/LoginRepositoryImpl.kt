package com.rizkir.androiddevtest.data.repository

import com.rizkir.androiddevtest.common.Constant.BASE_URL
import com.rizkir.androiddevtest.common.Resource
import com.rizkir.androiddevtest.data.datasource.remote.KtorClient
import com.rizkir.androiddevtest.data.datasource.remote.dto.LoginRequestDto
import com.rizkir.androiddevtest.data.datasource.remote.dto.LoginResponseDto
import com.rizkir.androiddevtest.data.mapper.toLoginRequestDto
import com.rizkir.androiddevtest.data.mapper.toLoginResponse
import com.rizkir.androiddevtest.domain.model.LoginRequest
import com.rizkir.androiddevtest.domain.model.LoginResponse
import com.rizkir.androiddevtest.domain.repository.LoginRepository
import io.ktor.client.features.*
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.androidx.compose.get

/**
 * created by RIZKI RACHMANUDIN on 30/10/2022
 */
class LoginRepositoryImpl(
   private val api: KtorClient
): LoginRepository {
    override suspend fun login(loginRequest: LoginRequest): Flow<Resource<LoginResponse>?> {
        return flow {
            emit(Resource.Loading(true))
            try {
               val response = api.httpClient.post<LoginResponseDto> {
                   url("$BASE_URL/login")
                     body = loginRequest.toLoginRequestDto()
               }.toLoginResponse()
                emit(Resource.Success(response))
            } catch (e: RedirectResponseException) {
                emit(Resource.Error(e.response.status.description))
            } catch (e: ClientRequestException) {
                emit(Resource.Error(e.response.status.description))
            } catch (e: ServerResponseException) {
                emit(Resource.Error(e.response.status.description))
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            }
        }
    }
}