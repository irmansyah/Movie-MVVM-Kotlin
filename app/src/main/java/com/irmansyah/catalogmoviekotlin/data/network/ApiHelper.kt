package com.irmansyah.catalogmoviekotlin.data.network

import com.irmansyah.catalogmoviekotlin.data.model.MovieResponse
import io.reactivex.Single

interface ApiHelper {

    fun getMovieSearchApiCall(query: String?): Single<MovieResponse>

    fun getMovieNowPlayingApiCall(): Single<MovieResponse>

    fun getMovieUpcomingApiCall(): Single<MovieResponse>
}