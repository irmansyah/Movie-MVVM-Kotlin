package com.irmansyah.iniBolaku.utils.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by irmansyah on 25/03/18.
 */
internal fun ImageView.loadImage(url: String) {
    if (!url.isEmpty()) { Glide.with(this.context).load(url).asBitmap().centerCrop().into(this) }
}