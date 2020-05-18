package com.javo_soft.solarsystemapp.util

import android.content.Context
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.request.RequestOptions
import com.javo_soft.solarsystemapp.R

fun getRequestOptions(context: Context): RequestOptions {
    return RequestOptions()
        .placeholder(getCircularProgressDrawable(context))
        .error(R.mipmap.ic_launcher)
}

private fun getCircularProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 5f
        centerRadius = 20f
        start()
    }
}