package com.rizkir.androiddevtest.di

import com.rizkir.androiddevtest.data.datasource.remote.KtorClient
import com.rizkir.androiddevtest.data.repository.LoginRepositoryImpl
import com.rizkir.androiddevtest.domain.repository.LoginRepository
import com.rizkir.androiddevtest.domain.use_case.GetUserLoginResponseUseCase
import com.rizkir.androiddevtest.presentation.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * created by RIZKI RACHMANUDIN on 01/11/2022
 */

val appModule = module {
    single { KtorClient }
    single <LoginRepository> { LoginRepositoryImpl(get()) }
    single { GetUserLoginResponseUseCase(get()) }
    viewModel { LoginViewModel(get()) }
}