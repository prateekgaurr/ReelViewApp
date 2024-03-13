package com.prateek.reelapp.models


import com.google.gson.annotations.SerializedName

data class GoogleSearchResultsApiResponse(
    @SerializedName("immersive_products")
    val immersiveProducts: List<ImmersiveProduct>,
    @SerializedName("inline_videos")
    val inlineVideos: List<InlineVideo>,
    @SerializedName("knowledge_graph")
    val knowledgeGraph: KnowledgeGraph,
    @SerializedName("organic_results")
    val organicResults: List<OrganicResult>,
    @SerializedName("pagination")
    val pagination: Pagination,
    @SerializedName("related_searches")
    val relatedSearches: List<RelatedSearche>,
    @SerializedName("search_information")
    val searchInformation: SearchInformation,
    @SerializedName("search_metadata")
    val searchMetadata: SearchMetadata,
    @SerializedName("search_parameters")
    val searchParameters: SearchParameters,
    @SerializedName("serpapi_pagination")
    val serpapiPagination: SerpapiPagination,
    @SerializedName("shopping_results")
    val shoppingResults: List<ShoppingResult>,
    @SerializedName("short_videos")
    val shortVideos: List<ShortVideo>,
    @SerializedName("top_stories_link")
    val topStoriesLink: String, // https://www.google.com/search?q=shorts+nearby&sa=X&ved=2ahUKEwjor4KD5PGEAxWKMlkFHX1rCX0Q1KsKKAN6BAglEAY
    @SerializedName("top_stories_serpapi_link")
    val topStoriesSerpapiLink: String // https://serpapi.com/search.json?device=mobile&engine=google&google_domain=google.com&q=shorts+nearby
) {
    data class ImmersiveProduct(
        @SerializedName("extensions")
        val extensions: List<String>,
        @SerializedName("extracted_original_price")
        val extractedOriginalPrice: Int, // 50
        @SerializedName("extracted_price")
        val extractedPrice: Double, // 60.0
        @SerializedName("immersive_product_page_token")
        val immersiveProductPageToken: String, // eyJlaSI6InV1VHhaZWpxSllybDVOb1BfZGFsNkFjIiwicHJvZHVjdGlkIjoiIiwiY2F0YWxvZ2lkIjoiMzEyNjE5MDY5MDc3NTE5ODQ4OSIsInZjIjoiIiwidnNjIjoiIiwiaGVhZGxpbmVPZmZlckRvY2lkIjoiNzk2MTYyOTc0MzgwNTYxMzE4MCIsImltYWdlRG9jaWQiOiI0MTU0NjEzMTAwMzIwNzI3MTYiLCJyZHMiOiJQQ181ODU0NjU3Nzg2NjQyNjk4NzU0fFBST0RfUENfNTg1NDY1Nzc4NjY0MjY5ODc1NCIsInF1ZXJ5Ijoic2hvcnRzIn0=
        @SerializedName("original_price")
        val originalPrice: String, // $50
        @SerializedName("price")
        val price: String, // $60.00
        @SerializedName("serpapi_link")
        val serpapiLink: String, // https://serpapi.com/search.json?engine=google_immersive_product&page_token=eyJlaSI6InV1VHhaZWpxSllybDVOb1BfZGFsNkFjIiwicHJvZHVjdGlkIjoiIiwiY2F0YWxvZ2lkIjoiMzEyNjE5MDY5MDc3NTE5ODQ4OSIsInZjIjoiIiwidnNjIjoiIiwiaGVhZGxpbmVPZmZlckRvY2lkIjoiNzk2MTYyOTc0MzgwNTYxMzE4MCIsImltYWdlRG9jaWQiOiI0MTU0NjEzMTAwMzIwNzI3MTYiLCJyZHMiOiJQQ181ODU0NjU3Nzg2NjQyNjk4NzU0fFBST0RfUENfNTg1NDY1Nzc4NjY0MjY5ODc1NCIsInF1ZXJ5Ijoic2hvcnRzIn0%3D
        @SerializedName("source")
        val source: String, // Abercrombie & Fitch
        @SerializedName("thumbnail")
        val thumbnail: String, // https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcQbHagveSsIskwVNeEbGPLWMn3kMCJhMwbAkCIsixqlZ-mjnYsNCAaGqzu9RQ4nJveomz1Htv_-b6qVU_PHLJUfBtG_citx0pcxiaV4OXEdjIAfHqKbGPqyqw
        @SerializedName("title")
        val title: String // Abercrombie & Fitch Women's Curve Love High Rise Mom Short
    )

    data class InlineVideo(
        @SerializedName("channel")
        val channel: String, // Rick Smith, Jr.
        @SerializedName("date")
        val date: String, // 3 weeks ago
        @SerializedName("duration")
        val duration: String, // 0:23
        @SerializedName("link")
        val link: String, // https://m.youtube.com/shorts/PkS6Cnh3dvM
        @SerializedName("platform")
        val platform: String, // YouTube
        @SerializedName("position")
        val position: Int, // 1
        @SerializedName("thumbnail")
        val thumbnail: String, // https://i.ytimg.com/vi/PkS6Cnh3dvM/mqdefault.jpg?sqp=-oaymwEFCIcBEEw&rs=AMzJL3nk5IoYo7Gjb2EVX2H-TXHIknPjuA
        @SerializedName("title")
        val title: String // THIS REACTION WAS PRICELESS 😂 #shorts
    )

    data class KnowledgeGraph(
        @SerializedName("image")
        val image: String, // https://serpapi.com/searches/65f1e4b9fa8675cd64ae0a18/images/9b706411c010b622c57ed9830303e4f644274239d008210e.png
        @SerializedName("kgmid")
        val kgmid: String, // /g/11hshy3s20
        @SerializedName("knowledge_graph_search_link")
        val knowledgeGraphSearchLink: String, // https://www.google.com/search?kgmid=/g/11hshy3s20&hl=en-US&hl=YouTube Shorts
        @SerializedName("serpapi_knowledge_graph_search_link")
        val serpapiKnowledgeGraphSearchLink: String, // https://serpapi.com/search.json?device=mobile&engine=google&google_domain=google.com&hl=en-US&kgmid=%2Fg%2F11hshy3s20&q=shorts
        @SerializedName("tabs")
        val tabs: List<Tab>,
        @SerializedName("title")
        val title: String // YouTube Shorts
    ) {
        data class Tab(
            @SerializedName("link")
            val link: String, // https://www.google.com/search?sca_esv=09fdf5ad3c7db8b8&q=shorts&uds=AMwkrPsDPzzWHZzIL127sG5w41F6Rky1GlC7oG1JAuP0xfmbcrOQmjNGk9QYsU0Td3KP3SGI2n5zu88k2Rc-io_Ass9Zx8jfLDKPLqmex65C8kf-oERBy0fBoszMea5NncDjHwssC3Wctw0Pp980bANUWcGxQ4oTYlPvvYzanhi3XYTLZF9Ws78fJUsO6M2uWxleTMEfbFm-oK_K0fglAAlCDm7PQtNWsE2vSPnVXTkYDXKOa1Nbw4EW8G0bKw7Gdzkv0LBlgWmFB3aH7eIJj1OCNfkQlw09fpSY4iDV2vVhX2qvvpxb6x4rJL3HajctQIPQO49a7EwrOkCYySXanuuhi1Y9XGkzfQ&udm=28&prmd=ivnmbhtz&sa=X&ved=2ahUKEwjor4KD5PGEAxWKMlkFHX1rCX0QtKgLegQIDhAB
            @SerializedName("serpapi_link")
            val serpapiLink: String, // https://serpapi.com/search.json?device=mobile&engine=google&google_domain=google.com&q=shorts
            @SerializedName("text")
            val text: String // All
        )
    }

    data class OrganicResult(
        @SerializedName("date")
        val date: String, // Dec 26, 2022
        @SerializedName("displayed_link")
        val displayedLink: String, // https://m.youtube.com › hashtag › s...
        @SerializedName("favicon")
        val favicon: String, // https://serpapi.com/searches/65f1e4b9fa8675cd64ae0a18/images/7e7322a8afec3ed249f06045dc8c91024405444cde8fd03dc5ca4d65cd44856b.png
        @SerializedName("images")
        val images: List<String>,
        @SerializedName("link")
        val link: String, // https://m.youtube.com/hashtag/shorts
        @SerializedName("position")
        val position: Int, // 1
        @SerializedName("redirect_link")
        val redirectLink: String, // https://www.google.com/url?sa=t&source=web&rct=j&opi=89978449&url=https://m.youtube.com/hashtag/shorts&ved=2ahUKEwjor4KD5PGEAxWKMlkFHX1rCX0QFnoECBMQAQ
        @SerializedName("rich_snippet")
        val richSnippet: RichSnippet,
        @SerializedName("snippet")
        val snippet: String, // How Normal People Walk In Water Vs. Me #Shorts. Luke Davidson. 9.1M views ; Legendary #shorts. Noel Robinson. 322M views ; carnivorous slide of evolution # ...
        @SerializedName("source")
        val source: String, // YouTube
        @SerializedName("thumbnail")
        val thumbnail: String, // https://serpapi.com/searches/65f1e4b9fa8675cd64ae0a18/images/7e7322a8afec3ed249f06045dc8c9102cc64dcfe2f980502216e78841309780d.jpeg
        @SerializedName("title")
        val title: String // Shorts
    ) {
        data class RichSnippet(
            @SerializedName("bottom")
            val bottom: Bottom
        ) {
            data class Bottom(
                @SerializedName("extensions")
                val extensions: List<String>
            )
        }
    }

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

    data class RelatedSearche(
        @SerializedName("block_position")
        val blockPosition: Int, // 1
        @SerializedName("items")
        val items: List<Item>
    ) {
        data class Item(
            @SerializedName("image")
            val image: String, // https://serpapi.com/searches/65f1e4b9fa8675cd64ae0a18/images/00f81ee9cc7a39bb5052593ada99f3d9a6496a3745cdced61cb4479d249ce986b16d72b8925e224d.gif
            @SerializedName("link")
            val link: String, // https://www.google.com/search?sca_esv=09fdf5ad3c7db8b8&si=AKbGX_rO4P19IF_yO85wYpkEaz-W_oZWd5JUOOVnUVftf2aeocfd31NaNzF-iHAm5cTahwjbXOJJNvxZ9ZQYdxdqNVUBSykVAHI1bS6dfWt3pecCU18QPDz6-7rHa24plZdKaNmVFho5iZwzHPtao3fb4yZNydwe97VVjwXprFfhYKWPe9sm788HELD6gA0BRecsviz66mHO8dsw8w3ij4FE2fpfRlTZ523zcegC_gbxQISfhTk_HYEJOYVH_Lx85a6BHYJOaQqhpGUYvaY6Dt4gBSULWcaEJ8Xa-4dBSAMBwDjeFdT5JI8Kv-EAfLfMuP-dtBg7tHz5&q=YouTube+Kids&sa=X&ved=2ahUKEwjor4KD5PGEAxWKMlkFHX1rCX0Qs9oBKAB6BAhEEAk
            @SerializedName("name")
            val name: String, // YouTube Kids
            @SerializedName("serpapi_link")
            val serpapiLink: String // https://serpapi.com/search.json?device=mobile&engine=google&google_domain=google.com&q=YouTube+Kids&si=AKbGX_rO4P19IF_yO85wYpkEaz-W_oZWd5JUOOVnUVftf2aeocfd31NaNzF-iHAm5cTahwjbXOJJNvxZ9ZQYdxdqNVUBSykVAHI1bS6dfWt3pecCU18QPDz6-7rHa24plZdKaNmVFho5iZwzHPtao3fb4yZNydwe97VVjwXprFfhYKWPe9sm788HELD6gA0BRecsviz66mHO8dsw8w3ij4FE2fpfRlTZ523zcegC_gbxQISfhTk_HYEJOYVH_Lx85a6BHYJOaQqhpGUYvaY6Dt4gBSULWcaEJ8Xa-4dBSAMBwDjeFdT5JI8Kv-EAfLfMuP-dtBg7tHz5
        )
    }

    data class SearchInformation(
        @SerializedName("query_displayed")
        val queryDisplayed: String // shorts
    )

    data class SearchMetadata(
        @SerializedName("created_at")
        val createdAt: String, // 2024-03-13 17:39:05 UTC
        @SerializedName("google_url")
        val googleUrl: String, // https://www.google.com/search?q=shorts&oq=shorts&sourceid=chrome-mobile&ie=UTF-8
        @SerializedName("id")
        val id: String, // 65f1e4b9fa8675cd64ae0a18
        @SerializedName("json_endpoint")
        val jsonEndpoint: String, // https://serpapi.com/searches/6d45d56a17f5496e/65f1e4b9fa8675cd64ae0a18.json
        @SerializedName("processed_at")
        val processedAt: String, // 2024-03-13 17:39:05 UTC
        @SerializedName("raw_html_file")
        val rawHtmlFile: String, // https://serpapi.com/searches/6d45d56a17f5496e/65f1e4b9fa8675cd64ae0a18.html
        @SerializedName("status")
        val status: String, // Success
        @SerializedName("total_time_taken")
        val totalTimeTaken: Double // 1.84
    )

    data class SearchParameters(
        @SerializedName("device")
        val device: String, // mobile
        @SerializedName("engine")
        val engine: String, // google
        @SerializedName("google_domain")
        val googleDomain: String, // google.com
        @SerializedName("q")
        val q: String // shorts
    )

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

    data class ShoppingResult(
        @SerializedName("block_position")
        val blockPosition: String, // bottom
        @SerializedName("extensions")
        val extensions: List<String>,
        @SerializedName("extracted_old_price")
        val extractedOldPrice: Int, // 14
        @SerializedName("extracted_price")
        val extractedPrice: Double, // 109.0
        @SerializedName("link")
        val link: String, // https://www.google.com/aclk?sa=l&ai=DChcSEwjUw4uD5PGEAxVdXEcBHbadCFsYABAIGgJxdQ&ae=2&gclid=EAIaIQobChMI1MOLg-TxhAMVXVxHAR22nQhbEAsYASABEgKtPfD_BwE&sig=AOD64_2cqJlVSrBXMxliD0REm4wJHotjvQ&ctype=5&q=&ved=2ahUKEwjor4KD5PGEAxWKMlkFHX1rCX0Q8w4oAHoECAEQDA&adurl=
        @SerializedName("old_price")
        val oldPrice: String, // $14
        @SerializedName("position")
        val position: Int, // 1
        @SerializedName("price")
        val price: String, // $109.00
        @SerializedName("publisher")
        val publisher: String, // Shop now
        @SerializedName("publisher_link")
        val publisherLink: String, // https://www.google.com/aclk?sa=l&ai=DChcSEwjUw4uD5PGEAxVdXEcBHbadCFsYABAIGgJxdQ&ae=2&gclid=EAIaIQobChMI1MOLg-TxhAMVXVxHAR22nQhbEAsYASABEgKtPfD_BwE&sig=AOD64_2cqJlVSrBXMxliD0REm4wJHotjvQ&ctype=5&q=&ved=2ahUKEwjor4KD5PGEAxWKMlkFHX1rCX0Q2OkJKAF6BAgBEA4&adurl=
        @SerializedName("rating")
        val rating: Double, // 4.1
        @SerializedName("reviews")
        val reviews: Int, // 6000
        @SerializedName("shipping")
        val shipping: String, // Get it by 3/30
        @SerializedName("source")
        val source: String, // CiaoGym
        @SerializedName("thumbnail")
        val thumbnail: String, // https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcQ3CiwJPtW-dt7Duv6CsoZOgVnCel9ZeHvrnPBZlJCZXC_i3pqUI4fQ9Szy-maNcuzIDlS93AbXfjs0Vb9sVsRJzIJgpGz4HliIDK45RwqRv5o0eAotPN0l6Q&usqp=CAc
        @SerializedName("title")
        val title: String // All Over Me Shorts
    )

    data class ShortVideo(
        @SerializedName("clip")
        val clip: String, // https://encrypted-vtbn0.gstatic.com/video?q=tbn:ANd9GcQZi6SeDmPhnm4A1wwHdKOOR4HyJ2UNqcoX7A
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