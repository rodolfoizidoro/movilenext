package com.example.rodolfoizidoro.movilenext.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.rodolfoizidoro.movilenext.R
import com.example.rodolfoizidoro.movilenext.model.ProgrammingLanguage
import kotlinx.android.synthetic.main.program_language_item.view.*

class ProgrammingLanguageAdapter(
    private val context: Context,
    private val items: List<ProgrammingLanguage>,
    private val listener: (ProgrammingLanguage) -> Unit
) : Adapter<ProgrammingLanguageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(context)
            .inflate(R.layout.program_language_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item, listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(item: ProgrammingLanguage, listener: (ProgrammingLanguage) -> Unit) = with(itemView) {
            ivMain.setImageDrawable(ContextCompat.getDrawable(context, item.imageResId))
            tvTitle.text = item.title
            tvLaunchYear.text = item.year.toString()
            tvDescription.text = item.description

            setOnClickListener { listener(item) }
        }
    }
}
