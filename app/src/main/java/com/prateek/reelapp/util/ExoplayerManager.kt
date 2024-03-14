package com.prateek.reelapp.util

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer

object ExoplayerManager {

    private var exoPlayer: ExoPlayer? = null

    fun initializeExoPlayer(context: Context) {
        if (exoPlayer == null) {
            exoPlayer = ExoPlayer.Builder(context)
                .build()
        }
    }

    fun releaseExoPlayer() {
        exoPlayer?.release()
        exoPlayer = null
    }

    fun getExoPlayerInstance(): ExoPlayer? {
        return exoPlayer
    }

    fun setMedia(mediaUrls : List<String>){
        exoPlayer?.setMediaItems(mediaUrls.map { MediaItem.fromUri(it) }, true)
        exoPlayer?.playWhenReady = true
        exoPlayer?.prepare()
    }

}