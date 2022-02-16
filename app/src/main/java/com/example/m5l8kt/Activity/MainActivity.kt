package com.example.m5l8kt.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m5l8kt.Adapter.FeedAdapter
import com.example.m5l8kt.Adapter.StoryAdapter
import com.example.m5l8kt.Model.Post
import com.example.m5l8kt.Model.Story
import com.example.m5l8kt.R

class MainActivity : AppCompatActivity() {
    lateinit var recyclerViewFeed: RecyclerView
    lateinit var recyclerViewStory: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }
    fun initViews(){
        recyclerViewFeed = findViewById(R.id.recyclerViewFeed)
        recyclerViewFeed.setLayoutManager(GridLayoutManager(this,1))

        recyclerViewStory = findViewById(R.id.recyclerViewStory)
        recyclerViewStory.setLayoutManager(LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false))

        refreshAdapterFeed(getAllFeeds())
        refreshAdapterStory(getAllStories())
    }

    fun refreshAdapterStory(stories:ArrayList<Story>){
        val adapter = StoryAdapter(this,stories)
        recyclerViewStory.adapter = adapter
    }

    fun refreshAdapterFeed(posts:ArrayList<Post>){
        val adapter = FeedAdapter(this,posts)
        recyclerViewFeed.adapter = adapter
    }

    fun getAllStories():ArrayList<Story>{
        val stories:ArrayList<Story> = ArrayList()

        stories.add(Story(R.drawable.img_2,"Odilbek"))
        stories.add(Story(R.drawable.img_2,"Odilbek"))
        stories.add(Story(R.drawable.img_2,"Odilbek"))
        stories.add(Story(R.drawable.img_2,"Odilbek"))
        stories.add(Story(R.drawable.img_2,"Odilbek"))
        stories.add(Story(R.drawable.img_2,"Odilbek"))
        stories.add(Story(R.drawable.img_2,"Odilbek"))
        stories.add(Story(R.drawable.img_2,"Odilbek"))
        stories.add(Story(R.drawable.img_2,"Odilbek"))
        stories.add(Story(R.drawable.img_2,"Odilbek"))


        return stories
    }

    fun getAllFeeds():ArrayList<Post>{
        val posts:ArrayList<Post> = ArrayList()

        posts.add(Post("https://yt3.ggpht.com/pl-pa9hLg5NS2sXUlKsvpDwoinfjlKzYb8cM0zqGVxUUBDeRbGegGZbC8QRcPj62yiFzYN70Lg=s176-c-k-c0x00ffffff-no-rj-mo","PDP Academy",R.drawable.img_1))
        posts.add(Post("https://media-exp1.licdn.com/dms/image/C4E03AQG58zU3QFex_Q/profile-displayphoto-shrink_100_100/0/1619045767367?e=1650499200&v=beta&t=jQiHfSskTruaN_bs208jA2Fmcd-3fNoZKsi8-x2oJSw","Yahya Mahmudiy",R.drawable.img_1,R.drawable.img_1))
        posts.add(Post("https://media-exp1.licdn.com/dms/image/C4E03AQG58zU3QFex_Q/profile-displayphoto-shrink_100_100/0/1619045767367?e=1650499200&v=beta&t=jQiHfSskTruaN_bs208jA2Fmcd-3fNoZKsi8-x2oJSw","Yahya Mahmudiy",R.drawable.img_1))
        posts.add(Post("https://yt3.ggpht.com/pl-pa9hLg5NS2sXUlKsvpDwoinfjlKzYb8cM0zqGVxUUBDeRbGegGZbC8QRcPj62yiFzYN70Lg=s176-c-k-c0x00ffffff-no-rj-mo","PDP Academy","mF6Q92hcmZY"))
        posts.add(Post("https://media-exp1.licdn.com/dms/image/C4E03AQG58zU3QFex_Q/profile-displayphoto-shrink_100_100/0/1619045767367?e=1650499200&v=beta&t=jQiHfSskTruaN_bs208jA2Fmcd-3fNoZKsi8-x2oJSw","Yahya Mahmudiy",R.drawable.img_1,R.drawable.img_1))
        posts.add(Post("https://media-exp1.licdn.com/dms/image/C4E03AQG58zU3QFex_Q/profile-displayphoto-shrink_100_100/0/1619045767367?e=1650499200&v=beta&t=jQiHfSskTruaN_bs208jA2Fmcd-3fNoZKsi8-x2oJSw","Yahya Mahmudiy",R.drawable.img_1))

        return posts
    }
}