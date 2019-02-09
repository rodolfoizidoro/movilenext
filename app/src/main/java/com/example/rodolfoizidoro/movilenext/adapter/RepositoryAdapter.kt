package com.example.rodolfoizidoro.movilenext.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.rodolfoizidoro.movilenext.R
import com.example.rodolfoizidoro.movilenext.api.Repository
import com.example.rodolfoizidoro.movilenext.util.ActionR
import kotlinx.android.synthetic.main.repository_item.view.*

class RepositoryAdapter(
    private val context: Context,
    private val items: List<Repository>,
    private val listener: ActionR
) : Adapter<RepositoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(context)
            .inflate(R.layout.repository_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item, listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(item: Repository, listener: ActionR) = with(itemView) {
            Glide.with(context)
                .load(item.owner?.avatar_url)
                .into(ivMain)
            tvTitle.text = item.name
            tvOwner.text = item.owner?.login
            tvDescription.text = item.description

            setOnClickListener { listener(item) }
        }
    }
}
