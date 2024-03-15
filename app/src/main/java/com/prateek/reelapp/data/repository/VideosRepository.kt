package com.prateek.reelapp.data.repository

import com.prateek.reelapp.data.api.GoogleApi
import com.prateek.reelapp.data.room.VideosDao
import com.prateek.reelapp.models.SavedVideo
import javax.inject.Inject

class VideosRepository @Inject constructor(
    private val googleApiService : GoogleApi,
    private val videosDao: VideosDao
): BaseRepository() {

    companion object{
        const val DEVICE_TYPE = "mobile"
        const val API_KEY = "b44337198bcfabbf0c9b8f8f7cd970c7b470f8c83c8ec00f83c47aea2f53a5ef"
    }

    suspend fun fetchShortVideos(
        query : String,
    ) = executeNetworkRequest {
        googleApiService.getSearchResults(
            query = query, device = DEVICE_TYPE, apiKey = API_KEY, num = 50
        )
    }



}