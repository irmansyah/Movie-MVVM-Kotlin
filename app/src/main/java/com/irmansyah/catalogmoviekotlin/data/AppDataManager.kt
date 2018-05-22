package com.irmansyah.catalogmoviekotlin.data

import android.content.Context
import com.irmansyah.catalogmoviekotlin.data.model.MovieResponse
import com.irmansyah.catalogmoviekotlin.data.network.ApiHelper
import io.reactivex.Single
import javax.inject.Inject

class AppDataManager @Inject constructor(private val context: Context, private val apiHelper: ApiHelper) : DataManager {

    override fun getMovieSearchApiCall(query: String?): Single<MovieResponse> = apiHelper.getMovieSearchApiCall(query)

    override fun getMovieNowPlayingApiCall(): Single<MovieResponse> = apiHelper.getMovieNowPlayingApiCall()

    override fun getMovieUpcomingApiCall(): Single<MovieResponse>  = apiHelper.getMovieUpcomingApiCall()
}