package com.prateek.reelapp.util

import android.annotation.SuppressLint
import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.DefaultLoadControl
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.LoadControl


object ExoplayerManager {

    private var exoPlayer: ExoPlayer? = null

    val player : ExoPlayer
        get() = exoPlayer ?: throw IllegalStateException("ExoPlayer Not Initialized Yet")

    @SuppressLint("UnsafeOptInUsageError")
    private var loadControl = DefaultLoadControl.Builder()
        .setBufferDurationsMs(
            5000,  // Minimum buffer duration
            50000,  // Maximum buffer duration
            5000,  // Buffer before playback starts
            5000 // Buffer for playback after a rebuffer
        )
        .build()

    fun initializeExoPlayer(context: Context) {
        if (exoPlayer == null) {
            exoPlayer = ExoPlayer.Builder(context)
                .setLoadControl(loadControl)
                .build()
        }
    }

    fun releaseExoPlayer() {
        exoPlayer?.release()
        exoPlayer = null
    }

    fun setMedia(mediaUrls : List<String>){
        exoPlayer?.setMediaItems(mediaUrls.map { MediaItem.fromUri(it) }, true)
        exoPlayer?.playWhenReady = true
        exoPlayer?.prepare()
    }

}