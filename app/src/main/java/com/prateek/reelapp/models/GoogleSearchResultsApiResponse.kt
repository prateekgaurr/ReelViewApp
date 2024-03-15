package com.prateek.reelapp.models


import com.google.gson.annotations.SerializedName

data class GoogleSearchResultsApiResponse(
    @SerializedName("pagination")
    val pagination: Pagination,
    @SerializedName("serpapi_pagination")
    val serpapiPagination: SerpapiPagination,
    @SerializedName("short_videos")
    val shortVideos: List<ShortVideo>
) {

    data class Pagination(
        @SerializedName("current")
        val current: Int, // 1
        @SerializedName("next")
        val next: String, // https://www.google.com/search?q=shorts&oq=shorts&start=10&sourceid=chrome-mobile&ie=UTF-8
        @SerializedName("other_pages")
        val otherPages: OtherPages
    ) {
        data class OtherPages(
            @SerializedName("2")
            val x2: String, // https://www.google.com/search?q=shorts&oq=shorts&start=10&sourceid=chrome-mobile&ie=UTF-8
            @SerializedName("3")
            val x3: String, // https://www.google.com/search?q=shorts&oq=shorts&start=20&sourceid=chrome-mobile&ie=UTF-8
            @SerializedName("4")
            val x4: String, // https://www.google.com/search?q=shorts&oq=shorts&start=30&sourceid=chrome-mobile&ie=UTF-8
            @SerializedName("5")
            val x5: String // https://www.google.com/search?q=shorts&oq=shorts&start=40&sourceid=chrome-mobile&ie=UTF-8
        )
    }

    data class SerpapiPagination(
        @SerializedName("current")
        val current: Int, // 1
        @SerializedName("next")
        val next: String, // https://serpapi.com/search.json?device=mobile&engine=google&google_domain=google.com&q=shorts&start=10
        @SerializedName("next_link")
        val nextLink: String, // https://serpapi.com/search.json?device=mobile&engine=google&google_domain=google.com&q=shorts&start=10
        @SerializedName("other_pages")
        val otherPages: OtherPages
    ) {
        data class OtherPages(
            @SerializedName("2")
            val x2: String, // https://serpapi.com/search.json?device=mobile&engine=google&google_domain=google.com&q=shorts&start=10
            @SerializedName("3")
            val x3: String, // https://serpapi.com/search.json?device=mobile&engine=google&google_domain=google.com&q=shorts&start=20
            @SerializedName("4")
            val x4: String, // https://serpapi.com/search.json?device=mobile&engine=google&google_domain=google.com&q=shorts&start=30
            @SerializedName("5")
            val x5: String // https://serpapi.com/search.json?device=mobile&engine=google&google_domain=google.com&q=shorts&start=40
        )
    }


    data class ShortVideo(
        @SerializedName("clip")
        val clip: String?, // https://encrypted-vtbn0.gstatic.com/video?q=tbn:ANd9GcQZi6SeDmPhnm4A1wwHdKOOR4HyJ2UNqcoX7A
        @SerializedName("extensions")
        val extensions: List<String>,
        @SerializedName("link")
        val link: String, // https://www.youtube.com/shorts/v8vah8tZ2W0
        @SerializedName("profile_name")
        val profileName: String, // ExplosmEntertainment
        @SerializedName("source")
        val source: String, // YouTube
        @SerializedName("thumbnail")
        val thumbnail: String, // https://i.ytimg.com/vi/v8vah8tZ2W0/hqdefault.jpg?sqp=-oaymwEGCJsBEOkB&rs=AMzJL3lC8Ky-jKBPq5G9VQ2EiaeAAuxsDw
        @SerializedName("title")
        val title: String // The Mayor - #shorts
    )
}