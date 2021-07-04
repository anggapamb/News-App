package com.anggapambudi.topnews.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.anggapambudi.topnews.R
import com.anggapambudi.topnews.model.ArticlesItem
import com.bumptech.glide.Glide
import org.jetbrains.anko.sdk27.coroutines.onClick

class TopNewsRecyclerViewAdapter(private val context: Context, private val list: ArrayList<ArticlesItem>):
        RecyclerView.Adapter<TopNewsRecyclerViewAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private lateinit var tvPhotoNews: ImageView
        private lateinit var tvTitleNews: TextView
        fun bind(articlesItem: ArticlesItem) {

            tvPhotoNews = itemView.findViewById(R.id.tvPhoto)
            tvTitleNews = itemView.findViewById(R.id.tvTitle)

            Glide.with(itemView.context).load(articlesItem.urlToImage).into(tvPhotoNews)
            tvTitleNews.text = articlesItem.title

            itemView.onClick {
                Toast.makeText(itemView.context, "${articlesItem.title}", Toast.LENGTH_SHORT).show()
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= NewsViewHolder(
        LayoutInflater.from(context).inflate(R.layout.item_news_today, parent, false)
    )

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}