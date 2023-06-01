package com.example.task4.util

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

fun ImageView.downloadFromUrl(url: String) {
    Picasso.get()
        .load(url)
        .into(this)
}

fun View.showSnackBar(message: String) {
    val snackBar = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
    snackBar.setTextColor(Color.WHITE)
    snackBar.setBackgroundTint(Color.RED)
    snackBar.show()
}