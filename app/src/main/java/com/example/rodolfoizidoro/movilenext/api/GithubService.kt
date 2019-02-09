package com.example.rodolfoizidoro.movilenext.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("search/repositories")
    fun searchRepositories(
        @Query(value = "q") query: String,
        @Query(value = "sort") sort: String = "stars",
        @Query(value = "order") order: String = "desc"
    ) : Call<GithubRepositoriesResult>
}
