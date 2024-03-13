package com.prateek.reelapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.prateek.reelapp.models.SavedVideo

@Database(entities = [SavedVideo::class], version = 1, exportSchema = false)
abstract class VideosDatabase : RoomDatabase() {
    abstract fun videosDao(): VideosDao
}
