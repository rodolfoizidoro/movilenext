package com.example.rodolfoizidoro.movilenext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.rodolfoizidoro.movilenext.liveData.LiveDataTimerViewModel
import kotlinx.android.synthetic.main.activity_live_data.*

class LiveDataActivity : AppCompatActivity() {
    private val liveDataTimerViewModel by lazy {
        ViewModelProviders.of(this).get(LiveDataTimerViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        subscribe()
    }

    private fun subscribe() {
        val elapsedTimeObserver = Observer<Long>{
            tvTimer.text = "$it segundos se passaram"
        }
        liveDataTimerViewModel.elapsedTime
            .observe(this, elapsedTimeObserver)
    }
}
