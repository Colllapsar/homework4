package ru.netology.firsthomework

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val post = Post ("First post in our network!", "20 august 2020","Colllapsar",false, "0", "7", "1","Kaliningrad", 55.22 to 65.33)

        contentTv.text = post.content
        starDateTv.text = post.date
        authorTv.text = post.author
        numberOfLikesTv.text = post.numberOfLikes
        numberOfCommentsTv.text = post.numberOfComments
        numberOfSharesTv.text = post.numberOfShares
        addressTv.text = post.address
        coordinateTv.text = post.coordinate.toString()

        if (post.numberOfLikes=="0"){
            post.liked = false
            numberOfLikesTv.visibility = View.INVISIBLE
        }
        if (post.numberOfComments=="0"){
            numberOfCommentsTv.visibility = View.INVISIBLE
        }
        if (post.numberOfShares=="0"){
            numberOfSharesTv.visibility = View.INVISIBLE
        }
        var b = false
        if (post.liked){
            likeBtn.setImageResource(R.drawable.ic_baseline_like)
            b = true
        }

        likeBtn.setOnClickListener {
            post.liked = !post.liked
            likeBtn.setImageResource(
                if (post.liked) R.drawable.ic_baseline_like
                else R.drawable.ic_baseline_nolike
            )

            if (post.liked&&b) {
                numberOfLikesTv.text = post.numberOfLikes
                numberOfLikesTv.visibility = View.VISIBLE
            }
            if (!post.liked&&b) {
                val a = post.numberOfLikes.toInt()
                numberOfLikesTv.text = (a-1).toString()
                if (numberOfLikesTv.text=="0") numberOfLikesTv.visibility = View.INVISIBLE
            }
            if (post.liked&&!b) {
                val a = post.numberOfLikes.toInt()
                numberOfLikesTv.text = (a+1).toString()
                numberOfLikesTv.visibility = View.VISIBLE
            }
            if (!post.liked&&!b) {
                numberOfLikesTv.text = post.numberOfLikes
                if (numberOfLikesTv.text=="0") numberOfLikesTv.visibility = View.INVISIBLE
            }
        }
        val location = post.coordinate
        val(lat,lon) = location
        locationBtn.setOnClickListener{
            val intent = Intent().apply{
                action=Intent.ACTION_VIEW
                data = Uri.parse("geo:$lat,$lon")
            }
            startActivity(intent)
        }
}}