package com.example.rodolfoizidoro.movilenext.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rodolfoizidoro.movilenext.R
import com.example.rodolfoizidoro.movilenext.adapter.WordListAdapter
import com.example.rodolfoizidoro.movilenext.entities.Word
import com.example.rodolfoizidoro.movilenext.viewmodel.WordViewModel

import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.content_main2.*
import org.jetbrains.anko.toast

class Main2Activity : AppCompatActivity() {
    companion object {
        const val NEW_WORD_ACTIVITY_REQUEST_CODE = 1
    }

    private lateinit var wordViewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(toolbar)

        val adapter = WordListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        wordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)
        wordViewModel.allWords.observe(this, Observer {
            adapter.words = it
        })

        fab.setOnClickListener {
            val intent = Intent(
                this@Main2Activity,
                NewWordActivity::class.java
            )
            startActivityForResult(
                intent,
                NEW_WORD_ACTIVITY_REQUEST_CODE
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE &&
            resultCode == Activity.RESULT_OK
        ) {
            data?.let {
                val word =
                    Word(it.getStringExtra(NewWordActivity.EXTRA_REPLY))
                wordViewModel.insert(word)
            }
        } else {
            toast(R.string.empty_not_saved)
        }
    }
}
