package com.example.rodolfoizidoro.movilenext.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rodolfoizidoro.movilenext.R
import com.example.rodolfoizidoro.movilenext.entities.Word

class WordListAdapter(context: Context) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {
    private val inflater = LayoutInflater.from(context)
    var words: List<Word> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)

        return WordViewHolder(itemView)
    }

    override fun getItemCount(): Int = words.size

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
            holder.wordItemView.text = words[position].word
    }


    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView = itemView.findViewById<TextView>(R.id.textView)
    }
}
