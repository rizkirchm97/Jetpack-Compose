package com.rizkir.androiddevtest.data.datasource.remote.dto

import kotlinx.serialization.SerialName

/**
 * created by RIZKI RACHMANUDIN on 30/10/2022
 */
@kotlinx.serialization.Serializable
data class LoginResponseDto(
    @SerialName("token")
    val token: String
)
