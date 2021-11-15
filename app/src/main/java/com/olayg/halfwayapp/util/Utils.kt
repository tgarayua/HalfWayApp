package com.olayg.halfwayapp.util

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

val ViewGroup.layoutInflater: LayoutInflater get() = LayoutInflater.from(context)

fun ImageView.loadUrl(url: String?) {
    Glide.with(this).load(url).into(this)
}


fun String.logMe(){
    Log.d("HalfWayAppTag", this)
}