package edu.oregonstate.cs492.githubsearch.data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubService {
    @GET("search/repositories") // Conventional to omit the leading slash, base URL down below

    fun searchRepositories(
        @Query("q") query: String, // GitHub wants us to start a query with a q
        @Query("sort") sort: String = "stars"
    ): Call<String>

    companion object { // Anonymous object attached to a class/interface
        private val BASE_URL = "https://api.github.com/" // Convention to end with a slash

        // GitHubService.create()
        fun create(): GitHubService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
                .create(GitHubService::class.java) // Class reference to refer to an interface itself
        }
    }
}