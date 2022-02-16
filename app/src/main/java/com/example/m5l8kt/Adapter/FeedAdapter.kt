package com.example.m5l8kt.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.m5l8kt.Model.Post
import com.example.m5l8kt.R
import com.google.android.material.imageview.ShapeableImageView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class FeedAdapter(var context: Context,var items:ArrayList<Post>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post,parent,false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if (holder is FeedViewHolder){
            val iv_profile = holder.iv_profile
            val iv_post = holder.iv_post
            val iv_post2 = holder.iv_post2
            val tv_fullname = holder.tv_fullname
            val vv_video = holder.vv_video
            //var linear = holder.linear

            //iv_profile.setImageResource(feed.profile)
            iv_post.setImageResource(feed.photo)
            iv_post2.setImageResource(feed.photo2)
            tv_fullname.text = feed.fullname

            Glide.with(context)
                .load(feed.profile)
                .into(iv_profile)

            vv_video.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.loadVideo(feed.video,0f)
                }
            })

            if (feed.photo2 != 0){
                iv_post2.visibility = View.VISIBLE
            }
            if (feed.video != ""){
                vv_video.visibility = View.VISIBLE
                iv_post.visibility = View.GONE
            }
        }


    }

    override fun getItemCount(): Int {
        return items.size
    }

    class FeedViewHolder(view: View):RecyclerView.ViewHolder(view){
        var iv_profile:ShapeableImageView
        var iv_post:ShapeableImageView
        var iv_post2:ShapeableImageView
        var tv_fullname:TextView
        var vv_video:YouTubePlayerView
        var linear:LinearLayout

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            iv_post = view.findViewById(R.id.iv_post)
            iv_post2 = view.findViewById(R.id.iv_post2)
            tv_fullname = view.findViewById(R.id.tv_fullname)
            vv_video = view.findViewById(R.id.video)
            linear = view.findViewById(R.id.linear)
        }
    }
}