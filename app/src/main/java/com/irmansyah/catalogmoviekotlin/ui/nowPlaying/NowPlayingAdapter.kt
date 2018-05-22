package com.irmansyah.catalogmoviekotlin.ui.nowPlaying

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.irmansyah.catalogmoviekotlin.BuildConfig
import com.irmansyah.catalogmoviekotlin.R
import com.irmansyah.catalogmoviekotlin.data.DataManager
import com.irmansyah.catalogmoviekotlin.data.model.Movie
import com.irmansyah.catalogmoviekotlin.ui.base.BaseAppAdapter
import com.irmansyah.catalogmoviekotlin.ui.base.BaseViewHolder
import com.irmansyah.catalogmoviekotlin.utils.SchedulerProvider
import com.irmansyah.iniBolaku.utils.extension.loadImage
import kotlinx.android.synthetic.main.item_now_playing_list.view.*

class NowPlayingAdapter constructor(private val dataItemList: MutableList<Movie>, private val dataManager: DataManager, private val schedulerProvider: SchedulerProvider) : BaseAppAdapter() {

    override fun getItemCount(): Int = this.dataItemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
            NowPlayingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_now_playing_list, parent, false))


    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) = holder.let {
        holder.clear()
        holder.onBind(position)
    }

    fun addNowPlayingToList(movies: List<Movie>?) {
        movies?.let {
            this.dataItemList.addAll(it)
            notifyDataSetChanged()
        }
    }

    fun clearItems() {
        this.dataItemList.clear()
    }

    inner class NowPlayingViewHolder(view: View) : BaseViewHolder(view) {

        override fun clear() {
            itemView.now_playing_img.setImageDrawable(null)
            itemView.now_playing_title_tv.text =""
            itemView.now_playing_release_date_tv.text = ""
            itemView.now_playing_overview_tv.text =""
        }

        override fun onBind(position: Int) {
            inflateData(dataItemList[position])
        }

        private fun inflateData(movie: Movie) {

            movie.posterPath?.let { itemView.now_playing_img.loadImage(BuildConfig.BASE_URL_POSTER_PATH_SMALL + it) }
            itemView.now_playing_title_tv.text = movie.title
            itemView.now_playing_release_date_tv.text = movie.releaseDate
            itemView.now_playing_overview_tv.text = movie.overview

            setItemClickListener(movie.title)
        }

        private fun setItemClickListener(title: String?) {
            val context = itemView.context
            itemView.now_playing_goto_detail_btn.setOnClickListener {
                Toast.makeText(context, "Go to detail", Toast.LENGTH_SHORT).show()
            }

            itemView.now_playing_share_btn.setOnClickListener {
                Toast.makeText(context, "This is $title", Toast.LENGTH_SHORT).show()
            }
        }
    }
}