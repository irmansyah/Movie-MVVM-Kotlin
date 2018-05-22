package com.irmansyah.catalogmoviekotlin.ui.upcoming

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
import kotlinx.android.synthetic.main.item_upcoming_list.view.*

class UpcomingAdapter constructor(private val dataItemList: MutableList<Movie>, private val dataManager: DataManager, private val schedulerProvider: SchedulerProvider) : BaseAppAdapter() {

    override fun getItemCount(): Int = this.dataItemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
            UpcomingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_upcoming_list, parent, false))

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) = holder.let {
        holder.clear()
        holder.onBind(position)
    }

    fun addUpcomingToList(movies: List<Movie>?) {
        movies?.let {
            this.dataItemList.addAll(it)
            notifyDataSetChanged()
        }
    }

    fun clearItems() {
        this.dataItemList.clear()
    }

    inner class UpcomingViewHolder(view: View): BaseViewHolder(view) {

        override fun clear() {
            itemView.upcoming_img.setImageDrawable(null)
            itemView.upcoming_title_tv.text = ""
        }

        override fun onBind(position: Int) {
            inflateData(dataItemList[position])
        }

        private fun inflateData(movie: Movie) {

            movie.posterPath?.let { itemView.upcoming_img.loadImage(BuildConfig.BASE_URL_POSTER_PATH_SMALL + it) }
            itemView.upcoming_title_tv.text = movie.title

            setItemClickListener()
        }

        private fun setItemClickListener() {
            val context = itemView.context
            itemView.upcoming_root.setOnClickListener {
                Toast.makeText(context, "Go to detail", Toast.LENGTH_SHORT).show()
            }
        }
    }
}