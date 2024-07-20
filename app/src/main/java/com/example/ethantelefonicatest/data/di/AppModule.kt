package com.example.ethantelefonicatest.data.di

import com.example.ethantelefonicatest.data.network.ReqresApi
import com.example.ethantelefonicatest.data.repository.UserRepositoryImpl
import com.example.ethantelefonicatest.domain.repository.UserRepository
import com.skydoves.sandwich.retrofit.adapters.ApiResponseCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()


    @Singleton
    @Provides
    fun provideReqresApi(moshi: Moshi): ReqresApi =
        Retrofit.Builder()
            .baseUrl(ReqresApi.baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .build()
            .create(ReqresApi::class.java)

    @Singleton
    @Provides
    fun provideUserRepository(api: ReqresApi): UserRepository =
        UserRepositoryImpl(api = api)
}