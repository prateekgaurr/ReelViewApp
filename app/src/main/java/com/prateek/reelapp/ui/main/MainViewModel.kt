package com.prateek.reelapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prateek.reelapp.data.repository.VideosRepository
import com.prateek.reelapp.models.GoogleSearchResultsApiResponse
import com.prateek.reelapp.util.FetchData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo : VideosRepository
) : ViewModel(){

    private val _videoLiveData = MutableLiveData<FetchData<GoogleSearchResultsApiResponse>>()
    val videosLiveData : LiveData<FetchData<GoogleSearchResultsApiResponse>> get() = _videoLiveData

    fun fetchVideosFromApi() {
        viewModelScope.launch {
            repo.fetchShortVideos(query = "shorts").collect{
                _videoLiveData.postValue(it)
            }
        }
    }

    fun isVideoLiked(url: String, callback: (Boolean) -> Unit) {
        viewModelScope.launch {
            repo.isVideoLiked(url).collect{
                if (it is FetchData.Success) {
                    callback(it.data)
                } else {
                    callback(false)
                }
            }
        }
    }

    fun likeUnlikeVideo(url: String, isLiked : Boolean) {
        viewModelScope.launch {
            repo.insertVideoInDb(videoUrl = url, isLiked = isLiked)
        }
    }
}
