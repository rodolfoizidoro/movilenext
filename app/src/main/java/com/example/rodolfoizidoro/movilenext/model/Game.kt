package com.example.rodolfoizidoro.movilenext.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.rodolfoizidoro.movilenext.BR

class Game(val name: String, val launchYear: Int, rating: Double, val imageUrl: String) : BaseObservable() {
    fun isClassic(): Boolean = launchYear < 2000

    var rating = rating
        @Bindable get
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.rating)
            }
        }
}
