package com.example.rodolfoizidoro.movilenext.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.rodolfoizidoro.movilenext.R
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.BackpressureStrategy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.Flowables
import kotlinx.android.synthetic.main.activity_game_add.*
import java.util.concurrent.TimeUnit

class GameAddActivity : AppCompatActivity() {

    lateinit var disposable : Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_add)

        val nameChangesObservable =
            RxTextView
                .textChanges(etName)
                .skipInitialValue()
                .debounce(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .toFlowable(BackpressureStrategy.LATEST)
        val yearChangesObservable =
            RxTextView
                .textChanges(etYear)
                .skipInitialValue()
                .debounce(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .toFlowable(BackpressureStrategy.LATEST)

        disposable=  Flowables.combineLatest(
            nameChangesObservable,
            yearChangesObservable
        ) { newName: CharSequence, newYear: CharSequence ->

            val nameValid = newName.length > 4
            if(!nameValid) {
                etName.error = "invalid namer"
            }

            val yearValid = newYear.length == 4
            if(!yearValid) {
                etYear.error = "invalid year"
            }

            nameValid && yearValid

        }.subscribe{
                formValid ->
            btAdd.setBackgroundColor(ContextCompat.getColor(applicationContext, if(formValid) R.color.colorPrimaryDark else R.color.colorAccent))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}
