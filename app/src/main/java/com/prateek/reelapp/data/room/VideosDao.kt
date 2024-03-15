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

    @Query("UPDATE videos_table SET is_liked = :isLiked WHERE video_url = :url")
    suspend fun updateLikeStatus(url: String, isLiked: Boolean)

    @Query("SELECT * FROM videos_table WHERE video_url = :url")
    suspend fun getVideoByUrl(url: String): SavedVideo?

    @Query("SELECT CASE WHEN EXISTS (SELECT * FROM videos_table WHERE video_url = :url AND is_liked = 1) THEN 1 ELSE 0 END")
    suspend fun isVideoLiked(url: String): Boolean

}