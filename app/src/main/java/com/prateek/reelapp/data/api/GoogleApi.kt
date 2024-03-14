package com.prateek.reelapp.data.api

import com.prateek.reelapp.models.GoogleSearchResultsApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleApi {

    @GET("search.json")
    suspend fun getSearchResults(
        @Query("q") query: String,
        @Query("num") num : Int,
        @Query("device") device: String,
        @Query("api_key") apiKey: String
    ): Response<GoogleSearchResultsApiResponse>


}