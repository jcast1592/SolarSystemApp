package com.javo_soft.solarsystemapp.util

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(uri: String?) {
    val context = context
    Glide.with(context)
        .setDefaultRequestOptions(getRequestOptions(context))
        .load(uri)
        .into(this)
}
