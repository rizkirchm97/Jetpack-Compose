package com.rizkir.androiddevtest.data.mapper

import com.rizkir.androiddevtest.data.datasource.remote.dto.LoginRequestDto
import com.rizkir.androiddevtest.data.datasource.remote.dto.LoginResponseDto
import com.rizkir.androiddevtest.domain.model.LoginRequest
import com.rizkir.androiddevtest.domain.model.LoginResponse

/**
 * created by RIZKI RACHMANUDIN on 01/11/2022
 */

fun LoginResponseDto.toLoginResponse() = LoginResponse(
    token = token
)

fun LoginResponse.toLoginResponseDto() = LoginResponseDto(
    token = token
)

fun LoginRequest.toLoginRequestDto() = LoginRequestDto(
    email = email,
    password = password
)

fun LoginRequestDto.toLoginRequest() = LoginRequest(
    email = email,
    password = password
)

