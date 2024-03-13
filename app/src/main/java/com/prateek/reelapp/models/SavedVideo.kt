package com.prateek.reelapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "videos_table")
data class SavedVideo(

    @PrimaryKey(autoGenerate = true)
    var id : Long = 0,

    @ColumnInfo(name = "video_url")
    val url : String,

    @ColumnInfo(name = "is_liked")
    val isLiked : Boolean
) {

    constructor(url: String, isLiked: Boolean) : this(0, url, isLiked)

}