package com.prateek.reelapp.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.media3.exoplayer.ExoPlayer
import com.prateek.reelapp.R
import com.prateek.reelapp.data.room.VideosDao
import com.prateek.reelapp.databinding.ActivityMainBinding
import com.prateek.reelapp.models.GoogleSearchResultsApiResponse
import com.prateek.reelapp.models.SavedVideo
import com.prateek.reelapp.ui.BaseActivity
import com.prateek.reelapp.util.ExoplayerManager
import com.prateek.reelapp.util.FetchData
import com.prateek.reelapp.util.alert
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity(), ReelInteractionInterface{

    private val viewModel : MainViewModel by viewModels()
    private lateinit var binding : ActivityMainBinding
    private lateinit var mediaList : List<String>
    @Inject lateinit var videosDao: VideosDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ExoplayerManager.initializeExoPlayer(this)
        binding.mainPlayerView.apply {
            controllerAutoShow = false
            player = ExoplayerManager.player
        }

        viewModel.videosLiveData.observe(this){
            binding.progressBar.visibility = View.GONE
            when(it){
                is FetchData.KnownError -> {
                    alert(it.message)
                }
                is FetchData.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is FetchData.Success -> {
                    onApiResponse(it.data.shortVideos)
                }
                is FetchData.UnknownError -> {
                    alert("Something Went Wrong")
                }
            }
        }

        viewModel.fetchVideosFromApi()

        binding.mainPlayerView.setOnTouchListener(ReelInteractionDetector(this))

    }

    private fun onApiResponse(shortVideos: List<GoogleSearchResultsApiResponse.ShortVideo>) {
        ExoplayerManager.player.repeatMode = ExoPlayer.REPEAT_MODE_ONE
        mediaList = shortVideos.filter { !it.clip.isNullOrEmpty() }.map { it.clip!! }
        ExoplayerManager.setMedia(mediaList)
        onCurrentVideoChanged(0)
    }

    override fun onDestroy() {
        ExoplayerManager.releaseExoPlayer()
        super.onDestroy()
    }

    override fun onReelTouchUp() {
        ExoplayerManager.player.play()
    }

    override fun onReelTouchDown() {
        ExoplayerManager.player.pause()
    }

    override fun onNextReel() {
        if(ExoplayerManager.player.hasNextMediaItem()){
            ExoplayerManager.player.seekToNextMediaItem()
        }else{
            Toast.makeText(this@MainActivity, "This is the Last Video", Toast.LENGTH_SHORT).show()
        }
        onCurrentVideoChanged(ExoplayerManager.player.currentMediaItemIndex)
    }

    override fun onPreviousReel() {
        if(ExoplayerManager.player.hasPreviousMediaItem()){
            ExoplayerManager.player.seekToPreviousMediaItem()
        }else{
            Toast.makeText(this@MainActivity, "This is the 1st Video", Toast.LENGTH_SHORT).show()
        }
        onCurrentVideoChanged(ExoplayerManager.player.currentMediaItemIndex)
    }

    private fun onCurrentVideoChanged(index: Int) {
        val url = mediaList[index]

        lifecycleScope.launch(Dispatchers.IO) {

            val isLiked = videosDao.isVideoLiked(url)

            withContext(Dispatchers.Main){
                binding.btLikeUnlike.setImageResource(
                    if(isLiked) R.drawable.liked_liked
                    else R.drawable.like_unliked
                )

                binding.btLikeUnlike.setOnClickListener {
                    lifecycleScope.launch(Dispatchers.IO) {
                        updateVideoStatus(mediaList[index], !isLiked){
                            onCurrentVideoChanged(0)

                        }
                    }

                }

            }


        }

    }

    private fun CoroutineScope.updateVideoStatus(s: String, b: Boolean, callback : ()->Unit) {
        launch(Dispatchers.IO) {
            val video = videosDao.getVideoByUrl(s)
            if(video != null){
                runBlocking {
                    videosDao.updateLikeStatus(s, b)
                }
                callback()
            }else{
                runBlocking {
                    videosDao.insertOrUpdate(SavedVideo(s, b))
                }
                callback()
            }
        }
    }



}


