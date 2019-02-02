package com.example.rodolfoizidoro.movilenext.seekBar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.rodolfoizidoro.movilenext.R

class SeekBarFragment : Fragment() {

    private lateinit var seekBar: SeekBar
    private lateinit var seekBarViewModel: SeekBarViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_seek_bar, container, false)
        seekBar = root.findViewById(R.id.seekBar)

        activity?.let {
            seekBarViewModel = ViewModelProviders.of(it).get(SeekBarViewModel::class.java)

            subscribeSeekBar()
        }

        return root
    }

    private fun subscribeSeekBar() {
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    seekBarViewModel.seekBarValue.value = progress
                }

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        seekBarViewModel.seekBarValue.observe(this, Observer {
            seekBar.progress = it
        })
    }


}
