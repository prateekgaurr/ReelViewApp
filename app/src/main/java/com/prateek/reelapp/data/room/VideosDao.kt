package com.prateek.reelapp.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.prateek.reelapp.models.SavedVideo

@Dao
interface VideosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(savedVideo: SavedVideo)

    @Query("SELECT CASE WHEN EXISTS (SELECT * FROM videos_table WHERE video_url = :url AND is_liked = 1) THEN 1 ELSE 0 END")
    suspend fun isVideoLiked(url: String): Boolean

}