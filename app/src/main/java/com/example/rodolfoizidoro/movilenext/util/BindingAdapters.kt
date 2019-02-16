package com.example.rodolfoizidoro.movilenext.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("app:imageUrl")
fun loadImage(imageView: ImageView, imageUrl: String?){
    //Load image logic
    Picasso.get().load(imageUrl).into(imageView)
}
