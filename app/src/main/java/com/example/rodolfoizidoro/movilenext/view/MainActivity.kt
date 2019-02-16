package com.example.rodolfoizidoro.movilenext.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rodolfoizidoro.movilenext.R
import com.example.rodolfoizidoro.movilenext.databinding.ActivityMainBinding
import com.example.rodolfoizidoro.movilenext.model.Game
import com.example.rodolfoizidoro.movilenext.util.SetContentView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val binding: ActivityMainBinding by SetContentView(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        // val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val game = Game(
            "Donkey Kong",
            1981,
            5.5,
            "https://upload.wikimedia.org/wikipedia/pt/thumb/5/5c/Donkey_Kong.png/220px-Donkey_Kong.png"
        )
        binding.game = game

        tvRating.setOnClickListener {
            game.rating += 1
        }
    }

}
