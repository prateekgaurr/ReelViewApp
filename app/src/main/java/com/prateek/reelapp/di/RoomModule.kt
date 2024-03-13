package com.prateek.reelapp.di

import android.content.Context
import androidx.room.Room
import com.prateek.reelapp.data.room.VideosDao
import com.prateek.reelapp.data.room.VideosDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    companion object{
        const val DATABASE_NAME = "videos_database"
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): VideosDatabase {
        return Room.databaseBuilder(
            context,
            VideosDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(
        database: VideosDatabase
    ): VideosDao {
        return database.videosDao()
    }

}