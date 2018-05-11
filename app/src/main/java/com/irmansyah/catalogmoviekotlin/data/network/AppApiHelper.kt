package com.irmansyah.catalogmoviekotlin.data.network

import android.content.Context
import com.irmansyah.catalogmoviekotlin.data.model.MovieResponse
import io.reactivex.Single
import javax.inject.Inject

class AppApiHelper @Inject constructor(context: Context) : ApiHelper {

    override fun getMovieSearchApiCall(query: String?): Single<MovieResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMovieNowPlayingApiCall(): Single<MovieResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMovieUpcomingApiCall(): Single<MovieResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}