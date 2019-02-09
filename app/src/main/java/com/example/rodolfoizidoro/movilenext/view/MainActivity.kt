package com.example.rodolfoizidoro.movilenext.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rodolfoizidoro.movilenext.R
import com.example.rodolfoizidoro.movilenext.adapter.ProgrammingLanguageAdapter
import com.example.rodolfoizidoro.movilenext.adapter.RepositoryAdapter
import com.example.rodolfoizidoro.movilenext.api.GithubRepositoriesResult
import com.example.rodolfoizidoro.movilenext.api.RepositoryRetriever
import com.example.rodolfoizidoro.movilenext.model.ProgrammingLanguage
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private val repositoryRetriever = RepositoryRetriever()

    private val callback = object : Callback<GithubRepositoriesResult> {
        override fun onFailure(call: Call<GithubRepositoriesResult>, t: Throwable) {
            longToast("Load failure")
        }


        override fun onResponse(call: Call<GithubRepositoriesResult>, response: Response<GithubRepositoriesResult>) {
            longToast("load finished")

            response.body()?.repositories.let { repositories ->
                recyclerView.adapter = RepositoryAdapter(this@MainActivity, repositories!!) {
                    longToast("Clicked item: ${it.full_name}")
                }
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadDefaultRecyclerView()
    }

    private fun loadDefaultRecyclerView() {
        recyclerView.adapter = ProgrammingLanguageAdapter(this, recyclerViewItems()) {
            longToast("Loading item: ${it.title} repositories...")
            repositoryRetriever.getLanguageRepositories(callback, it.title)
        }
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }

    private fun recyclerViewItems(): List<ProgrammingLanguage> {
        val item = ProgrammingLanguage(R.drawable.kotlin, "kotlin", 2010, "Kotlin description")
        return listOf(item, item)
    }

}
