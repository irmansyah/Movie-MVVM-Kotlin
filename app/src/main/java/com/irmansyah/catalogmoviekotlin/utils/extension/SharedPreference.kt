package com.irmansyah.iniBolaku.utils.extension

import android.content.SharedPreferences

/**
 * Created by irmansyah on 25/03/18.
 */
inline fun SharedPreferences.edit(block: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.block()
    editor.apply()
}