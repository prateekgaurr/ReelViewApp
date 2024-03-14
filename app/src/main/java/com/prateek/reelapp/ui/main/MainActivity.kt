package com.prateek.reelapp.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.prateek.reelapp.R
import com.prateek.reelapp.databinding.ActivityMainBinding
import com.prateek.reelapp.models.GoogleSearchResultsApiResponse
import com.prateek.reelapp.ui.BaseActivity
import com.prateek.reelapp.util.ExoplayerManager
import com.prateek.reelapp.util.FetchData
import com.prateek.reelapp.util.alert
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity(), ReelInterface {

    private val viewModel : MainViewModel by viewModels()
    private lateinit var binding : ActivityMainBinding
    @Inject lateinit var adapter : ReelsAdapter
    private var lastPlayingMedia = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ExoplayerManager.initializeExoPlayer(this)

        binding.viewPager.apply {
            adapter = this@MainActivity.adapter
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

    }

    private fun onApiResponse(shortVideos: List<GoogleSearchResultsApiResponse.ShortVideo>) {
        adapter.updateList(shortVideos.filter { !it.clip.isNullOrEmpty() })
        ExoplayerManager.setMedia(shortVideos.filter { !it.clip.isNullOrEmpty() }.map { it.clip!! })

        val cb = object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                if(position > lastPlayingMedia){
                    ExoplayerManager.getExoPlayerInstance()?.seekToNextMediaItem()
                    ExoplayerManager.getExoPlayerInstance()?.play()
                }else {
                    ExoplayerManager.getExoPlayerInstance()?.seekToPreviousMediaItem()
                    ExoplayerManager.getExoPlayerInstance()?.play()
                }

                lastPlayingMedia = position

            }
        }
        binding.viewPager.registerOnPageChangeCallback(cb)

    }

    override fun onDestroy() {
        ExoplayerManager.releaseExoPlayer()
        super.onDestroy()
    }

    override fun onReelClicked(reel: GoogleSearchResultsApiResponse.ShortVideo) {
    }

    override fun onReelLikeUnlikeClicked(reel: GoogleSearchResultsApiResponse.ShortVideo) {
    }


}

