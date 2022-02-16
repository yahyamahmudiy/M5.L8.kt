package com.example.m5l8kt.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.m5l8kt.Model.Story
import com.example.m5l8kt.R
import com.google.android.material.imageview.ShapeableImageView

class StoryAdapter(var context: Context, var items:ArrayList<Story>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_story,parent,false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if (holder is StoryViewHolder){
            val iv_profile = holder.iv_profile
            val tv_fullname = holder.tv_fullname

            iv_profile.setImageResource(feed.profile)
            tv_fullname.text = feed.fullname
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class StoryViewHolder(view: View):RecyclerView.ViewHolder(view){
        var iv_profile:ShapeableImageView
        var tv_fullname:TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            tv_fullname = view.findViewById(R.id.tv_fullname)
        }
    }
}