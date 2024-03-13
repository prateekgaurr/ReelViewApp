package com.prateek.reelapp.di

import android.content.Context
import com.prateek.reelapp.data.api.GoogleApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    companion object{
        const val BASE_URL = "https://serpapi.com/"
        const val CACHE_SIZE : Long = 10 * 1024 * 1024 // 10Mb
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        httpClient : OkHttpClient
    ) : Retrofit{
        return Retrofit.Builder()
         .baseUrl(BASE_URL)
         .addConverterFactory(GsonConverterFactory.create())
         .client(httpClient)
         .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit : Retrofit) : GoogleApi = retrofit.create(GoogleApi::class.java)

    @Provides
    @Singleton
    fun provideOkHttpClient(@ApplicationContext context: Context) : OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val builder = OkHttpClient.Builder()
        val cacheFile = context.cacheDir
        builder.cache(Cache(cacheFile, CACHE_SIZE))
        builder.connectTimeout(5, TimeUnit.MINUTES)
        builder.readTimeout(5, TimeUnit.MINUTES)
        builder.writeTimeout(5, TimeUnit.MINUTES)
        builder.addNetworkInterceptor(httpLoggingInterceptor)
        builder.protocols(listOf(Protocol.HTTP_1_1))
        return builder.build()
    }



}