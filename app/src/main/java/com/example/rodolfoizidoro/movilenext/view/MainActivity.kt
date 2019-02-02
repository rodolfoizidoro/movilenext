package com.example.rodolfoizidoro.movilenext.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rodolfoizidoro.movilenext.R
import com.example.rodolfoizidoro.movilenext.adapter.ProgrammingLanguageAdapter
import com.example.rodolfoizidoro.movilenext.model.ProgrammingLanguage
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = ProgrammingLanguageAdapter(this, recyclerViewItems()) {
            longToast("Clicked item: ${it.title}")
        }
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }

    private fun recyclerViewItems() : List<ProgrammingLanguage> {
        val item = ProgrammingLanguage(R.drawable.kotlin, "kotlin", 2010, "Kotlin description")
        return listOf(item, item)
    }

}
