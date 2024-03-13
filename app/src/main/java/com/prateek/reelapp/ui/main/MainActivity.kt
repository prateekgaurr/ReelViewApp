package com.prateek.reelapp.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.prateek.reelapp.R
import com.prateek.reelapp.databinding.ActivityMainBinding
import com.prateek.reelapp.models.GoogleSearchResultsApiResponse
import com.prateek.reelapp.ui.BaseActivity
import com.prateek.reelapp.util.FetchData
import com.prateek.reelapp.util.alert
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val viewModel : MainViewModel by viewModels()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        Log.i("MAIN", "API Responsed")
    }

}