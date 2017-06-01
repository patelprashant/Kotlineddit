@file:JvmName("ExtensionsUtils")

package com.example.kotlineddit.commons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


fun ViewGroup.inflate(layoutId: Int, attachToRoute: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoute)
}