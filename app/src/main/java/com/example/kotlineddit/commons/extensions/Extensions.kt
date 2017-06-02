@file:JvmName("ExtensionsUtils")

package com.example.kotlineddit.commons.extensions

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.kotlineddit.R
import com.squareup.picasso.Picasso


fun ViewGroup.inflate(layoutId: Int, attachToRoute: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoute)
}

fun ImageView.loadImg(imageUrl: String) {
    if(TextUtils.isEmpty(imageUrl)) {
        Picasso.with(context).load(R.mipmap.ic_launcher).into(this)
    } else {
        Picasso.with(context).load(imageUrl).into(this)
    }
}