package com.irmansyah.catalogmoviekotlin.utils

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.RatingBar
import com.bumptech.glide.Glide
import com.irmansyah.catalogmoviekotlin.data.model.Movie
import com.irmansyah.catalogmoviekotlin.ui.nowPlaying.NowPlayingAdapter
import com.irmansyah.catalogmoviekotlin.ui.upcoming.UpcomingAdapter
import java.util.ArrayList

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(view: ImageView, url: String) {
        if (!url.isEmpty()) { Glide.with(view.context).load(url).asBitmap().centerCrop().into(view) }

    }

    @JvmStatic
    @BindingAdapter("nowPlayingAdapter")
    fun addNowPlayingItems(view: RecyclerView, datas: ArrayList<Movie>?) {
        val adapter = view.adapter as NowPlayingAdapter?
        if (adapter != null) {
            adapter.clearItems()
            datas?.let { adapter.addNowPlayingToList(it) }
        }
    }

    @JvmStatic
    @BindingAdapter("upcomingAdapter")
    fun addUpcomingItems(view: RecyclerView, datas: ArrayList<Movie>?) {
        val adapter = view.adapter as UpcomingAdapter?
        if (adapter != null) {
            adapter.clearItems()
            datas?.let { adapter.addUpcomingToList(it) }
        }
    }
}